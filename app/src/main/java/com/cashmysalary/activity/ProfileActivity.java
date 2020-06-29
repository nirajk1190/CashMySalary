package com.cashmysalary.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cashmysalary.R;
import com.cashmysalary.adapter.ProfileAdapter;
import com.cashmysalary.model.ProfileDataModel;
import com.cashmysalary.newActivity.AddInfoAct;
import com.cashmysalary.newActivity.BankDetailsForLoanActivity;
import com.cashmysalary.newActivity.BasicInfoActivity;
import com.cashmysalary.newActivity.EmploymentActivity;
import com.cashmysalary.newActivity.SalaryAccountDetailsActivity;
import com.cashmysalary.newActivity.TypeOfResidenceActivity;
import com.cashmysalary.profileActivities.AdditionalInfoActivity;
import com.cashmysalary.profileActivities.BankDetailActivity;
import com.cashmysalary.profileActivities.EmploymentInfoActivity;
import com.cashmysalary.profileActivities.KYCInfoActivity;
import com.cashmysalary.profileActivities.PersonalInfoActivity;
import com.cashmysalary.profileActivities.ReferenceInfoActivity;
import com.cashmysalary.profileActivities.ResidenceInfoActivity;
import com.cashmysalary.profileActivities.SalaryDetailsActivity;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity implements ProfileAdapter.ItemClick {
    private Context mContext;
    private String TAG = ContactUsActivity.class.getSimpleName();
    private Toolbar toolbar;
    private RecyclerView rvData;
    private ArrayList<ProfileDataModel> profileDataModelArrayList = new ArrayList<>();
    private ProfileAdapter profileAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        mContext = ProfileActivity.this;

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
        toolbar.setTitle(getResources().getString(R.string.profile_text));
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));

        fetchProfieList();

        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        rvData.setLayoutManager(layoutManager);
        profileAdapter = new ProfileAdapter(mContext, profileDataModelArrayList, this);
        rvData.setAdapter(profileAdapter);

    }

    private void init() {
        toolbar = findViewById(R.id.toolbar);
        rvData = findViewById(R.id.rvData);
    }

    private void fetchProfieList() {
        profileDataModelArrayList.clear();

        ProfileDataModel profileDataModel = new ProfileDataModel();
        profileDataModel.title = "Personal Information";
        profileDataModel.id = 101;
        profileDataModel.headerImage = R.drawable.ic_personal_info;
        profileDataModelArrayList.add(profileDataModel);

        ProfileDataModel profileDataModel1 = new ProfileDataModel();
        profileDataModel1.title = "Residence Information";
        profileDataModel1.id = 102;
        profileDataModel1.headerImage = R.drawable.ic_residence;
        profileDataModelArrayList.add(profileDataModel1);

        ProfileDataModel profileDataModel2 = new ProfileDataModel();
        profileDataModel2.title = "Employment Information";
        profileDataModel2.id = 103;
        profileDataModel2.headerImage = R.drawable.ic_work_black_24dp;
        profileDataModelArrayList.add(profileDataModel2);

        ProfileDataModel profileDataModel3 = new ProfileDataModel();
        profileDataModel3.title = "Bank Detail";
        profileDataModel3.id = 104;
        profileDataModel3.headerImage = R.drawable.ic_bank_black_24dp;
        profileDataModelArrayList.add(profileDataModel3);

        ProfileDataModel profileDataModel4 = new ProfileDataModel();
        profileDataModel4.title = "Salary Account Bank Detail";
        profileDataModel4.id = 105;
        profileDataModel4.headerImage = R.drawable.wage;
        profileDataModelArrayList.add(profileDataModel4);

//        ProfileDataModel profileDataModel5 = new ProfileDataModel();
//        profileDataModel5.title = "Reference Detail";
//        profileDataModel5.id = 106;
//        profileDataModel5.headerImage = R.drawable.ic_account_black_24dp;
//        profileDataModelArrayList.add(profileDataModel5);


        ProfileDataModel profileDataModel5 = new ProfileDataModel();
        profileDataModel5.title = "Additional Information";
        profileDataModel5.id = 107;
        profileDataModel5.headerImage = R.drawable.ic_addional_24dp;
        profileDataModelArrayList.add(profileDataModel5);

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
    public void onItemClick(int pos) {
        if (pos == 0) {
            Intent p = new Intent(mContext,BasicInfoActivity.class);
            p.putExtra("isReview",true);
            startActivity(p);
        }
        if (pos == 1) {
            Intent p = new Intent(mContext,TypeOfResidenceActivity.class);
            p.putExtra("isReview",true);
            startActivity(p);
        }
        if (pos == 2) {
            Intent p = new Intent(mContext,EmploymentActivity.class);
            p.putExtra("isReview",true);
            startActivity(p);
        }
        if (pos == 3) {
            Intent p = new Intent(mContext,BankDetailsForLoanActivity.class);
            p.putExtra("isReview",true);
            startActivity(p);
        }
        if (pos == 4) {
            Intent p = new Intent(mContext,SalaryAccountDetailsActivity.class);
            p.putExtra("isReview",true);
            startActivity(p);
        }
        if (pos == 5) {
            Intent p = new Intent(mContext,AddInfoAct.class);
            p.putExtra("isReview",true);
            startActivity(p);
        }

    }


}


