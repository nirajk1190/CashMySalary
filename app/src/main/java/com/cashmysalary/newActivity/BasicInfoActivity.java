package com.cashmysalary.newActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.Toolbar;

import com.cashmysalary.R;
import com.cashmysalary.profileActivities.EmploymentInfoActivity;
import com.cashmysalary.profileActivities.ResidenceInfoActivity;
import com.cashmysalary.util.Util;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BasicInfoActivity extends AppCompatActivity implements View.OnClickListener, DatePickerDialog.OnDateSetListener {
    private Context mContext;
    private AppCompatButton btnNext;
    private LinearLayout llPrevious;
    private AppCompatEditText etdob;
    private ImageView ivClose;
    Calendar calendar ;
    DatePickerDialog datePickerDialog ;
    int Year, Month, Day ;
    private boolean isReview;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic);
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
        llPrevious.setVisibility(View.GONE);
    }

    private void init() {
        btnNext = findViewById(R.id.btnNext);
        llPrevious = findViewById(R.id.llPrevious);
        etdob = findViewById(R.id.etdob);
        ivClose = findViewById(R.id.ivClose);


        btnNext.setOnClickListener(this);
        etdob.setOnClickListener(this);
        ivClose.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnNext) {
            Intent i = new Intent(mContext, EducationActivity.class);
            i.putExtra("isReview",isReview);
            startActivity(i);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            finish();

        }if (v.getId()==R.id.etdob){
            showDatePicker();
        }if (v.getId()==R.id.ivClose){
            finish();
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
        etdob.setText(date);
    }
}
