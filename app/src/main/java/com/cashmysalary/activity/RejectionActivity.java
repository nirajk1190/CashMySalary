package com.cashmysalary.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cashmysalary.R;
import com.cashmysalary.adapter.RejectionAdapter;
import com.cashmysalary.model.RejectionHeadingModel;
import com.cashmysalary.model.RejectionSubHeadingModel;

import java.util.ArrayList;

public class RejectionActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView recyclerView;
    private ArrayList<RejectionHeadingModel> rejectionHeadingModels = new ArrayList<>();
    private RejectionAdapter adapter;

    private Context mContext;
    private String TAG = ChangeLanguageActivity.class.getSimpleName();
    private Toolbar toolbar;
    private RelativeLayout rlLegal;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rejection);
        mContext = RejectionActivity.this;

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
        setData();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new RejectionAdapter(this, rejectionHeadingModels);
        recyclerView.setAdapter(adapter);
    }

    private void setData() {
        ArrayList<RejectionSubHeadingModel>  rejectionSubHeadingModels1 = new ArrayList<>();
        rejectionSubHeadingModels1.add(new RejectionSubHeadingModel(getResources().getString(R.string.rej_subheading_1)));

        ArrayList<RejectionSubHeadingModel>  rejectionSubHeadingModels2 = new ArrayList<>();
        rejectionSubHeadingModels2.add(new RejectionSubHeadingModel(getResources().getString(R.string.rej_subheading_2)));

        ArrayList<RejectionSubHeadingModel>  rejectionSubHeadingModels3 = new ArrayList<>();
        rejectionSubHeadingModels3.add(new RejectionSubHeadingModel(getResources().getString(R.string.rej_subheading_3)));

        ArrayList<RejectionSubHeadingModel>  rejectionSubHeadingModels4 = new ArrayList<>();
        rejectionSubHeadingModels4.add(new RejectionSubHeadingModel(getResources().getString(R.string.rej_subheading_4)));

        ArrayList<RejectionSubHeadingModel>  rejectionSubHeadingModels5 = new ArrayList<>();
        rejectionSubHeadingModels5.add(new RejectionSubHeadingModel(getResources().getString(R.string.rej_subheading_5)));


        rejectionHeadingModels.add(new RejectionHeadingModel(getResources().getString(R.string.rej_heading_1), rejectionSubHeadingModels1));
        rejectionHeadingModels.add(new RejectionHeadingModel(getResources().getString(R.string.rej_heading_2), rejectionSubHeadingModels2));
        rejectionHeadingModels.add(new RejectionHeadingModel(getResources().getString(R.string.rej_heading_3), rejectionSubHeadingModels3));
        rejectionHeadingModels.add(new RejectionHeadingModel(getResources().getString(R.string.rej_heading_4), rejectionSubHeadingModels4));
        rejectionHeadingModels.add(new RejectionHeadingModel(getResources().getString(R.string.rej_heading_5), rejectionSubHeadingModels5));
    }

    private void init() {
        toolbar = findViewById(R.id.toolbar);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

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

    }
}



