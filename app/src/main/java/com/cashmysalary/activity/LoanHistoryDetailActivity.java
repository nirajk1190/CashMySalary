package com.cashmysalary.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cashmysalary.R;
import com.cashmysalary.adapter.LoanRecordDetailAdapter;
import com.cashmysalary.model.LoanRecordItemDetailModel;
import com.cashmysalary.util.Util;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class LoanHistoryDetailActivity extends AppCompatActivity {
    private Context mContext;
    private String TAG = LoanHistoryDetailActivity.class.getSimpleName();
    private RelativeLayout rlPlanContent;
    private TextView tvLoanNumber,tvLoanAmt,tvLoanDuration,tvApplicationDate,tvDisbursalAmt,tvInterest,tvProcessingFee,tvGST,tvRepayment;
    private int loanAmount,loanDuration;
    private String applicationDate,loanNumber,loanType;
    private ArrayList<LoanRecordItemDetailModel> loanRecordItemDetailModels = new ArrayList<>();
    private RecyclerView rvData;
    private LoanRecordDetailAdapter loanRecordDetailAdapter;
    private Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_history_detail);
        mContext = LoanHistoryDetailActivity.this;
        Intent i = getIntent();
        loanAmount = i.getIntExtra("loanAmount",0);
        loanDuration = i.getIntExtra("tenure",0);
        applicationDate = i.getStringExtra("applicationDate");
        loanNumber = i.getStringExtra("loanNumber");
        loanType = i.getStringExtra("loanType");
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
        toolbar.setTitle(getResources().getString(R.string.loan_record_detail_toolbar_title));
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));


        tvLoanNumber.setText(loanNumber);
        tvLoanAmt.setText(getResources().getString(R.string.rs)+" "+loanAmount+"");
        tvLoanDuration.setText(loanDuration+" Days");
        tvApplicationDate.setText(applicationDate);
        tvInterest.setText(getResources().getString(R.string.rs)+" "+"3000");


        tvProcessingFee.setText(getResources().getString(R.string.rs)+" "+"3000");
        tvGST.setText(getResources().getString(R.string.rs)+" "+"540");
        tvRepayment.setText(getResources().getString(R.string.rs)+" "+"33000");
        tvDisbursalAmt.setText(getResources().getString(R.string.rs)+" "+"27000");

        fetchList();

        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        rvData.setLayoutManager(layoutManager);
        loanRecordDetailAdapter = new LoanRecordDetailAdapter(this, loanRecordItemDetailModels);
        rvData.setAdapter(loanRecordDetailAdapter);

        if (loanType.equalsIgnoreCase("EL")){
            rlPlanContent.setVisibility(View.VISIBLE);
        }else {
            rlPlanContent.setVisibility(View.GONE);
        }
    }

    private void init() {
        toolbar = findViewById(R.id.toolbar);
        rlPlanContent = findViewById(R.id.rlPlanContent);
        rvData = findViewById(R.id.rvData);

        tvLoanNumber = findViewById(R.id.tvLoanNumber);
        tvLoanAmt = findViewById(R.id.tvLoanAmt);
        tvLoanDuration = findViewById(R.id.tvLoanDuration);
        tvApplicationDate = findViewById(R.id.tvApplicationDate);
        tvDisbursalAmt = findViewById(R.id.tvDisbursalAmt);
        tvInterest = findViewById(R.id.tvInterest);
        tvInterest = findViewById(R.id.tvInterest);
        tvProcessingFee = findViewById(R.id.tvProcessingFee);
        tvGST = findViewById(R.id.tvGST);
        tvRepayment = findViewById(R.id.tvRepayment);
    }
    private void fetchList() {
        loanRecordItemDetailModels.clear();
        try{
            String json = Util.getAssetJsonResponse(mContext,"loan_term_list.json");
            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.optJSONArray("fields");
            assert jsonArray != null;
            for(int i = 0; i<jsonArray.length(); i++){
                JSONObject jsonObject1 = jsonArray.optJSONObject(i);
                LoanRecordItemDetailModel loanRecordItemDetailModel = new LoanRecordItemDetailModel();
                loanRecordItemDetailModel.term = jsonObject1.optString("term");
                loanRecordItemDetailModel.emiAmount = jsonObject1.optInt("emiAmount");
                loanRecordItemDetailModel.termStatus = jsonObject1.optString("termStatus");
                loanRecordItemDetailModel.repaymentDate = jsonObject1.optString("repaymentDate");
                loanRecordItemDetailModel.principal = jsonObject1.optInt("principal");
                loanRecordItemDetailModel.overdueDays = jsonObject1.optInt("overdueDays");
                loanRecordItemDetailModel.overDueFeeGST = jsonObject1.optInt("overDueFeeGST");
                loanRecordItemDetailModel.interest = jsonObject1.optInt("interest");
                loanRecordItemDetailModel.overDueFees = jsonObject1.optInt("overDueFees");
                loanRecordItemDetailModel.defaultFees = jsonObject1.optInt("defaultFees");
                loanRecordItemDetailModels.add(loanRecordItemDetailModel);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
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
