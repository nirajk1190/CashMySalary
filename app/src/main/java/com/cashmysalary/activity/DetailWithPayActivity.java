package com.cashmysalary.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;

import com.cashmysalary.R;

public class DetailWithPayActivity extends AppCompatActivity {
    private Context mContext;
    private String TAG = DetailWithPayActivity.class.getSimpleName();
    private AppCompatButton btnPay;
    private Toolbar toolbar;
    public static Activity a;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_with_pay);
        mContext = this;
        a = DetailWithPayActivity.this;

        init();
        applyInt();
    }

    private void applyInt() {
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
        toolbar.setTitle(getResources().getString(R.string.header_repayment_details));
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));

    }

    private void init() {
        btnPay = findViewById(R.id.btnPay);
        toolbar = findViewById(R.id.toolbar);
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
