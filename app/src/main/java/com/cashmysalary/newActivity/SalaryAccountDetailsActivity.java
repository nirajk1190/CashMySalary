package com.cashmysalary.newActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.cashmysalary.R;

public class SalaryAccountDetailsActivity extends AppCompatActivity implements View.OnClickListener {
    private Context mContext;
    private AppCompatButton btnNext, btnPrevious;
    private boolean isReview;
    private LinearLayout llPrevious;
    private ImageView ivClose;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salary_account_details);
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
            ivClose.setVisibility(View.VISIBLE);
            llPrevious.setVisibility(View.GONE);
            btnNext.setText(getResources().getString(R.string.done));
        }
    }

    private void init() {
        llPrevious = findViewById(R.id.llPrevious);
        ivClose = findViewById(R.id.ivClose);
        btnNext = findViewById(R.id.btnNext);
        btnPrevious = findViewById(R.id.btnPrevious);


        btnNext.setOnClickListener(this);
        ivClose.setOnClickListener(this);
        btnPrevious.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnNext) {
            if (isReview){
             finish();
            }else {
                Intent i = new Intent(mContext, AddInfoAct.class);
                i.putExtra("isReview", isReview);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
            }
        }
        if (v.getId() == R.id.btnPrevious) {
            Intent i = new Intent(mContext,BankDetailsForLoanActivity.class);
            i.putExtra("isReview",isReview);
            startActivity(i);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            finish();
        }if (v.getId()==R.id.ivClose){
            finish();
        }
    }
}










