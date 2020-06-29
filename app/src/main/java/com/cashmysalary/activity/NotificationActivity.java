package com.cashmysalary.activity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cashmysalary.R;
import com.cashmysalary.adapter.NotificationAdapter;
import com.cashmysalary.model.NotificationModel;
import com.cashmysalary.util.RecyclerItemTouchHelper;
import com.cashmysalary.util.Util;
import com.google.android.material.snackbar.Snackbar;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class NotificationActivity extends AppCompatActivity implements RecyclerItemTouchHelper.RecyclerItemTouchHelperListener {
    private Context mContext;
    private String TAG = NotificationActivity.class.getSimpleName();
    private RecyclerView rvData;
    private Toolbar toolbar;
    private ArrayList<NotificationModel> notificationModels;
    private NotificationAdapter notificationAdapter;
    private RelativeLayout mainContent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        mContext = NotificationActivity.this;

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
        toolbar.setTitle(getResources().getString(R.string.notification_toolbar_title));
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));

        notificationModels = new ArrayList<>();
        notificationAdapter = new NotificationAdapter(mContext, notificationModels);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rvData.setLayoutManager(mLayoutManager);
        rvData.setItemAnimator(new DefaultItemAnimator());
        rvData.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        rvData.setAdapter(notificationAdapter);

        // adding item touch helper
        // only ItemTouchHelper.LEFT added to detect Right to Left swipe
        // if you want both Right -> Left and Left -> Right
        // add pass ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT as param
        ItemTouchHelper.SimpleCallback itemTouchHelperCallback = new RecyclerItemTouchHelper(0, ItemTouchHelper.LEFT, this);
        new ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(rvData);

        fetchList();

    }

    private void fetchList() {
        notificationModels.clear();

        try {
            String json = Util.getAssetJsonResponse(mContext, "notification_dummy_list.json");
            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.optJSONArray("fields");
            assert jsonArray != null;
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject1 = jsonArray.optJSONObject(i);
                NotificationModel notificationModel = new NotificationModel();
                notificationModel.notificationHeader = jsonObject1.optString("notificationHeader");
                notificationModel.notificationSubContent = jsonObject1.optString("notificationSubContent");
                notificationModel.notificationTime = jsonObject1.optString("notificationTime");
                notificationModel.notificationDate = jsonObject1.optString("notificationDate");
                notificationModel.notificationId = jsonObject1.optInt("notificationId");
                notificationModel.isPayBtn = jsonObject1.optBoolean("isPayBtn");
                notificationModels.add(notificationModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void init() {
        mainContent = findViewById(R.id.mainContent);
        toolbar = findViewById(R.id.toolbar);
        rvData = findViewById(R.id.rvData);
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction, int position) {
        if (viewHolder instanceof NotificationAdapter.MyViewHolder) {
            // get the removed item name to display it in snack bar
            String name = notificationModels.get(viewHolder.getAdapterPosition()).notificationHeader;

            // backup of removed item for undo purpose
            final NotificationModel deletedItem = notificationModels.get(viewHolder.getAdapterPosition());
            final int deletedIndex = viewHolder.getAdapterPosition();

            // remove the item from recycler view
            notificationAdapter.removeItem(viewHolder.getAdapterPosition());

            // showing snack bar with Undo option
            Snackbar snackbar = Snackbar
                    .make(mainContent, name + " removed from list!", Snackbar.LENGTH_LONG);
            snackbar.setAction("UNDO", new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    // undo is selected, restore the deleted item
                    notificationAdapter.restoreItem(deletedItem, deletedIndex);
                }
            });
            snackbar.setActionTextColor(Color.YELLOW);
            snackbar.show();
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
