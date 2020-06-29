package com.cashmysalary.newActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import com.cashmysalary.R;
import com.cashmysalary.profileActivities.ResidenceInfoActivity;

import vn.nms.dynamic_seekbar.DynamicSeekBarView;

public class MonthlySalaryActivity extends AppCompatActivity implements View.OnClickListener {
    private Context mContext;
    private AppCompatButton btnNext, btnPrevious;
    private AppCompatEditText etMonthlySalary;
    private DynamicSeekBarView sbSalary;
    private boolean isReview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monthly_salary);
        mContext = this;
        Intent i = getIntent();
        if(i!=null){
            isReview = i.getBooleanExtra("isReview",false);
        }
        init();
        applyInit();
    }

    private void applyInit() {
        sbSalary.setSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                etMonthlySalary.setText(progress+"");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void init() {
        btnNext = findViewById(R.id.btnNext);
        btnPrevious = findViewById(R.id.btnPrevious);
        etMonthlySalary = findViewById(R.id.etMonthlySalary);
        sbSalary = findViewById(R.id.sbSalary);

        btnNext.setOnClickListener(this);
        btnPrevious.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnNext) {
            Intent i = new Intent(mContext,OfficeInfoActivity.class);
            i.putExtra("isReview",isReview);
            startActivity(i);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            finish();
        }
        if (v.getId() == R.id.btnPrevious) {
            Intent i = new Intent(mContext,DesignationActivity.class);
            i.putExtra("isReview",isReview);
            startActivity(i);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            finish();
        }
    }
}



