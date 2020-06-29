package com.cashmysalary.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;

import com.cashmysalary.R;

public class VerifiyOTPActivity extends AppCompatActivity implements View.OnClickListener {
    private Context mContext;
    private Toolbar toolbar;
    private TextView tvSubContent,tvMobile;
    private AppCompatButton btnVerify, btnGenerateOTP;
    private String mobileNumber;
    private TextView tvOtpMsg;
    private boolean isVerify;
    private ImageView ivEdit;
    public static Activity a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_otp);
        mContext = VerifiyOTPActivity.this;
        a = VerifiyOTPActivity.this;
        Intent i = getIntent();
        if (i != null) {
            mobileNumber = i.getStringExtra("mobile");
            isVerify = i.getBooleanExtra("isVerify",isVerify);
        }
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
        tvMobile.setText("+91" + " " + mobileNumber);
        startTimer();

        if (isVerify){
            ivEdit.setVisibility(View.VISIBLE);
        }else {
            ivEdit.setVisibility(View.GONE);
        }
    }

    private void startTimer() {
        new CountDownTimer(30000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                tvOtpMsg.setText(getResources().getString(R.string.otp_timer_text) + " " + millisUntilFinished / 1000 + " " + "sec");
                btnGenerateOTP.setVisibility(View.GONE);
            }

            @SuppressLint("RestrictedApi")
            @Override
            public void onFinish() {
                tvOtpMsg.setText(getResources().getString(R.string.did_not_recieve_otp_text));

                btnGenerateOTP.setVisibility(View.VISIBLE);
                btnGenerateOTP.setText(mContext.getResources().getString(R.string.btn_regenerate_otp_text));
                btnGenerateOTP.setTextColor(getResources().getColor(R.color.colorPrimary));
                btnGenerateOTP.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_background_border));

            }
        }.start();
    }

    private void init() {
        toolbar = findViewById(R.id.toolbar);
        tvOtpMsg = findViewById(R.id.tvOtpMsg);
        tvSubContent = findViewById(R.id.tvSubContent);
        tvMobile = findViewById(R.id.tvMobile);
        btnVerify = findViewById(R.id.btnVerify);
        btnGenerateOTP = findViewById(R.id.btnGenerateOTP);
        ivEdit = findViewById(R.id.ivEdit);


        btnVerify.setOnClickListener(this);
        ivEdit.setOnClickListener(this);
        btnGenerateOTP.setOnClickListener(this);
    }

    @SuppressLint("RestrictedApi")
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnVerify) {
            if (!isVerify){
                EditProfileActivity.a.finish();
                Intent i = new Intent(mContext,EditProfileActivity.class);
                i.putExtra("mobile",mobileNumber);
                i.putExtra("isVerify",true);
                startActivity(i);
                finish();
            }else {
                EditProfileActivity.a.finish();
                Intent i = new Intent(mContext,OTPVerifiedActivity.class);
                i.putExtra("mobile",mobileNumber);
                startActivity(i);
                finish();
            }

        }
        if (v.getId() == R.id.btnGenerateOTP) {
            startTimer();
        }
        if (v.getId()==R.id.ivEdit){
            EditProfileActivity.a.finish();
            Intent i = new Intent(mContext,EditProfileActivity.class);
            i.putExtra("mobile",mobileNumber);
            i.putExtra("isVerify",true);
            startActivity(i);
            finish();
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
