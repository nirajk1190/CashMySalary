package com.cashmysalary.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import com.cashmysalary.R;
import com.cashmysalary.util.PrefManager;

public class OtpVerificationActivity extends AppCompatActivity implements View.OnClickListener {
    private Context mContext;
    private Toolbar toolbar;
    private TextView tvSubContent;
    private AppCompatButton btnLogin,btnGenerateOTP;
    private CheckBox cbAccept;
    private PrefManager prefManager;
    private String mobileNumber;
    private TextView tvOtpMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        mContext = OtpVerificationActivity.this;
        prefManager = new PrefManager(mContext);
        Intent i = getIntent();
        if (i != null) {
            mobileNumber = i.getStringExtra("Phone");
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
        tvSubContent.setText(getResources().getString(R.string.enter_otp_text) + " " + "+91" + " " + mobileNumber);
        startTimer();
    }

    private void startTimer() {
        new CountDownTimer(30000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                tvOtpMsg.setText(getResources().getString(R.string.otp_timer_text)+" "+millisUntilFinished / 1000+" " +"sec");
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
        btnLogin = findViewById(R.id.btnLogin);
        btnGenerateOTP = findViewById(R.id.btnGenerateOTP);
        cbAccept = findViewById(R.id.cbAccept);

        cbAccept.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    btnLogin.setEnabled(true);
                    btnLogin.setSupportBackgroundTintList(ContextCompat.getColorStateList(OtpVerificationActivity.this, R.color.colorPrimary));
                } else {
                    btnLogin.setEnabled(false);
                    btnLogin.setSupportBackgroundTintList(ContextCompat.getColorStateList(OtpVerificationActivity.this, R.color.shadows));

                }
            }
        });
        btnLogin.setOnClickListener(this);
        btnGenerateOTP.setOnClickListener(this);
    }

    @SuppressLint("RestrictedApi")
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnLogin) {
            prefManager.setFirstTimeLaunch(false);
            Intent i = new Intent(mContext, MainActivity.class);
            startActivity(i);
            LoginAct.a.finish();
            SignUpActivity.a.finish();
            LanguageActivity.a.finish();
            finish();
            Toast.makeText(mContext, "User Signed In", Toast.LENGTH_SHORT).show();
        }
        if (v.getId() == R.id.btnGenerateOTP){
            startTimer();
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
