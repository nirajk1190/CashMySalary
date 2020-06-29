package com.cashmysalary.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.cashmysalary.R;
import com.cashmysalary.activity.ApplicationStatusActivity;
import com.cashmysalary.activity.CalculatorActivity;
import com.cashmysalary.activity.OffersActivity;
import com.cashmysalary.activity.OffersDemoActivity;
import com.cashmysalary.activity.ProfileActivity;
import com.cashmysalary.activity.RejectionActivity;
import com.cashmysalary.activity.UpComingPaymentsAct;

public class HomeFragment extends Fragment implements View.OnClickListener {
    private View main;
    private CardView cvProfile,cvApplyNow,cvCredit,cvPayments,cvStatus,cvOffer;
    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        main = inflater.inflate(R.layout.frag_home, container, false);
        init();
        applyInit();

        return main;
    }

    private void applyInit() {

    }

    private void init() {
        cvProfile = main.findViewById(R.id.cvProfile);
        cvApplyNow = main.findViewById(R.id.cvApplyNow);
        cvCredit = main.findViewById(R.id.cvCredit);
        cvPayments = main.findViewById(R.id.cvPayments);
        cvStatus = main.findViewById(R.id.cvStatus);
        cvOffer = main.findViewById(R.id.cvOffer);

        cvProfile.setOnClickListener(this);
        cvApplyNow.setOnClickListener(this);
        cvCredit.setOnClickListener(this);
        cvPayments.setOnClickListener(this);
        cvStatus.setOnClickListener(this);
        cvOffer.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.cvProfile){
            startActivity(new Intent(getActivity(), ProfileActivity.class));
        }if (v.getId()==R.id.cvApplyNow){
            startActivity(new Intent(getActivity(), CalculatorActivity.class));
        }if (v.getId()==R.id.cvCredit){
//            startActivity(new Intent(getActivity(), RejectionActivity.class));
        }if (v.getId()==R.id.cvPayments){
            startActivity(new Intent(getActivity(), UpComingPaymentsAct.class));
        }if (v.getId()==R.id.cvStatus){
            startActivity(new Intent(getActivity(), ApplicationStatusActivity.class));
        }if (v.getId()==R.id.cvOffer){
            startActivity(new Intent(getActivity(), OffersActivity.class));
        }
    }
}
