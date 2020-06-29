package com.cashmysalary.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;

import com.cashmysalary.R;

public class EditProfileActivity extends AppCompatActivity {
    private Context mContext;
    private String mobile;
    private EditText etMobile;
    private Toolbar toolbar;
    private boolean isVerify;
    private AppCompatButton btnVerify;
    public static Activity a;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        mContext = EditProfileActivity.this;
        a = EditProfileActivity.this;
        Intent i = getIntent();
        mobile = i.getStringExtra("mobile");
        isVerify = i.getBooleanExtra("isVerify",false);

        init();
        applyInit();

    }

    private void applyInit() {
        if (isVerify){
            etMobile.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            etMobile.setFocusable(true);
            etMobile.setClickable(false);
        }else {
            etMobile.setFocusable(false);
            etMobile.setClickable(true);
        }

        etMobile.setText(mobile);

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
        toolbar.setTitle(getResources().getString(R.string.edit_profile_act_toolbar_title));
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));

        if (isVerify){
            btnVerify.setVisibility(View.VISIBLE);
        }else {
            btnVerify.setVisibility(View.GONE);
        }

    }

    private void init() {
        toolbar = findViewById(R.id.toolbar);
        btnVerify = findViewById(R.id.btnVerify);
        etMobile = findViewById(R.id.etMobile);
        if (!isVerify){
            etMobile.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(mContext,VerifiyOTPActivity.class);
                    i.putExtra("mobile",mobile);
                    i.putExtra("isVerify",isVerify);
                    startActivity(i);
                }
            });
        }

        btnVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext,VerifiyOTPActivity.class);
                i.putExtra("isVerify",isVerify);
                i.putExtra("mobile",etMobile.getText().toString());
                startActivity(i);
            }
        });
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
