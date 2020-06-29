package com.cashmysalary.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cashmysalary.R;
import com.cashmysalary.model.RejectionHeadingModel;
import com.cashmysalary.model.RejectionSubHeadingModel;
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

public class RejectionAdapter extends ExpandableRecyclerViewAdapter<RejectionHeadingViewHolder, RejectionSubHeadingViewHolder> {

    private Activity activity;

    public RejectionAdapter(Activity activity, List<? extends ExpandableGroup> groups) {
        super(groups);
        this.activity = activity;
    }

    @Override
    public RejectionHeadingViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.group_view_holder, parent, false);

        return new RejectionHeadingViewHolder(view);
    }

    @Override
    public RejectionSubHeadingViewHolder onCreateChildViewHolder(ViewGroup parent, final int viewType) {
        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.child_view_holder, parent, false);

        return new RejectionSubHeadingViewHolder(view);
    }

    @Override
    public void onBindChildViewHolder(RejectionSubHeadingViewHolder holder, int flatPosition, ExpandableGroup group, int childIndex) {
        final RejectionSubHeadingModel phone = ((RejectionHeadingModel) group).getItems().get(childIndex);
        holder.onBind(phone,group);
    }

    @Override
    public void onBindGroupViewHolder(RejectionHeadingViewHolder holder, int flatPosition, ExpandableGroup group) {
        holder.setGroupName(group);
    }
}
