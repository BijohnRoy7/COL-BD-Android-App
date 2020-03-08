package com.example.colbdapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.colbdapplication.R;
import com.example.colbdapplication.models.ComplainItem;

import java.util.List;

public class ComplainAdapter extends RecyclerView.Adapter<ComplainAdapter.MyViewHolder> {

    private Context context;
    private List<ComplainItem> complainItems;
    private ComplainItemClickListener complainItemClickListener;

    public ComplainAdapter(Context context, List<ComplainItem> complainItems) {
        this.context = context;
        this.complainItems = complainItems;
    }

    @NonNull
    @Override
    public ComplainAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.single_complain_list_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ComplainAdapter.MyViewHolder holder, final int position) {

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (complainItemClickListener != null){
                    complainItemClickListener.onItemClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return complainItems.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }


    public interface ComplainItemClickListener{
        void onItemClick(int position);
    }

    public void setComplainItemClickListener(ComplainItemClickListener complainItemClickListener) {
        this.complainItemClickListener = complainItemClickListener;
    }
}
