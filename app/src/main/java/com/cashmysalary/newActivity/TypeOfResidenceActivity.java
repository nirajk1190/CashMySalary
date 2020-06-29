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

public class TypeOfResidenceActivity extends AppCompatActivity implements View.OnClickListener {
    private Context mContext;
    private AppCompatButton btnNext, btnPrevious;
    private MaterialBetterSpinner spinnerTOR;
    private boolean isReview;
    private LinearLayout llPrevious;
    private ImageView ivClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_of_residence);
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
        String[] occupationList = getResources().getStringArray(R.array.residence_type_array);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(mContext, android.R.layout.simple_dropdown_item_1line, occupationList);
        spinnerTOR.setAdapter(adapter);

    }

    private void init() {
        llPrevious = findViewById(R.id.llPrevious);
        ivClose = findViewById(R.id.ivClose);
        btnNext = findViewById(R.id.btnNext);
        btnPrevious = findViewById(R.id.btnPrevious);
        spinnerTOR = findViewById(R.id.spinnerTOR);

        btnNext.setOnClickListener(this);
        btnPrevious.setOnClickListener(this);
        ivClose.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnNext) {
            Intent i = new Intent(mContext,ResidenceAddressActivity.class);
            i.putExtra("isReview",isReview);
            startActivity(i);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            finish();

        }
        if (v.getId() == R.id.btnPrevious) {
            Intent i = new Intent(mContext,PanCardActivity.class);
            i.putExtra("isReview",isReview);
            startActivity(i);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            finish();
        }if (v.getId()==R.id.ivClose){
            finish();
        }
    }
}




