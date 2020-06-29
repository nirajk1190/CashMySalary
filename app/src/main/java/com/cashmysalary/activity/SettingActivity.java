package com.cashmysalary.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.cashmysalary.R;

public class SettingActivity extends AppCompatActivity implements View.OnClickListener {
    private Context mContext;
    private String TAG = SettingActivity.class.getSimpleName();
    private Toolbar toolbar;
    private RelativeLayout rlLegal,rlLanguage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        mContext = SettingActivity.this;

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
    }

    private void init() {
        toolbar = findViewById(R.id.toolbar);
        rlLegal = findViewById(R.id.rlLegal);
        rlLanguage = findViewById(R.id.rlLanguage);
        rlLegal.setOnClickListener(this);
        rlLanguage.setOnClickListener(this);
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
        if (v.getId()==R.id.rlLegal){
            startActivity(new Intent(mContext,LegalActivity.class));
        }  if (v.getId()==R.id.rlLanguage){
            startActivity(new Intent(mContext,ChangeLanguageActivity.class));
        }
    }
}

