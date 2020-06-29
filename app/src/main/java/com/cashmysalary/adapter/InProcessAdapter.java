package com.cashmysalary.adapter;

import android.content.Context;
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
import com.cashmysalary.model.InProcessModel;

import java.util.ArrayList;

public class InProcessAdapter extends RecyclerView.Adapter<InProcessAdapter.MyViewHolder> {
    private Context mContext;
    private ArrayList<InProcessModel> inProcessModelArrayList;
    public interface ItemClick {
        void onItemClick(int pos);
    }
    public ItemClick itemClick;

    public InProcessAdapter(Context mContext, ArrayList<InProcessModel> inProcessModelArrayList, ItemClick itemClick) {
        this.mContext = mContext;
        this.inProcessModelArrayList = inProcessModelArrayList;
        this.itemClick = itemClick;
    }


    @NonNull
    @Override
    public InProcessAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.in_process_list_item, null);
        return new InProcessAdapter.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull InProcessAdapter.MyViewHolder holder, int position) {
        InProcessModel inProcessModel = inProcessModelArrayList.get(position);
        holder.tvLoanAmt.setText(mContext.getResources().getString(R.string.rs) + " " + inProcessModel.loanAmount + "");
        holder.tvRepaymentAmt.setText(mContext.getResources().getString(R.string.rs) + " " + inProcessModel.repaymentAmt + "");
        holder.tvDueToday.setText(mContext.getResources().getString(R.string.rs) + " " + inProcessModel.dueAmountToday + "");
        holder.tvRepaymentDate.setText("01 July 2020");
        holder.tvLoanId.setText(inProcessModel.loanId);
        holder.tvLoanStatus.setText(inProcessModel.status);
        holder.mainContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClick.onItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return inProcessModelArrayList.size();
    }


    static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tvLoanAmt, tvRepaymentAmt, tvRepaymentDate, tvLoanId, tvLoanStatus, tvDueToday;
        private AppCompatButton btnPay;
        RelativeLayout viewForeground;
        private LinearLayout mainContent;

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
            mainContent = itemView.findViewById(R.id.mainContent);

        }
    }
}


