package com.cashmysalary.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.cashmysalary.R;
import com.cashmysalary.activity.DetailWithPayActivity;
import com.cashmysalary.activity.LoanDetailsActivity;
import com.cashmysalary.activity.RejectionActivity;
import com.cashmysalary.activity.RepaymentDetailsActivity;
import com.cashmysalary.model.ApplicationStatusModel;
import com.cashmysalary.model.LoanRecordItem;

import java.util.ArrayList;

public class ApplicationStatusAdapter extends RecyclerView.Adapter<ApplicationStatusAdapter.ItemViewHolder> {
    private Context mContext;
    private ArrayList<ApplicationStatusModel> applicationStatusModelArrayList;

    public ApplicationStatusAdapter(Context mContext, ArrayList<ApplicationStatusModel> applicationStatusModelArrayList) {
        this.mContext = mContext;
        this.applicationStatusModelArrayList = applicationStatusModelArrayList;
    }

    @Override
    public ApplicationStatusAdapter.ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_application_status_data, null);
        return new ItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ApplicationStatusAdapter.ItemViewHolder holder, final int position) {
        ApplicationStatusModel applicationStatus = applicationStatusModelArrayList.get(position);

        if (applicationStatus.applicationStatus == 0) {
            holder.btnDetails.setText(applicationStatus.btnText);
            holder.btnDetails.setVisibility(View.VISIBLE);
            holder.btnStatus.setBackground(mContext.getResources().getDrawable(R.drawable.oval_yellow_shape));

        } else if (applicationStatus.applicationStatus==1){
            holder.btnReason.setText(applicationStatus.btnText);
            holder.btnReason.setVisibility(View.VISIBLE);
            holder.btnStatus.setBackground(mContext.getResources().getDrawable(R.drawable.oval_red_shape));
        }else if (applicationStatus.applicationStatus==2){
            holder.btnAccept.setText(applicationStatus.btnText);
            holder.btnAccept.setVisibility(View.VISIBLE);
            holder.btnStatus.setBackground(mContext.getResources().getDrawable(R.drawable.oval_green_shape));
        }else if (applicationStatus.applicationStatus==3){
            holder.btnDetails.setText(applicationStatus.btnText);
            holder.btnDetails.setVisibility(View.VISIBLE);
            holder.btnStatus.setBackground(mContext.getResources().getDrawable(R.drawable.oval_green_shape));

        }
        holder.btnStatus.setText(applicationStatus.status);
        holder.tvLoanNumber.setText(applicationStatus.loanNumber);
        holder.tvApplicantName.setText(applicationStatus.applicantName);
        holder.tvApplicantDate.setText(applicationStatus.applicationDate);
        holder.tvLoanAmt.setText("₹ " + applicationStatus.loanAmount + "");
        holder.tvTenureValue.setText(applicationStatus.tenure + " Days" + "");

        if (applicationStatus.applicationStatus==0){
            holder.btnDetails.setOnClickListener(v -> {
                /*submitted show detail*/
                mContext.startActivity(new Intent(mContext, LoanDetailsActivity.class));
            });
        }if (applicationStatus.applicationStatus==3){
            holder.btnDetails.setOnClickListener(v -> {
                /*disbursed show detail*/
                mContext.startActivity(new Intent(mContext, DetailWithPayActivity.class));
            });
        }

        holder.btnReason.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext, RejectionActivity.class));
            }
        });
        holder.btnAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext, RepaymentDetailsActivity.class));

            }
        });

    }

    @Override
    public int getItemCount() {
        return applicationStatusModelArrayList.size();
    }


    static class ItemViewHolder extends RecyclerView.ViewHolder {
        private CardView mainContent;
        private TextView tvLoanNumber, tvApplicantName,
                tvApplicantDate, tvLoanAmt, tvTenureValue;
        private AppCompatButton btnStatus,btnDetails,btnAccept,btnReason;

        ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            mainContent = itemView.findViewById(R.id.mainContent);
            tvLoanNumber = itemView.findViewById(R.id.tvLoanNumber);
            tvApplicantName = itemView.findViewById(R.id.tvApplicantName);
            tvApplicantDate = itemView.findViewById(R.id.tvApplicantDate);
            tvLoanAmt = itemView.findViewById(R.id.tvLoanAmt);
            tvTenureValue = itemView.findViewById(R.id.tvTenureValue);
            btnStatus = itemView.findViewById(R.id.btnStatus);
            btnDetails = itemView.findViewById(R.id.btnDetails);
            btnAccept = itemView.findViewById(R.id.btnAccept);
            btnReason = itemView.findViewById(R.id.btnReason);
        }
    }
}
