package com.example.colbdapplication.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.colbdapplication.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SyncFragment extends Fragment {


    public SyncFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sync, container, false);
    }

}
