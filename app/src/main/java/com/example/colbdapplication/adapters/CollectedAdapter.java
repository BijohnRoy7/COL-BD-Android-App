package com.example.colbdapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.colbdapplication.R;
import com.example.colbdapplication.models.CollectedItems;

import java.util.List;

public class CollectedAdapter extends RecyclerView.Adapter<CollectedAdapter.MyViewHolder> {

    private Context context;
    private List<CollectedItems> collectedItems ;
    public CollectedItemOnClickListener itemOnClickListener;

    public CollectedAdapter(Context context, List<CollectedItems> collectedItems) {
        this.context = context;
        this.collectedItems = collectedItems;
    }

    @NonNull
    @Override
    public CollectedAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.single_collected_list_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CollectedAdapter.MyViewHolder holder, final int position) {


        holder.btDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (itemOnClickListener != null){
                    itemOnClickListener.onClickForDetails(position);
                }
            }
        });

        holder.btCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (itemOnClickListener != null){
                    itemOnClickListener.onClickForCall(position);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return collectedItems.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageButton btDetails, btCall;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            btDetails = itemView.findViewById(R.id.bt_due_details);
            btCall = itemView.findViewById(R.id.bt_due_call);
        }
    }


    public interface CollectedItemOnClickListener{
        void onClickForDetails(int position);
        void onClickForCall(int position);
    }

    public void setItemOnClickListener(CollectedItemOnClickListener itemOnClickListener) {
        this.itemOnClickListener = itemOnClickListener;
    }
}
