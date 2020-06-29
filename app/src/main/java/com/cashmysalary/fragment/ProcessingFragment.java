package com.cashmysalary.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cashmysalary.R;
import com.cashmysalary.activity.LoanHistoryDetailActivity;
import com.cashmysalary.adapter.InProcessAdapter;
import com.cashmysalary.model.InProcessModel;
import com.cashmysalary.util.Util;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class ProcessingFragment extends Fragment implements InProcessAdapter.ItemClick {
    public static final String TITLE = "IN-PROCESS";
    private ArrayList<InProcessModel> inProcessModelArrayList;
    private RecyclerView rvData;
    private View main;
    private InProcessAdapter inProcessAdapter;

    //Overriden method onCreateView
    public static ProcessingFragment newInstance() {

        return new ProcessingFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Returning the layout file after inflating
        //Change R.layout.tab1 in you classes
        main = inflater.inflate(R.layout.processing_fragment, container, false);
        init();
        applyInit();
        return main;
    }

    private void applyInit() {
        inProcessModelArrayList = new ArrayList<>();
        inProcessAdapter = new InProcessAdapter(getActivity(), inProcessModelArrayList, this);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        rvData.setLayoutManager(mLayoutManager);
        rvData.setAdapter(inProcessAdapter);

        fetchList();
    }

    private void fetchList() {
        inProcessModelArrayList.clear();

        try {
            String json = Util.getAssetJsonResponse(getActivity(), "in_process_loan_list.json");
            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.optJSONArray("fields");
            assert jsonArray != null;
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject1 = jsonArray.optJSONObject(i);
                InProcessModel inProcessModel = new InProcessModel();
                inProcessModel.id = jsonObject1.optInt("id");
                inProcessModel.loanId = jsonObject1.optString("loanId");
                inProcessModel.status = jsonObject1.optString("status");
                inProcessModel.applicationDate = jsonObject1.optString("applicationDate");
                inProcessModel.loanAmount = jsonObject1.optInt("loanAmount");
                inProcessModel.loanDuration = jsonObject1.optInt("loanDuration");
                inProcessModel.dueDate = jsonObject1.optString("dueDate");
                inProcessModel.repaymentAmt = jsonObject1.optInt("repaymentAmt");
                inProcessModel.dueAmountToday = jsonObject1.optInt("dueAmountToday");
                inProcessModelArrayList.add(inProcessModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void init() {
        rvData = main.findViewById(R.id.rvData);

    }

    @Override
    public void onItemClick(int pos) {
        InProcessModel inProcessModel = inProcessModelArrayList.get(pos);
        Intent i = new Intent(getActivity(), LoanHistoryDetailActivity.class);
        i.putExtra("loanAmount", inProcessModel.loanAmount);
        i.putExtra("tenure", inProcessModel.loanDuration);
        i.putExtra("loanType", "PL");
        i.putExtra("applicationDate", inProcessModel.applicationDate);
        i.putExtra("loanNumber", inProcessModel.loanId);
        startActivity(i);
    }
}