package com.cashmysalary.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import com.cashmysalary.R;
import com.cashmysalary.util.PrefixEditText;
import com.cashmysalary.util.Util;
import com.facebook.FacebookSdk;

import java.util.Objects;

public class MobileNumberActivity extends AppCompatActivity implements View.OnClickListener {
    private String TAG = MobileNumberActivity.class.getSimpleName();
    private Context mContext;
    private AppCompatButton btnOtp;
    private Toolbar toolbar;

    private CheckBox cbAccept;
    private PrefixEditText etMobileNumber;
    public static Activity a;
    private String mobileNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(this.getApplicationContext());
        setContentView(R.layout.activity_mobile);
        a = MobileNumberActivity.this;
        mContext = MobileNumberActivity.this;
        Intent i=getIntent();
        if (i!=null){
            mobileNumber =i.getStringExtra("Phone");
        }
        initViews();
        applyInit();
    }

    private void applyInit() {
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
        if (Util.validateString(mobileNumber)){
           etMobileNumber.setText(mobileNumber);
        }else {
            etMobileNumber.setText("");
        }
    }

    private void initViews() {
        toolbar = findViewById(R.id.toolbar);
        etMobileNumber = findViewById(R.id.etMobileNumber);
        btnOtp = findViewById(R.id.btnOtp);
        cbAccept = findViewById(R.id.cbAccept);

        cbAccept.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    btnOtp.setEnabled(true);
                    btnOtp.setSupportBackgroundTintList(ContextCompat.getColorStateList(MobileNumberActivity.this, R.color.colorPrimary));
                } else {
                    btnOtp.setEnabled(false);
                    btnOtp.setSupportBackgroundTintList(ContextCompat.getColorStateList(MobileNumberActivity.this, R.color.shadows));

                }
            }
        });
        btnOtp.setOnClickListener(this);


    }

    @SuppressLint("RestrictedApi")
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnOtp) {
            Intent i = new Intent(mContext, OtpVerificationActivity.class);
            i.putExtra("Phone", Objects.requireNonNull(etMobileNumber.getText()).toString());
            startActivity(i);
            MobileNumberActivity.a.finish();
            LanguageActivity.a.finish();
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
