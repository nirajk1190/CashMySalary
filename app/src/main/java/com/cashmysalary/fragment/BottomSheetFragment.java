package com.cashmysalary.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatButton;

import com.cashmysalary.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class BottomSheetFragment extends BottomSheetDialogFragment implements View.OnClickListener {
    private OnFragmentInteractionListener mListener;
    private View main;
    private AppCompatButton btnApply;
    private EditText etCode;
    private TextView tvSkip;
    private OnSkipClicked onSkipClicked;

    public BottomSheetFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        main = inflater.inflate(R.layout.referral_dialog, container, false);

        init();
        return main;

    }

    private void init() {
        etCode = main.findViewById(R.id.etCode);
        btnApply = main.findViewById(R.id.btnApply);
        tvSkip = main.findViewById(R.id.tvSkip);

        btnApply.setOnClickListener(this);
        tvSkip.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnApply) {
            if (mListener != null||onSkipClicked!=null) {
                mListener.onFragmentInteraction(etCode.getText().toString());
                onSkipClicked.onSkipClicked(true);
                dismiss();
            }
        }
        if (v.getId() == R.id.tvSkip) {
            if (onSkipClicked!=null){
                onSkipClicked.onSkipClicked(true);
                dismiss();
            }
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
        onSkipClicked = null;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
            onSkipClicked = (OnSkipClicked) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnFragmentInteractionListener");
        }

    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(String value);
    }

    public interface OnSkipClicked {
        void onSkipClicked(boolean isSkiped);
    }
}
