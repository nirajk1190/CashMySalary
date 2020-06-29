package com.cashmysalary.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;

import com.cashmysalary.R;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

public class ReceiptUploadActivity extends AppCompatActivity implements View.OnClickListener {
    private Context mContext;
    private String TAG = SubmitAppealActivity.class.getSimpleName();
    private AppCompatButton btnSubmit;
    private Toolbar toolbar;
    private MaterialBetterSpinner spinnerRepaymentChannel, spinnerRepaymentIssue;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_receipt);
        mContext = ReceiptUploadActivity.this;

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
        toolbar.setTitle(getResources().getString(R.string.upload_receipt_toolbar_title));
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));

        String[] repaymentChannelList = getResources().getStringArray(R.array.repayment_channel);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(ReceiptUploadActivity.this, android.R.layout.simple_dropdown_item_1line, repaymentChannelList);
        spinnerRepaymentChannel.setAdapter(adapter);

        String[] repaymentIssueList = getResources().getStringArray(R.array.repayment_issue);
        ArrayAdapter<String> issueAdapter = new ArrayAdapter<String>(ReceiptUploadActivity.this, android.R.layout.simple_dropdown_item_1line, repaymentIssueList);
        spinnerRepaymentIssue.setAdapter(issueAdapter);
    }

    private void init() {
        toolbar = findViewById(R.id.toolbar);
        btnSubmit = findViewById(R.id.btnSubmit);
        spinnerRepaymentChannel = findViewById(R.id.spinnerRepaymentChannel);
        spinnerRepaymentIssue = findViewById(R.id.spinnerRepaymentIssue);


        btnSubmit.setOnClickListener(this);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnSubmit) {

        }
    }
}


