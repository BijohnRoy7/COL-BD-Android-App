package com.example.colbdapplication.fragments;


import android.app.Dialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.colbdapplication.R;
import com.example.colbdapplication.adapters.ComplainAdapter;
import com.example.colbdapplication.models.ComplainItem;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ComplainListFragment extends Fragment {

    private RecyclerView recyclerViewComplain;
    private List<ComplainItem> complainItems;
    private ComplainAdapter complainAdapter;

    public ComplainListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_complain_list, container, false);

        initComponents(view);
        populateData();
        return view;
    }

    private void populateData() {
        complainItems = new ArrayList<>();
        complainItems.add(new ComplainItem());
        complainItems.add(new ComplainItem());
        complainItems.add(new ComplainItem());
        complainItems.add(new ComplainItem());
        complainItems.add(new ComplainItem());
        complainItems.add(new ComplainItem());
        complainItems.add(new ComplainItem());
        complainItems.add(new ComplainItem());
        complainItems.add(new ComplainItem());
        complainItems.add(new ComplainItem());
        complainItems.add(new ComplainItem());

        recyclerViewComplain.setLayoutManager(new LinearLayoutManager(getContext()));
        complainAdapter = new ComplainAdapter(getContext(), complainItems);
        recyclerViewComplain.setAdapter(complainAdapter);

        complainAdapter.setComplainItemClickListener(new ComplainAdapter.ComplainItemClickListener() {
            @Override
            public void onItemClick(int position) {
//                Toast.makeText(getContext(), "Read Complain: "+position, Toast.LENGTH_SHORT).show();
                showDialog();
            }
        });
    }

    private void initComponents(View view) {
        recyclerViewComplain = view.findViewById(R.id.recView_complainList);
    }



    // method for showing dialog
    private void showDialog() {

        final Dialog dialog = new Dialog(getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_read_complain);
        dialog.setCancelable(true);

        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(dialog.getWindow().getAttributes());
        layoutParams.width =WindowManager.LayoutParams.MATCH_PARENT;
        layoutParams.height =WindowManager.LayoutParams.MATCH_PARENT;

        Button btSolved = dialog.findViewById(R.id.bt_solved);
        Button btCancel = dialog.findViewById(R.id.bt_cancel);

        btSolved.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                Toast.makeText(getContext(), "Solved", Toast.LENGTH_SHORT).show();
            }
        });

        btCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                Toast.makeText(getContext(), "Cancelled", Toast.LENGTH_SHORT).show();
            }
        });


        ((ImageButton) dialog.findViewById(R.id.bt_close)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });



        dialog.show();
        dialog.getWindow().setAttributes(layoutParams);
    }


}
