package com.cashmysalary.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cashmysalary.R;
import com.cashmysalary.adapter.FinishedAdapter;
import com.cashmysalary.model.FinishedModel;
import com.cashmysalary.util.Util;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class FinishedFragment extends Fragment {
    public static final String TITLE = "FINISHED";
    private View main;
    private ArrayList<FinishedModel> finishedModelArrayList;
    private RecyclerView rvData;
    private FinishedAdapter finishedAdapter;

    //Overriden method onCreateView
    public static FinishedFragment newInstance() {

        return new FinishedFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        main = inflater.inflate(R.layout.finished_fragment, container, false);
        init();
        applyInit();

        return main;
    }

    private void applyInit() {
        finishedModelArrayList = new ArrayList<>();
        finishedAdapter = new FinishedAdapter(getActivity(), finishedModelArrayList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        rvData.setLayoutManager(mLayoutManager);
        rvData.setAdapter(finishedAdapter);

        fetchList();
    }

    private void fetchList() {
        finishedModelArrayList.clear();

        try {
            String json = Util.getAssetJsonResponse(getActivity(), "finished_loan_list.json");
            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.optJSONArray("fields");
            assert jsonArray != null;
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject1 = jsonArray.optJSONObject(i);
                FinishedModel finishedModel = new FinishedModel();
                finishedModel.id = jsonObject1.optInt("id");
                finishedModel.loanId = jsonObject1.optString("loanId");
                finishedModel.status = jsonObject1.optString("status");
                finishedModel.loanAmount = jsonObject1.optInt("loanAmount");
                finishedModel.dueDate = jsonObject1.optString("dueDate");
                finishedModel.repaymentAmt = jsonObject1.optInt("repaymentAmt");
                finishedModel.paidAmount = jsonObject1.optInt("paidAmount");
                finishedModelArrayList.add(finishedModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void init() {
        rvData = main.findViewById(R.id.rvData);

    }
}
