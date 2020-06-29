package com.cashmysalary.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cashmysalary.R;
import com.cashmysalary.adapter.OffersAdapter;
import com.cashmysalary.adapter.OffersDemoAdapter;
import com.cashmysalary.model.OffersDemoModel;
import com.cashmysalary.model.OffersModel;

import java.util.ArrayList;

public class OffersDemoActivity extends AppCompatActivity {
    private Context mContext;
    private String TAG = OffersDemoActivity.class.getSimpleName();
    private RecyclerView rvData;
    private Toolbar toolbar;
    private ArrayList<OffersDemoModel> offersModelArrayList;
    private OffersDemoAdapter offersAdapter;
    private RelativeLayout mainContent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer);

        mContext = OffersDemoActivity.this;

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
        toolbar.setTitle(getResources().getString(R.string.offers_toolbar_title));
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));

        offersModelArrayList = new ArrayList<>();
        offersAdapter = new OffersDemoAdapter(mContext, offersModelArrayList);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rvData.setLayoutManager(mLayoutManager);
        rvData.setAdapter(offersAdapter);

        fetchList();

    }

    private void fetchList() {
        offersModelArrayList.clear();

        OffersDemoModel offersModel = new OffersDemoModel();
        offersModel.id = 0;
        offersModel.brand = "Zoom Car";
        offersModel.couponCode = "ALZOOMCASHMYSALARY";
        offersModel.couponValue = "₹ 1,400";
        offersModel.validity = "31st July 2020";
        offersModelArrayList.add(offersModel);

    }

    private void init() {
        mainContent = findViewById(R.id.mainContent);
        toolbar = findViewById(R.id.toolbar);
        rvData = findViewById(R.id.rvData);
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

