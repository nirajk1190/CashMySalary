package com.cashmysalary.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cashmysalary.R;
import com.cashmysalary.adapter.UpComingPaymentAdapter;
import com.cashmysalary.model.UpComingPaymentModel;
import com.cashmysalary.util.Util;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class UpComingPaymentsAct extends AppCompatActivity {
    private Context mContext;
    private String TAG = UpComingPaymentsAct.class.getSimpleName();
    private RecyclerView rvData;
    private Toolbar toolbar;
    private ArrayList<UpComingPaymentModel> upComingPaymentModelArrayList;
    private UpComingPaymentAdapter upComingPaymentAdapter;
    private RelativeLayout mainContent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upcoming);
        mContext = UpComingPaymentsAct.this;

        init();
        applyInit();
    }

    private void applyInit() {
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
        toolbar.setTitle(getResources().getString(R.string.home_upcoming_payments));
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));

        upComingPaymentModelArrayList = new ArrayList<>();
        upComingPaymentAdapter = new UpComingPaymentAdapter(mContext, upComingPaymentModelArrayList);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rvData.setLayoutManager(mLayoutManager);
        rvData.setItemAnimator(new DefaultItemAnimator());
        rvData.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        rvData.setAdapter(upComingPaymentAdapter);

        fetchList();

    }

    private void fetchList() {
        upComingPaymentModelArrayList.clear();

        try {
            String json = Util.getAssetJsonResponse(mContext, "upcoming_payment_list.json");
            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.optJSONArray("fields");
            assert jsonArray != null;
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject1 = jsonArray.optJSONObject(i);
                UpComingPaymentModel upComingPaymentModel = new UpComingPaymentModel();
                upComingPaymentModel.id = jsonObject1.optInt("id");
                upComingPaymentModel.loanId = jsonObject1.optString("loanId");
                upComingPaymentModel.status = jsonObject1.optString("status");
                upComingPaymentModel.loanAmount = jsonObject1.optInt("loanAmount");
                upComingPaymentModel.dueDate = jsonObject1.optString("dueDate");
                upComingPaymentModel.repaymentAmt = jsonObject1.optInt("repaymentAmt");
                upComingPaymentModel.dueAmountToday = jsonObject1.optInt("dueAmountToday");
                upComingPaymentModelArrayList.add(upComingPaymentModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void init() {
        mainContent = findViewById(R.id.mainContent);
        toolbar = findViewById(R.id.toolbar);
        rvData = findViewById(R.id.rvData);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

