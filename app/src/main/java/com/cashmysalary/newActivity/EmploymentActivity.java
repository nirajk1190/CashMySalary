package com.cashmysalary.newActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.cashmysalary.R;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

public class EmploymentActivity extends AppCompatActivity implements View.OnClickListener {
    private Context mContext;
    private AppCompatButton btnNext, btnPrevious;
    private MaterialBetterSpinner spinnerEmpStatus;
    private boolean isReview;
    private LinearLayout llPrevious;
    private ImageView ivClose;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employment_details);
        mContext = this;
        Intent i = getIntent();
        if(i!=null){
            isReview = i.getBooleanExtra("isReview",false);
        }
        init();
        applyInit();
    }

    private void applyInit() {
        if (isReview){
            llPrevious.setVisibility(View.GONE);
            ivClose.setVisibility(View.VISIBLE);
        }
        String[] occupationList = getResources().getStringArray(R.array.employment_array);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(mContext, android.R.layout.simple_dropdown_item_1line, occupationList);
        spinnerEmpStatus.setAdapter(adapter);
    }

    private void init() {
        ivClose = findViewById(R.id.ivClose);
        llPrevious = findViewById(R.id.llPrevious);
        btnNext = findViewById(R.id.btnNext);
        spinnerEmpStatus = findViewById(R.id.spinnerEmpStatus);
        btnPrevious = findViewById(R.id.btnPrevious);

        btnNext.setOnClickListener(this);
        btnPrevious.setOnClickListener(this);
        ivClose.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnNext) {
            Intent i = new Intent(mContext, CompanyActivity.class);
            i.putExtra("isReview", isReview);
            startActivity(i);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            finish();
        }
        if (v.getId() == R.id.btnPrevious) {
            Intent i = new Intent(mContext,ProofOfOwnerShip.class);
            i.putExtra("isReview",isReview);
            startActivity(i);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            finish();
        }if (v.getId()==R.id.ivClose){
            finish();
        }
    }
}

