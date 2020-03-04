package com.example.colbdapplication.fragments;


import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.colbdapplication.R;
import com.example.colbdapplication.adapters.CollectedAdapter;
import com.example.colbdapplication.models.CollectedItems;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CollectedFragment extends Fragment {

    private RecyclerView recyclerViewCollected;
    private CollectedAdapter adapter;
    private List<CollectedItems> collectedItems;

    private DatePicker datePicker;
    private Calendar calendar;
    private int year, month, day;
    private Button btPickDate;

    public CollectedFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_collected, container, false);

        initComponents(view);
        populateRecyclerView();

        return view;
    }

    private void initComponents(View view) {
        //recyclerView
        recyclerViewCollected = view.findViewById(R.id.RecyclerView_collected_fragment);
        recyclerViewCollected.setLayoutManager(new LinearLayoutManager(getContext()));
    }


    private void populateRecyclerView() {

        collectedItems = new ArrayList<>();
        collectedItems.add(new CollectedItems());
        collectedItems.add(new CollectedItems());
        collectedItems.add(new CollectedItems());
        collectedItems.add(new CollectedItems());
        collectedItems.add(new CollectedItems());
        collectedItems.add(new CollectedItems());
        collectedItems.add(new CollectedItems());
        collectedItems.add(new CollectedItems());
        collectedItems.add(new CollectedItems());
        collectedItems.add(new CollectedItems());
        collectedItems.add(new CollectedItems());
        collectedItems.add(new CollectedItems());
        collectedItems.add(new CollectedItems());
        collectedItems.add(new CollectedItems());
        collectedItems.add(new CollectedItems());

        adapter = new CollectedAdapter(getContext(), collectedItems);
        recyclerViewCollected.setAdapter(adapter);

        adapter.setItemOnClickListener(new CollectedAdapter.CollectedItemOnClickListener() {
            @Override
            public void onClickForDetails(int position) {
                Toast.makeText(getContext(), "Details", Toast.LENGTH_SHORT).show();
                showDetailsDialog();
            }

            @Override
            public void onClickForCall(int position) {
                Toast.makeText(getContext(), "Calling", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showDetailsDialog() {

        final Dialog dialog = new Dialog(getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_collected_item_info);
        dialog.setCancelable(true);

        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(dialog.getWindow().getAttributes());
        layoutParams.width =WindowManager.LayoutParams.MATCH_PARENT;
        layoutParams.height =WindowManager.LayoutParams.MATCH_PARENT;


        Button btVisit = dialog.findViewById(R.id.bt_visit_collected_dialog);
        Button btCollection = dialog.findViewById(R.id.bt_collection_dialog);
        Button btReports    = dialog.findViewById(R.id.bt_reports_dialog);
        Button btSms        = dialog.findViewById(R.id.bt_sms_dialog);
        Button btSchedule   = dialog.findViewById(R.id.bt_schedule_dialog);
        Button btComplain   = dialog.findViewById(R.id.bt_complain_dialog);


        ((ImageButton) dialog.findViewById(R.id.bt_close)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        btVisit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(getContext(), "Visit", Toast.LENGTH_SHORT).show();
                showVisitDialog(dialog);
            }
        });

        btCollection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Showing Collection", Toast.LENGTH_SHORT).show();
                showCollectionDialog(dialog);
            }
        });

        btReports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Reporting", Toast.LENGTH_SHORT).show();
            }
        });

        btSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Sending SMS", Toast.LENGTH_SHORT).show();
            }
        });

        btSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(getContext(), "Scheduling", Toast.LENGTH_SHORT).show();
                showScheduleDialog(dialog);
            }
        });

        btComplain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Complaining", Toast.LENGTH_SHORT).show();
            }
        });

        dialog.show();
        dialog.getWindow().setAttributes(layoutParams);
    }



    private void showVisitDialog(final Dialog oldDialog) {

        final Dialog dialog = new Dialog(getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_visit_collected_item);
        dialog.setCancelable(true);

        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(dialog.getWindow().getAttributes());
        layoutParams.width =WindowManager.LayoutParams.MATCH_PARENT;
        layoutParams.height =WindowManager.LayoutParams.MATCH_PARENT;

        Button btSubmit = dialog.findViewById(R.id.bt_submit);
        Button btCancel = dialog.findViewById(R.id.bt_cancel);

        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Submitting", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                oldDialog.dismiss();
            }
        });

        btCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();
        dialog.getWindow().setAttributes(layoutParams);
    }


    private void showCollectionDialog(Dialog oldDialog) {



    }



    private DatePickerDialog.OnDateSetListener myDateListener = new
            DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker arg0,
                                      int year, int month, int day) {
                    // TODO Auto-generated method stub
                    // arg1 = year
                    // arg2 = month
                    // arg3 = day
//                    showDate(arg1, arg2+1, arg3);
                    Log.d("CollectedFragment", "onDateSet: "+day+"-"+month+"-"+year);
//                    StringBuilder date = new StringBuilder().append(day).append("/").append(month).append("/").append(year);

                    try {
                        Date date = new Date(day + "/" + month + "/" + year);
                        String formattedDate = new SimpleDateFormat("dd/MM/yyyy").format(date);
                        btPickDate.setText(formattedDate);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };

    private void showScheduleDialog(final Dialog oldDialog) {

        final Dialog dialog = new Dialog(getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_schedule);
        dialog.setCancelable(true);

        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(dialog.getWindow().getAttributes());
        layoutParams.width =WindowManager.LayoutParams.MATCH_PARENT;
        layoutParams.height =WindowManager.LayoutParams.MATCH_PARENT;

        btPickDate = dialog.findViewById(R.id.bt_date_pick);

        // setting current date to the calender
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        btPickDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new DatePickerDialog(getContext(), myDateListener, year, month, day).show();
            }
        });


        Button btSubmit = dialog.findViewById(R.id.bt_submit_schedule_dialog);
        Button btCancel = dialog.findViewById(R.id.bt_cancel_schedule_dialog);

        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Scheduling", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                oldDialog.dismiss();
            }
        });

        btCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });



        dialog.show();
        dialog.getWindow().setAttributes(layoutParams);
    }


}
