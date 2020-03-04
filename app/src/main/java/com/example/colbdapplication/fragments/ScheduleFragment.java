package com.example.colbdapplication.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.colbdapplication.R;
import com.example.colbdapplication.adapters.CollectedAdapter;
import com.example.colbdapplication.adapters.ScheduleAdapter;
import com.example.colbdapplication.models.CollectedItems;
import com.example.colbdapplication.models.ScheduleItems;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScheduleFragment extends Fragment {

    private RecyclerView recyclerViewScheduled;
    private ScheduleAdapter adapter;
    private List<ScheduleItems> scheduleItems;

    public ScheduleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_schedule, container, false);

        initComponents(view);
        populateRecyclerView();

        return view;
    }

    private void initComponents(View view) {
        //recyclerView
        recyclerViewScheduled = view.findViewById(R.id.recViewScheduleFragment);
        recyclerViewScheduled.setLayoutManager(new LinearLayoutManager(getContext()));
    }


    private void populateRecyclerView() {

        scheduleItems = new ArrayList<>();
        scheduleItems.add(new ScheduleItems());
        scheduleItems.add(new ScheduleItems());
        scheduleItems.add(new ScheduleItems());
        scheduleItems.add(new ScheduleItems());
        scheduleItems.add(new ScheduleItems());
        scheduleItems.add(new ScheduleItems());
        scheduleItems.add(new ScheduleItems());
        scheduleItems.add(new ScheduleItems());
        scheduleItems.add(new ScheduleItems());
        scheduleItems.add(new ScheduleItems());
        scheduleItems.add(new ScheduleItems());
        scheduleItems.add(new ScheduleItems());
        scheduleItems.add(new ScheduleItems());

        adapter = new ScheduleAdapter(getContext(), scheduleItems);
        recyclerViewScheduled.setAdapter(adapter);

    }

}
