package com.cashmysalary.newActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import com.cashmysalary.R;

import com.cashmysalary.util.Util;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.Calendar;

public class JoiningActivity extends AppCompatActivity implements View.OnClickListener, DatePickerDialog.OnDateSetListener {
    private Context mContext;
    private AppCompatButton btnNext,btnPrevious;
    private AppCompatEditText etDateOfJoining;
    Calendar calendar ;
    DatePickerDialog datePickerDialog ;
    int Year, Month, Day ;
    private boolean isReview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joining_date);
        mContext = this;
        Intent i = getIntent();
        if(i!=null){
            isReview = i.getBooleanExtra("isReview",false);
        }
        calendar = Calendar.getInstance();

        Year = calendar.get(Calendar.YEAR) ;
        Month = calendar.get(Calendar.MONTH)+1;
        Day = calendar.get(Calendar.DAY_OF_MONTH);

        init();
        applyInit();
    }

    private void applyInit() {

    }

    private void init() {
        btnNext = findViewById(R.id.btnNext);
        btnPrevious = findViewById(R.id.btnPrevious);
        etDateOfJoining = findViewById(R.id.etDateOfJoining);

        btnNext.setOnClickListener(this);
        btnPrevious.setOnClickListener(this);
        etDateOfJoining.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnNext) {
            Intent i = new Intent(mContext,DesignationActivity.class);
            i.putExtra("isReview",isReview);
            startActivity(i);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            finish();
        }if (v.getId() == R.id.btnPrevious) {
            Intent i = new Intent(mContext,CompanyActivity.class);
            i.putExtra("isReview",isReview);
            startActivity(i);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            finish();
        }if (v.getId()==R.id.etDateOfJoining){
            showDatePicker();
        }
    }

    private void showDatePicker() {
        datePickerDialog = DatePickerDialog.newInstance(this, Year, Month, Day);
        datePickerDialog.setThemeDark(false);
        datePickerDialog.showYearPickerFirst(false);
        datePickerDialog.setAccentColor(mContext.getResources().getColor(R.color.colorPrimary));
        datePickerDialog.setTitle("Select Date From DatePickerDialog");
        datePickerDialog.show(getFragmentManager(), "DatePickerDialog");
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        String date = Day + "-" + Month + "-" + Year;
        etDateOfJoining.setText(date);
    }
}


