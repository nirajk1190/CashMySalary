package com.cashmysalary.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cashmysalary.R;
import com.cashmysalary.model.LoanRecordItemDetailModel;

import java.util.ArrayList;

public class LoanRecordDetailAdapter extends RecyclerView.Adapter<LoanRecordDetailAdapter.ItemViewHolder> {
    private Context mContext;
    private ArrayList<LoanRecordItemDetailModel> loanRecordItemDetailModels;
    private boolean isButtonClick = false;

    public LoanRecordDetailAdapter(Context mContext, ArrayList<LoanRecordItemDetailModel> loanRecordItemDetailModels) {
        this.mContext = mContext;
        this.loanRecordItemDetailModels = loanRecordItemDetailModels;
    }

    @NonNull
    @Override
    public LoanRecordDetailAdapter.ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_loan_record_detail_data, null);
        return new ItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final LoanRecordDetailAdapter.ItemViewHolder holder, final int position) {
        LoanRecordItemDetailModel loanRecordItemDetailModel = loanRecordItemDetailModels.get(position);

        holder.tvTerm.setText(loanRecordItemDetailModel.term);
        holder.tvEmiAmount.setText(mContext.getResources().getString(R.string.rs)+" "+loanRecordItemDetailModel.emiAmount+"");
        holder.tvTermStatus.setText(loanRecordItemDetailModel.termStatus);
        holder.tvTermRepaymentDate.setText(loanRecordItemDetailModel.repaymentDate);
        holder.tvPrincipal.setText(mContext.getResources().getString(R.string.principal)+" "+mContext.getResources().getString(R.string.rs)+" "+loanRecordItemDetailModel.principal+"");
        holder.tvOverDueDays.setText(mContext.getResources().getString(R.string.overdue_days)+" "+loanRecordItemDetailModel.overdueDays+" "+"Days"+"");
        holder.tvOverDueFeeGST.setText(mContext.getResources().getString(R.string.overdue_fees_gst)+" "+mContext.getResources().getString(R.string.rs)+" "+loanRecordItemDetailModel.overDueFeeGST+"");
        holder.tvInterestAmt.setText(mContext.getResources().getString(R.string.interest_amount)+" "+mContext.getResources().getString(R.string.rs)+" "+loanRecordItemDetailModel.interest+"");
        holder.tvOverdueFees.setText(mContext.getResources().getString(R.string.overdue_fees)+" "+mContext.getResources().getString(R.string.rs)+" "+loanRecordItemDetailModel.overDueFees+"");
        holder.tvDefaultFees.setText(mContext.getResources().getString(R.string.default_fees)+" "+mContext.getResources().getString(R.string.rs)+" "+loanRecordItemDetailModel.defaultFees+"");
        holder.rlEmiAmt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isButtonClick){
                    holder.llEmiDetails.setVisibility(View.GONE);
                    holder.dropDown.setImageResource(R.drawable.ic_arrow_drop_up_red);

                    isButtonClick = false;
                }else {
                    holder.llEmiDetails.setVisibility(View.VISIBLE);
                    holder.dropDown.setImageResource(R.drawable.ic_arrow_drop_down_red);
                    isButtonClick = true;
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return loanRecordItemDetailModels.size();
    }


    static class ItemViewHolder extends RecyclerView.ViewHolder {
        private TextView tvTerm, tvEmiAmount, tvTermStatus, tvTermRepaymentDate,
                tvPrincipal, tvOverDueDays, tvOverDueFeeGST, tvInterestAmt,
                tvOverdueFees, tvDefaultFees;
        private RelativeLayout rlEmiAmt;
        private LinearLayout llEmiDetails;
        private ImageView dropDown;

        ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTerm = itemView.findViewById(R.id.tvTerm);
            tvEmiAmount = itemView.findViewById(R.id.tvEmiAmount);
            tvTermStatus = itemView.findViewById(R.id.tvTermStatus);
            tvTermRepaymentDate = itemView.findViewById(R.id.tvTermRepaymentDate);
            tvPrincipal = itemView.findViewById(R.id.tvPrincipal);
            tvOverDueDays = itemView.findViewById(R.id.tvOverDueDays);
            tvOverDueFeeGST = itemView.findViewById(R.id.tvOverDueFeeGST);
            tvInterestAmt = itemView.findViewById(R.id.tvInterestAmt);
            tvOverdueFees = itemView.findViewById(R.id.tvOverdueFees);
            tvDefaultFees = itemView.findViewById(R.id.tvDefaultFees);

            rlEmiAmt = itemView.findViewById(R.id.rlEmiAmt);
            llEmiDetails = itemView.findViewById(R.id.llEmiDetails);
            dropDown = itemView.findViewById(R.id.dropDown);
        }
    }
}

