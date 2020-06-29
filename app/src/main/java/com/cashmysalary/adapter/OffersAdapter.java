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
import com.cashmysalary.model.OffersModel;

import java.util.ArrayList;

public class OffersAdapter extends RecyclerView.Adapter<OffersAdapter.MyViewHolder> {
    private Context mContext;
    private ArrayList<OffersModel> offersModelArrayList;

    public OffersAdapter(Context mContext, ArrayList<OffersModel> offersModelArrayList) {
        this.mContext = mContext;
        this.offersModelArrayList = offersModelArrayList;
    }


    @NonNull
    @Override
    public OffersAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.offers_list_item, null);
        return new OffersAdapter.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull OffersAdapter.MyViewHolder holder, int position) {
        OffersModel offersModel = offersModelArrayList.get(position);
        holder.tvHeading.setText(offersModel.header);
        holder.description.setText(offersModel.description);
        holder.code.setText(offersModel.code);
        holder.subDescription.setText(offersModel.subDescription);
        holder.tvValidity.setText(offersModel.validity);
        holder.imDemo.setImageResource(offersModel.headerImage);
    }

    @Override
    public int getItemCount() {
        return offersModelArrayList.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tvHeading, description, subDescription,tvValidity,code;
        private ImageView imDemo;
        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvHeading = itemView.findViewById(R.id.tvHeading);
            description = itemView.findViewById(R.id.description);
            code = itemView.findViewById(R.id.code);
            subDescription = itemView.findViewById(R.id.subDescription);
            tvValidity = itemView.findViewById(R.id.tvValidity);
            imDemo = itemView.findViewById(R.id.imDemo);

        }
    }
}

