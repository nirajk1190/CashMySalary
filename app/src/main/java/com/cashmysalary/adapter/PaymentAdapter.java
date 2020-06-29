package com.cashmysalary.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import com.cashmysalary.R;
import com.cashmysalary.model.PaymentModel;


import java.util.ArrayList;

public class PaymentAdapter extends RecyclerView.Adapter<PaymentAdapter.ItemViewHolder> {
    private Context mContext;
    private ArrayList<PaymentModel> paymentModelArrayList;

    public PaymentAdapter(Context mContext, ArrayList<PaymentModel> paymentModelArrayList){
        this.mContext = mContext;
        this.paymentModelArrayList=paymentModelArrayList;
    }

    @Override
    public PaymentAdapter.ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.payment_data, null);
        return new PaymentAdapter.ItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PaymentAdapter.ItemViewHolder holder, int position) {
        PaymentModel paymentModel = paymentModelArrayList.get(position);
        holder.tvHeading.setText(paymentModel.heading);
        holder.tvSubHeading.setText(paymentModel.subHeading);
        holder.ivHeading.setImageResource(paymentModel.icon);
    }

    @Override
    public int getItemCount() {
        return paymentModelArrayList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        public ImageView ivHeading,ivRight;
        private TextView tvHeading,tvSubHeading;
        public ItemViewHolder(View itemView) {
            super(itemView);
            ivHeading = itemView.findViewById(R.id.ivHeading);
            ivRight = itemView.findViewById(R.id.ivRight);
            tvHeading = itemView.findViewById(R.id.tvHeading);
            tvSubHeading = itemView.findViewById(R.id.tvSubHeading);
        }
    }
}

