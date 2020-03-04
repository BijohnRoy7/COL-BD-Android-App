package com.example.colbdapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.colbdapplication.R;
import com.example.colbdapplication.models.DueItems;
import com.example.colbdapplication.models.HomeItems;

import java.util.List;

public class DueAdapter extends RecyclerView.Adapter<DueAdapter.MyViewHolder> {

    private Context context;
    private List<DueItems> items;
    private DueAdapterOnItemClickListener dueItemClickListener;

    public DueAdapter(Context context, List<DueItems> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public DueAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.single_due_list_item, parent, false);
        return new DueAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DueAdapter.MyViewHolder holder, final int position) {


        holder.btDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (dueItemClickListener != null){
                    dueItemClickListener.onDueItemClickForDetails(view, position);
                }
            }
        });

        holder.btCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (dueItemClickListener != null){
                    dueItemClickListener.onDueItemClickForCall(view, position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageButton btCall, btDetails;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            btCall = itemView.findViewById(R.id.bt_due_call);
            btDetails = itemView.findViewById(R.id.bt_due_details);
        }
    }


    // interface for OnItemClickListener
    public interface DueAdapterOnItemClickListener{
        void onDueItemClickForDetails(View view, int position);
        void onDueItemClickForCall(View view, int position);
    }

    // initializing DueAdapterOnItemClickListener instance
    public void setDueItemClickListener(DueAdapterOnItemClickListener dueItemClickListener) {
        this.dueItemClickListener = dueItemClickListener;
    }
}