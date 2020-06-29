package com.cashmysalary.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.cashmysalary.R;
import com.cashmysalary.model.ProfileDataModel;

import java.util.ArrayList;

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ItemViewHolder> {
    private Context mContext;
    private ArrayList<ProfileDataModel> profileDataModelArrayList;
    public interface ItemClick{
        void onItemClick(int pos);
    }
    public ItemClick itemClick;
    public ProfileAdapter(Context mContext, ArrayList<ProfileDataModel> profileDataModels,ItemClick itemClick){
        this.mContext = mContext;
        this.profileDataModelArrayList=profileDataModels;
        this.itemClick = itemClick;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_profile_data, null);
        return new ItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, final int position) {
        ProfileDataModel profileDataModel = profileDataModelArrayList.get(position);
        holder.tvHeading.setText(profileDataModel.title);
        holder.ivHeading.setImageResource(profileDataModel.headerImage);
        holder.ivPending.setVisibility(View.VISIBLE);
        holder.cvMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClick.onItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return profileDataModelArrayList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        public ImageView ivHeading,ivPending,ivTick;
        private TextView tvHeading;
        private CardView cvMain;
        public ItemViewHolder(View itemView) {
            super(itemView);
            cvMain = itemView.findViewById(R.id.cvMain);
            ivHeading = itemView.findViewById(R.id.ivHeading);
            ivPending = itemView.findViewById(R.id.ivPending);
            ivTick = itemView.findViewById(R.id.ivTick);
            tvHeading = itemView.findViewById(R.id.tvHeading);
        }
    }
}
