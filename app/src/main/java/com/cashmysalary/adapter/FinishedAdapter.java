package com.cashmysalary.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import com.cashmysalary.R;
import com.cashmysalary.activity.CalculatorActivity;
import com.cashmysalary.model.FinishedModel;
import com.cashmysalary.model.InProcessModel;

import java.util.ArrayList;

public class FinishedAdapter extends RecyclerView.Adapter<FinishedAdapter.MyViewHolder> {
    private Context mContext;
    private ArrayList<FinishedModel> finishedModelArrayList;

    public FinishedAdapter(Context mContext, ArrayList<FinishedModel> finishedModelArrayList) {
        this.mContext = mContext;
        this.finishedModelArrayList = finishedModelArrayList;
    }


    @NonNull
    @Override
    public FinishedAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.finished_list_items, null);
        return new FinishedAdapter.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FinishedAdapter.MyViewHolder holder, int position) {
        FinishedModel finishedModel = finishedModelArrayList.get(position);
        holder.tvAmtDue.setText(mContext.getResources().getString(R.string.rs) + " " + finishedModel.loanAmount + "");
        holder.tvpayAmt.setText(mContext.getResources().getString(R.string.rs) + " " + finishedModel.paidAmount + "");

        holder.tvLoanId.setText(finishedModel.loanId);
        holder.btnStatus.setText(finishedModel.status);
        holder.btnApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext, CalculatorActivity.class));
            }
        });

    }

    @Override
    public int getItemCount() {
        return finishedModelArrayList.size();
    }


    static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tvAmtDue, tvDueDate, tvpayAmt,tvPaymentDate, tvLoanId;
        private AppCompatButton btnStatus;
        private AppCompatButton btnGenerateNOC,btnApply;
        RelativeLayout viewForeground;
        private LinearLayout mainContent;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvAmtDue = itemView.findViewById(R.id.tvAmtDue);
            tvLoanId = itemView.findViewById(R.id.tvLoanId);
            tvDueDate = itemView.findViewById(R.id.tvDueDate);
            tvpayAmt = itemView.findViewById(R.id.tvpayAmt);

            tvPaymentDate = itemView.findViewById(R.id.tvPaymentDate);
            btnStatus = itemView.findViewById(R.id.btnStatus);
            btnGenerateNOC = itemView.findViewById(R.id.btnGenerateNOC);
            btnApply = itemView.findViewById(R.id.btnApply);
            viewForeground = itemView.findViewById(R.id.view_foreground);
            mainContent = itemView.findViewById(R.id.mainContent);

        }
    }
}


