package com.cashmysalary.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import com.cashmysalary.R;
import com.cashmysalary.model.UpComingPaymentModel;

import java.util.ArrayList;

public class UpComingPaymentAdapter extends RecyclerView.Adapter<UpComingPaymentAdapter.MyViewHolder> {
    private Context mContext;
    private ArrayList<UpComingPaymentModel> upComingPaymentModelArrayList;

    public UpComingPaymentAdapter(Context mContext, ArrayList<UpComingPaymentModel> upComingPaymentModelArrayList) {
        this.mContext = mContext;
        this.upComingPaymentModelArrayList = upComingPaymentModelArrayList;
    }


    @NonNull
    @Override
    public UpComingPaymentAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.up_coming_payment_list_item, null);
        return new UpComingPaymentAdapter.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull UpComingPaymentAdapter.MyViewHolder holder, int position) {
        UpComingPaymentModel upComingPaymentModel = upComingPaymentModelArrayList.get(position);
        holder.tvLoanAmt.setText(mContext.getResources().getString(R.string.rs)+" "+upComingPaymentModel.loanAmount+"");
        holder.tvRepaymentAmt.setText(mContext.getResources().getString(R.string.rs)+" "+upComingPaymentModel.repaymentAmt+"");
        holder.tvDueToday.setText(mContext.getResources().getString(R.string.rs)+" "+upComingPaymentModel.dueAmountToday+"");
        holder.tvRepaymentDate.setText("01 July 2020");
        holder.tvLoanId.setText(upComingPaymentModel.loanId);
        holder.tvLoanStatus.setText(upComingPaymentModel.status);
    }

    @Override
    public int getItemCount() {
        return upComingPaymentModelArrayList.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tvLoanAmt, tvRepaymentAmt, tvRepaymentDate,tvLoanId,tvLoanStatus,tvDueToday;
        private AppCompatButton btnPay;
        public RelativeLayout viewForeground, viewBackground;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvLoanAmt = itemView.findViewById(R.id.tvLoanAmt);
            tvLoanId = itemView.findViewById(R.id.tvLoanId);
            tvRepaymentAmt = itemView.findViewById(R.id.tvRepaymentAmt);
            tvRepaymentDate = itemView.findViewById(R.id.tvRepaymentDate);
            tvLoanStatus = itemView.findViewById(R.id.tvLoanStatus);
            tvDueToday = itemView.findViewById(R.id.tvDueToday);
            btnPay = itemView.findViewById(R.id.btnPay);
            viewForeground = itemView.findViewById(R.id.view_foreground);
            viewBackground = itemView.findViewById(R.id.view_background);

        }
    }
}

