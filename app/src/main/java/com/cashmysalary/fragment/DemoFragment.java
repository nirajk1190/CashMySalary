package com.cashmysalary.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.cashmysalary.R;

public class DemoFragment extends Fragment {
    private View main;

    public DemoFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        main = inflater.inflate(R.layout.referral_dialog,container,false);

        init();
        applyInit();
        return  main;
    }

    private void applyInit() {

    }

    private void init() {

    }
}
