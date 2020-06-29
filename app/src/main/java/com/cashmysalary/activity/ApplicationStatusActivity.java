package com.cashmysalary.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cashmysalary.R;
import com.cashmysalary.adapter.ApplicationStatusAdapter;
import com.cashmysalary.model.ApplicationStatusModel;
import com.cashmysalary.util.Util;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class ApplicationStatusActivity extends AppCompatActivity {
    private Context mContext;
    private String TAG = ApplicationStatusActivity.class.getSimpleName();
    private RecyclerView rvData;
    private ApplicationStatusAdapter applicationStatusAdapter;
    private Toolbar toolbar;
    private ArrayList<ApplicationStatusModel> applicationStatusModelArrayList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application_status);
        mContext = ApplicationStatusActivity.this;

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
        toolbar.setTitle(getResources().getString(R.string.application_status_toolbar_title));
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));

        fetchList();

        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        rvData.setLayoutManager(layoutManager);
        applicationStatusAdapter = new ApplicationStatusAdapter(this, applicationStatusModelArrayList);
        rvData.setAdapter(applicationStatusAdapter);

    }

    private void init() {
        toolbar = findViewById(R.id.toolbar);
        rvData = findViewById(R.id.rvData);


    }

    private void fetchList() {
        applicationStatusModelArrayList.clear();
        try {
            String json = Util.getAssetJsonResponse(mContext, "application_status_list.json");
            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.optJSONArray("fields");
            assert jsonArray != null;
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject1 = jsonArray.optJSONObject(i);
                ApplicationStatusModel applicationStatusModel = new ApplicationStatusModel();
                applicationStatusModel.applicationStatus = jsonObject1.optInt("applicationStatus");
                applicationStatusModel.loanNumber = jsonObject1.optString("loanNumber");
                applicationStatusModel.status = jsonObject1.optString("status");
                applicationStatusModel.btnText = jsonObject1.optString("btnText");
                applicationStatusModel.applicantName = jsonObject1.optString("applicantName");
                applicationStatusModel.applicationDate = jsonObject1.optString("applicationDate");
                applicationStatusModel.loanAmount = jsonObject1.optInt("loanAmount");
                applicationStatusModel.tenure = jsonObject1.optInt("tenure");
                applicationStatusModelArrayList.add(applicationStatusModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
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
