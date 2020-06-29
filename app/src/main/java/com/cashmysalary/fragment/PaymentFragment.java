package com.cashmysalary.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cashmysalary.R;
import com.cashmysalary.activity.ContactUsActivity;
import com.cashmysalary.activity.SubmitAppealActivity;
import com.cashmysalary.adapter.PaymentAdapter;
import com.cashmysalary.adapter.ProfileAdapter;
import com.cashmysalary.model.PaymentModel;

import java.util.ArrayList;

public class PaymentFragment extends Fragment implements View.OnClickListener {
    private View main;
    private AppCompatButton btnPay;
    private TextView tvContactUs,tvSubmitApeal;

    public PaymentFragment() {
    }

    public static PaymentFragment newInstance(String param1, String param2) {
        PaymentFragment fragment = new PaymentFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        main = inflater.inflate(R.layout.frag_my_loan,container,false);
        init();
        applyInt();
        return main;

    }

    private void applyInt() {

    }

    private void init() {
        tvContactUs = main.findViewById(R.id.tvContactUs);
        tvSubmitApeal = main.findViewById(R.id.tvSubmitApeal);
        btnPay = main.findViewById(R.id.btnPay);
        btnPay.setOnClickListener(this);
        tvContactUs.setOnClickListener(this);
        tvSubmitApeal.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.tvContactUs) {
            startActivity(new Intent(getActivity(), ContactUsActivity.class));
        }if (v.getId()==R.id.tvSubmitApeal){
            startActivity(new Intent(getActivity(), SubmitAppealActivity.class));
        }
    }
}
