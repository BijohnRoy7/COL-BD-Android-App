    package com.example.colbdapplication.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.colbdapplication.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CustomerListFragment extends Fragment {

    private Button btDue, btScheduled, btCollected;

    public CustomerListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_customer_list, container, false);

        initComponents(view);
        showFragment(new DueFragment());
        onClickListeners();

        return view;
    }


    private void initComponents(View view) {

        btDue = view.findViewById(R.id.bt_due_list);
        btCollected = view.findViewById(R.id.bt_collected_list);
        btScheduled = view.findViewById(R.id.bt_scheduled_list);
    }



    private void onClickListeners() {

        btDue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showFragment(new DueFragment());
            }
        });

        btScheduled.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showFragment(new ScheduleFragment());
            }
        });

        btCollected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showFragment(new CollectedFragment());
            }
        });


    }



    private void showFragment(Fragment fragment){

        FragmentTransaction fr = getActivity().getSupportFragmentManager().beginTransaction();
        fr.replace(R.id.customer_list_frameLayout, fragment);
        fr.commit();
    }



}
