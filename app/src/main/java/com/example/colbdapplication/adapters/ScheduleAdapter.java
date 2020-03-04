package com.example.colbdapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.colbdapplication.R;
import com.example.colbdapplication.models.ScheduleItems;

import java.util.List;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.MyViewHolder> {

    private Context context;
    private List<ScheduleItems> scheduleItems;

    public ScheduleAdapter(Context context, List<ScheduleItems> scheduleItems) {
        this.context = context;
        this.scheduleItems = scheduleItems;
    }

    @NonNull
    @Override
    public ScheduleAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.single_schedule_list_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ScheduleAdapter.MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return scheduleItems.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
