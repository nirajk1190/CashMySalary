package com.cashmysalary.adapter;

import android.view.View;
import android.widget.TextView;

import com.cashmysalary.R;
import com.cashmysalary.model.RejectionSubHeadingModel;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

public class RejectionSubHeadingViewHolder extends ChildViewHolder {

    private TextView phoneName;

    public RejectionSubHeadingViewHolder(View itemView) {
        super(itemView);

        phoneName = (TextView) itemView.findViewById(R.id.phone_name);
    }

    public void onBind(RejectionSubHeadingModel phone, ExpandableGroup group) {
        phoneName.setText(phone.getName());

    }
}
