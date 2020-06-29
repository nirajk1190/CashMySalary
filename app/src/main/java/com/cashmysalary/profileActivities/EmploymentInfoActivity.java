package com.cashmysalary.profileActivities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;

import com.cashmysalary.R;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

public class EmploymentInfoActivity extends AppCompatActivity implements View.OnClickListener {
    private Context mContext;
    private Toolbar toolbar;
    private AppCompatButton btnNext;
    private MaterialBetterSpinner spinnerOccupation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emp_info);
        mContext = this;

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
        toolbar.setTitle(getResources().getString(R.string.employment_info_toolbar_title));
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));

            String[] occupationList = getResources().getStringArray(R.array.occupation_list);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(EmploymentInfoActivity.this, android.R.layout.simple_dropdown_item_1line, occupationList);
            spinnerOccupation.setAdapter(adapter);

    }

    private void init() {
        toolbar = findViewById(R.id.toolbar);

        spinnerOccupation = findViewById(R.id.spinnerOccupation);

        btnNext = findViewById(R.id.btnNext);
        btnNext.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnNext) {
            startActivity(new Intent(mContext, OfficeAddress.class));
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
