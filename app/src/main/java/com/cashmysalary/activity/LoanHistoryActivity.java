package com.cashmysalary.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.cashmysalary.R;
import com.google.android.material.tabs.TabLayout;

public class LoanHistoryActivity extends AppCompatActivity implements TabLayout.BaseOnTabSelectedListener {
    private Context mContext;
    private String TAG = LoanHistoryActivity.class.getSimpleName();
    private RecyclerView rvData;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_history);
        mContext = LoanHistoryActivity.this;

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
        toolbar.setTitle(getResources().getString(R.string.loan_record_toolbar_title));
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));


        setupViewPager();

    }

    private void init() {
        toolbar = findViewById(R.id.toolbar);
        viewPager = (ViewPager) findViewById(R.id.pager);

        tabLayout  = findViewById(R.id.tab);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager() {
        Pager adapter = new Pager(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
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
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
