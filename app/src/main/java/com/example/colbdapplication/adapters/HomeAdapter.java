package com.example.colbdapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.colbdapplication.R;
import com.example.colbdapplication.models.HomeItems;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {

    private Context context;
    private List<HomeItems> items;
    private HomeAdapterOnClickListener homeAdapterOnClickListener;

    public HomeAdapter(Context context, List<HomeItems> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public HomeAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.single_home_list_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeAdapter.MyViewHolder holder, final int position) {


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (homeAdapterOnClickListener != null){
                    homeAdapterOnClickListener.myOnClickListener(view, position);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    public interface HomeAdapterOnClickListener{
        void myOnClickListener(View view, int position);
    }

    public void setHomeAdapterOnClickListener(HomeAdapterOnClickListener homeAdapterOnClickListener) {
        this.homeAdapterOnClickListener = homeAdapterOnClickListener;
    }
}
