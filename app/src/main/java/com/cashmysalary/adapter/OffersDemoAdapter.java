package com.cashmysalary.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cashmysalary.R;
import com.cashmysalary.model.OffersDemoModel;
import com.cashmysalary.model.OffersModel;

import java.util.ArrayList;

public class OffersDemoAdapter extends RecyclerView.Adapter<OffersDemoAdapter.MyViewHolder> {
    private Context mContext;
    private ArrayList<OffersDemoModel> offersModelArrayList;

    public OffersDemoAdapter(Context mContext, ArrayList<OffersDemoModel> offersModelArrayList) {
        this.mContext = mContext;
        this.offersModelArrayList = offersModelArrayList;
    }


    @NonNull
    @Override
    public OffersDemoAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.offers_demo_list_item, null);
        return new OffersDemoAdapter.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull OffersDemoAdapter.MyViewHolder holder, int position) {
        OffersDemoModel offersModel = offersModelArrayList.get(position);
        holder.tvBrand.setText(offersModel.brand);
        holder.tvCode.setText(offersModel.couponCode);
        holder.tvValue.setText(offersModel.couponValue);
        holder.tvDate.setText(offersModel.validity);
    }

    @Override
    public int getItemCount() {
        return offersModelArrayList.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tvBrand,tvCode, tvValue, tvDate;
        private ImageView ivCopy;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCode = itemView.findViewById(R.id.tvCode);
            tvBrand = itemView.findViewById(R.id.tvBrand);
            tvValue = itemView.findViewById(R.id.tvValue);
            tvDate = itemView.findViewById(R.id.tvDate);
            ivCopy = itemView.findViewById(R.id.ivCopy);

        }
    }
}

