package com.cashmysalary.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;

import com.cashmysalary.R;
import com.cashmysalary.newActivity.BasicInfoActivity;
import com.cashmysalary.profileActivities.PersonalInfoActivity;

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener {
    private Context mContext;
    private Toolbar toolbar;
    private AppCompatButton btnApply;
//    String toolBarName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frag_calculator);
        mContext = this;
//        Intent intent = getIntent();
//        toolBarName = intent.getStringExtra("toolBarName");

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
        toolbar.setTitle(getResources().getString(R.string.calculator_act_toolbar_title));
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));

    }

    private void init() {
        toolbar = findViewById(R.id.toolbar);

        btnApply = findViewById(R.id.btnApply);
        btnApply.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnApply:
                startActivity(new Intent(mContext, BasicInfoActivity.class));
                finish();
                break;
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
