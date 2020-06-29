package com.cashmysalary.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.cashmysalary.R;
import com.cashmysalary.model.LoanRecordItem;

import java.util.ArrayList;

public class LoanRecordAdapter extends RecyclerView.Adapter<LoanRecordAdapter.ItemViewHolder> {
    private Context mContext;
    private ArrayList<LoanRecordItem> loanRecordItems;

    public interface ItemClick {
        void onItemClick(int pos);
    }
    public ItemClick itemClick;

    public LoanRecordAdapter(Context mContext, ArrayList<LoanRecordItem> loanRecordItems, ItemClick itemClick) {
        this.mContext = mContext;
        this.loanRecordItems = loanRecordItems;
        this.itemClick = itemClick;
    }

    @Override
    public LoanRecordAdapter.ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_loan_record_data, null);
        return new LoanRecordAdapter.ItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(LoanRecordAdapter.ItemViewHolder holder, final int position) {
        LoanRecordItem loanRecordItem = loanRecordItems.get(position);

        if (loanRecordItem.applicationStatus == 0) {
            holder.tvStatus.setText("Approved");
            holder.rlHeader.setBackground(mContext.getResources().getDrawable(R.drawable.green_line));

        } else {
            holder.tvStatus.setText("Pending");
            holder.rlHeader.setBackground(mContext.getResources().getDrawable(R.drawable.repayment_yellowbox));
        }

        holder.tvLoanNumber.setText(loanRecordItem.loanNumber);
        holder.tvApplicantName.setText(loanRecordItem.applicantName);
        holder.tvApplicantDate.setText(loanRecordItem.applicationDate);
        holder.tvLoanAmt.setText("₹ " + loanRecordItem.loanAmount + "");
        holder.tvTenureValue.setText(loanRecordItem.tenure + " Days" + "");
        holder.mainContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClick.onItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return loanRecordItems.size();
    }


    public class ItemViewHolder extends RecyclerView.ViewHolder {
        private CardView mainContent;
        private TextView tvStatus, tvLoanType, tvLoanNumber, tvApplicantName,
                tvApplicantDate, tvLoanAmt, tvTenureValue;
        private RelativeLayout rlHeader;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            rlHeader = itemView.findViewById(R.id.rlHeader);
            mainContent = itemView.findViewById(R.id.mainContent);
            tvStatus = itemView.findViewById(R.id.tvStatus);
            tvLoanType = itemView.findViewById(R.id.tvLoanType);
            tvLoanNumber = itemView.findViewById(R.id.tvLoanNumber);
            tvApplicantName = itemView.findViewById(R.id.tvApplicantName);
            tvApplicantDate = itemView.findViewById(R.id.tvApplicantDate);
            tvLoanAmt = itemView.findViewById(R.id.tvLoanAmt);
            tvTenureValue = itemView.findViewById(R.id.tvTenureValue);
        }
    }
}
