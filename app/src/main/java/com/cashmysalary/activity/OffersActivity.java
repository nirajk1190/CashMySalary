package com.cashmysalary.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cashmysalary.R;
import com.cashmysalary.adapter.OffersAdapter;
import com.cashmysalary.model.OffersModel;

import java.util.ArrayList;

public class OffersActivity extends AppCompatActivity {
    private Context mContext;
    private String TAG = OffersActivity.class.getSimpleName();
    private RecyclerView rvData;
    private Toolbar toolbar;
    private ArrayList<OffersModel> offersModelArrayList;
    private OffersAdapter offersAdapter;
    private RelativeLayout mainContent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer);

        mContext = OffersActivity.this;

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
        offersAdapter = new OffersAdapter(mContext, offersModelArrayList);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rvData.setLayoutManager(mLayoutManager);
        rvData.setAdapter(offersAdapter);

        fetchList();

    }

    private void fetchList() {
        offersModelArrayList.clear();

        OffersModel offersModel = new OffersModel();
        offersModel.id = 0;
        offersModel.headerImage = R.drawable.demo_img_1;
        offersModel.header = "Get free online consultation at Practo";
        offersModel.description = "- Use CashmySalary exclusive code-";
        offersModel.code = "pconsultcashmysalary";
        offersModel.subDescription = "& get free consultation worth Rs. 349";
        offersModel.validity = "[Validity: 30th July'20]";
        offersModelArrayList.add(offersModel);

        OffersModel offersModel1 = new OffersModel();
        offersModel1.id = 0;
        offersModel1.headerImage = R.drawable.demo_img_2;
        offersModel1.header = "Get 25% OFF on 1st video consultation at Curefit";
        offersModel1.description = "- Use CashmySalary exclusive code-";
        offersModel1.code = "CASHMYSALARY25";
        offersModel1.subDescription = "& get 25% OFF up to Rs. 150";
        offersModel1.validity = "[Validity: 30th July'20]";
        offersModelArrayList.add(offersModel1);

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

