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
import com.cashmysalary.model.NotificationModel;

import java.util.ArrayList;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.MyViewHolder> {
    private Context mContext;
    private ArrayList<NotificationModel> notificationModels;

    public NotificationAdapter(Context mContext, ArrayList<NotificationModel> notificationModels) {
        this.mContext = mContext;
        this.notificationModels = notificationModels;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.notification_list_item, null);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        NotificationModel notificationModel = notificationModels.get(position);
        holder.tvHeading.setText(notificationModel.notificationHeader);
        holder.description.setText(notificationModel.notificationSubContent);
        holder.tvTime.setText(notificationModel.notificationTime);
        holder.tvDate.setText(notificationModel.notificationDate);

        if (notificationModel.isPayBtn) {
            holder.btnPay.setVisibility(View.VISIBLE);
        } else {
            holder.btnPay.setVisibility(View.GONE);
        }

    }

    @Override
    public int getItemCount() {
        return notificationModels.size();
    }

    public void removeItem(int position) {
        notificationModels.remove(position);
        // notify the item removed by position
        // to perform recycler view delete animations
        // NOTE: don't call notifyDataSetChanged()
        notifyItemRemoved(position);
    }

    public void restoreItem(NotificationModel notificationModel, int position) {
        notificationModels.add(position, notificationModel);
        // notify item added by position
        notifyItemInserted(position);
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView delete_icon;
        private TextView tvHeading, tvTime, description,tvDate;
        private AppCompatButton btnPay;
        public RelativeLayout viewForeground, viewBackground;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            delete_icon = itemView.findViewById(R.id.delete_icon);
            tvHeading = itemView.findViewById(R.id.tvHeading);
            tvTime = itemView.findViewById(R.id.tvTime);
            tvDate = itemView.findViewById(R.id.tvDate);
            description = itemView.findViewById(R.id.description);
            btnPay = itemView.findViewById(R.id.btnPay);
            viewForeground = itemView.findViewById(R.id.view_foreground);
            viewBackground = itemView.findViewById(R.id.view_background);

        }
    }
}
