package com.cashmysalary.newActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;

import com.cashmysalary.R;
import com.cashmysalary.activity.StatusActivity;

public class ReviewApplicationActivity extends AppCompatActivity implements View.OnClickListener {
    private Context mContext;
    private String TAG = ReviewApplicationActivity.class.getSimpleName();
    private Toolbar toolbar;
    private AppCompatButton btnSubmit;
    private ImageView ivPersonalEdit,ivResidenceEdit,ivEmploymentEdit,ivBankEdit,ivAdditionalEdit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application_summary);
        mContext = ReviewApplicationActivity.this;

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
        toolbar.setTitle(getResources().getString(R.string.application_summary_toolbar_title));
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
    }


    private void init() {
        toolbar = findViewById(R.id.toolbar);
        btnSubmit = findViewById(R.id.btnSubmit);

        ivPersonalEdit = findViewById(R.id.ivPersonalEdit);
        ivResidenceEdit = findViewById(R.id.ivResidenceEdit);
        ivEmploymentEdit = findViewById(R.id.ivEmploymentEdit);
        ivBankEdit = findViewById(R.id.ivBankEdit);
        ivAdditionalEdit = findViewById(R.id.ivAdditionalEdit);

        btnSubmit.setOnClickListener(this);

        ivPersonalEdit.setOnClickListener(this);
        ivResidenceEdit.setOnClickListener(this);
        ivEmploymentEdit.setOnClickListener(this);
        ivBankEdit.setOnClickListener(this);
        ivAdditionalEdit.setOnClickListener(this);
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
        if (v.getId()==R.id.btnSubmit){
            startActivity(new Intent(mContext, StatusActivity.class));
        }
        if (v.getId()==R.id.ivPersonalEdit){
            Intent p = new Intent(mContext,BasicInfoActivity.class);
            p.putExtra("isReview",true);
            startActivity(p);

        }if (v.getId()==R.id.ivResidenceEdit){
            Intent q = new Intent(mContext,TypeOfResidenceActivity.class);
            q.putExtra("isReview",true);
            startActivity(q);

        }if (v.getId()==R.id.ivEmploymentEdit){
            Intent r = new Intent(mContext,EmploymentActivity.class);
            r.putExtra("isReview",true);
            startActivity(r);

        }if (v.getId()==R.id.ivBankEdit){
            Intent s = new Intent(mContext,BankDetailsForLoanActivity.class);
            s.putExtra("isReview",true);
            startActivity(s);

        }if (v.getId()==R.id.ivAdditionalEdit){
            Intent t = new Intent(mContext,AddInfoAct.class);
            t.putExtra("isReview",true);
            startActivity(t);

        }
    }
}

