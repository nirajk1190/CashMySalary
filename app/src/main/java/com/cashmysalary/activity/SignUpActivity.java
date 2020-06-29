package com.cashmysalary.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.Toolbar;

import com.cashmysalary.R;

import java.util.Objects;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    private Context mContext;
    private TextView tvSignIn;
    private AppCompatButton btnSignUp;
    private ImageView ivClose;
    private AppCompatEditText etMobileNumber;
    public static Activity a;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mContext = SignUpActivity.this;
        a = SignUpActivity.this;
        init();
        applyInit();
    }

    private void applyInit() {

    }

    private void init() {
        tvSignIn = findViewById(R.id.tvSignIn);
        btnSignUp = findViewById(R.id.btnSignUp);
        etMobileNumber = findViewById(R.id.etMobileNumber);
        ivClose = findViewById(R.id.ivClose);

        tvSignIn.setOnClickListener(this);
        btnSignUp.setOnClickListener(this);
        ivClose.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.tvSignIn){
            finish();
        }if (v.getId()==R.id.btnSignUp){
            Intent i = new Intent(mContext, OtpVerificationActivity.class);
            i.putExtra("Phone", Objects.requireNonNull(etMobileNumber.getText()).toString());
            startActivity(i);
            LanguageActivity.a.finish();
        }if (v.getId()==R.id.ivClose){
            finish();
        }
    }

}
