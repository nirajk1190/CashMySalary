package com.cashmysalary.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.cashmysalary.R;
import com.cashmysalary.util.PrefManager;
import com.cashmysalary.util.SharedPrefUtil;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class LanguageActivity extends AppCompatActivity implements View.OnClickListener {
    private Context mContext;
    private AppCompatButton btnEng,btnHindi;
    private PrefManager prefManager;
    public static Activity a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);
        mContext = LanguageActivity.this;
        prefManager = new PrefManager(mContext);
        a = LanguageActivity.this;
        initViews();

    }
    private void initViews() {
        btnEng = findViewById(R.id.btnEng);
        btnHindi = findViewById(R.id.btnHindi);

        btnEng.setOnClickListener(this);
        btnHindi.setOnClickListener(this);
    }

    public void printHashKey(){
        // Add code to print out the key hash
        try {
            PackageInfo info = getPackageManager().getPackageInfo(
                    "com.cashmysalary",
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {

        } catch (NoSuchAlgorithmException e) {

        }
    }


    @Override
    public void onClick(View v) {
        boolean isPermissionGranted = SharedPrefUtil.getBoolean("isPermission",false,mContext);
        switch (v.getId()){
            case R.id.btnEng:
                if(isPermissionGranted){
                    startActivity(new Intent(LanguageActivity.this, IntroActivity.class));
                    finish();
                }else {
                    startActivity(new Intent(LanguageActivity.this, PermissionActivity.class));
                    finish();
                }
                break;
            case R.id.btnHindi:
                if(isPermissionGranted){
                    startActivity(new Intent(LanguageActivity.this, IntroActivity.class));
                    finish();
                }else {
                    startActivity(new Intent(LanguageActivity.this, PermissionActivity.class));
                    finish();
                }

                break;
        }
    }
}
