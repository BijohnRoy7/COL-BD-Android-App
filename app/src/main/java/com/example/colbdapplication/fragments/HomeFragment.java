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
import com.example.colbdapplication.adapters.HomeAdapter;
import com.example.colbdapplication.models.HomeItems;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private RecyclerView recyclerViewHome;
    private HomeAdapter adapter;
    private List<HomeItems> homeItemList;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        initComponents(view);
        populateRecyclerView();

        return view;
    }



    private void initComponents(View view) {

        //recyclerView
        recyclerViewHome = view.findViewById(R.id.RecyclerView_home_fragment);
        recyclerViewHome.setLayoutManager(new LinearLayoutManager(getContext()));
    }


    private void populateRecyclerView() {

        homeItemList = new ArrayList<>();
        homeItemList.add(new HomeItems());
        homeItemList.add(new HomeItems());
        homeItemList.add(new HomeItems());
        homeItemList.add(new HomeItems());
        homeItemList.add(new HomeItems());
        homeItemList.add(new HomeItems());
        homeItemList.add(new HomeItems());
        homeItemList.add(new HomeItems());
        homeItemList.add(new HomeItems());
        homeItemList.add(new HomeItems());
        homeItemList.add(new HomeItems());
        homeItemList.add(new HomeItems());
        homeItemList.add(new HomeItems());
        homeItemList.add(new HomeItems());
        homeItemList.add(new HomeItems());

        adapter = new HomeAdapter(getContext(), homeItemList);
        recyclerViewHome.setAdapter(adapter);

        adapter.setHomeAdapterOnClickListener(new HomeAdapter.HomeAdapterOnClickListener() {
            @Override
            public void myOnClickListener(View view, int position) {
                Toast.makeText(getContext(), "Clicked : "+position, Toast.LENGTH_SHORT).show();
            }
        });
    }

}
