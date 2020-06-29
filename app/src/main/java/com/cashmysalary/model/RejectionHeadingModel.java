package com.cashmysalary.model;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

public class RejectionHeadingModel extends ExpandableGroup<RejectionSubHeadingModel> {

    public RejectionHeadingModel(String title, List<RejectionSubHeadingModel> items) {
        super(title, items);
    }
}
