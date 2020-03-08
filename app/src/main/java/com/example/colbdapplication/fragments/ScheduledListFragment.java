package com.example.colbdapplication.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.colbdapplication.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScheduledListFragment extends Fragment {


    private Button btDue, btScheduled, btCollected;
    private LinearLayout bgDue, bgSchedule, bgCollected;


    public ScheduledListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_scheduled_list, container, false);

        initComponents(view);

        // showing default fragment
        showFragment(new ScheduleFragment());
        btScheduled.setTextSize(14f);
        bgSchedule.setVisibility(View.VISIBLE);

        onClickListeners();

        return view;
    }



    private void initComponents(View view) {

        btDue = view.findViewById(R.id.bt_due_list);
        btCollected = view.findViewById(R.id.bt_collected_list);
        btScheduled = view.findViewById(R.id.bt_scheduled_list);

        bgDue = view.findViewById(R.id.due_bottom_bg_ScheduleList);
        bgSchedule = view.findViewById(R.id.schedule_bottom_bg_ScheduleList);
        bgCollected = view.findViewById(R.id.collected_bottom_bg_ScheduleList);
    }


    private void onClickListeners() {

        btDue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showFragment(new DueFragment());

                btDue.setTextSize(14f);
                btScheduled.setTextSize(12f);
                btCollected.setTextSize(12f);

                bgDue.setVisibility(View.VISIBLE);
                bgCollected.setVisibility(View.GONE);
                bgSchedule.setVisibility(View.GONE);

            }
        });

        btScheduled.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showFragment(new ScheduleFragment());

                btScheduled.setTextSize(14f);
                btDue.setTextSize(12f);
                btCollected.setTextSize(12f);

                bgSchedule.setVisibility(View.VISIBLE);
                bgDue.setVisibility(View.GONE);
                bgCollected.setVisibility(View.GONE);
            }
        });

        btCollected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showFragment(new CollectedFragment());

                btCollected.setTextSize(14f);
                btScheduled.setTextSize(12f);
                btDue.setTextSize(12f);

                bgCollected.setVisibility(View.VISIBLE);
                bgDue.setVisibility(View.GONE);
                bgSchedule.setVisibility(View.GONE);
            }
        });


    }


    private void showFragment(Fragment fragment){

        FragmentTransaction fr = getActivity().getSupportFragmentManager().beginTransaction();
        fr.replace(R.id.customer_list_frameLayout, fragment);
        fr.commit();
    }





}
