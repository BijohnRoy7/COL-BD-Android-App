package com.example.colbdapplication.fragments;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
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
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.colbdapplication.R;
import com.example.colbdapplication.adapters.DueAdapter;
import com.example.colbdapplication.adapters.HomeAdapter;
import com.example.colbdapplication.models.DueItems;
import com.example.colbdapplication.models.HomeItems;
import com.jaredrummler.materialspinner.MaterialSpinner;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class DueFragment extends Fragment {

    private RecyclerView recyclerViewHome;
    private DueAdapter adapter;
    private List<DueItems> dueItems;

    private DatePicker datePicker;
    private Calendar calendar;
    private int year, month, day;
    private Button btPickDate;

    public DueFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_due, container, false);

        initComponents(view);
        populateRecyclerView();

        return  view;

    }

    private void initComponents(View view) {

        //recyclerView
        recyclerViewHome = view.findViewById(R.id.RecyclerView_due_fragment);
        recyclerViewHome.setLayoutManager(new LinearLayoutManager(getContext()));
    }


    private void populateRecyclerView() {

        dueItems = new ArrayList<>();
        dueItems.add(new DueItems());
        dueItems.add(new DueItems());
        dueItems.add(new DueItems());
        dueItems.add(new DueItems());
        dueItems.add(new DueItems());
        dueItems.add(new DueItems());
        dueItems.add(new DueItems());
        dueItems.add(new DueItems());
        dueItems.add(new DueItems());
        dueItems.add(new DueItems());
        dueItems.add(new DueItems());


        adapter = new DueAdapter(getContext(), dueItems);
        recyclerViewHome.setAdapter(adapter);

        // calling OnItemClickListener methods
        // from DueAdapterOnItemClickListener interface of DueAdapter
        adapter.setDueItemClickListener(new DueAdapter.DueAdapterOnItemClickListener() {
            @Override
            public void onDueItemClickForDetails(View view, int position) {
                showDialog();
            }

            @Override
            public void onDueItemClickForCall(View view, int position) {
                Toast.makeText(getContext(), "Calling", Toast.LENGTH_SHORT).show();
            }
        });
    }



    // method for showing dialog
    private void showDialog() {

        final Dialog dialog = new Dialog(getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_customer_list);
        dialog.setCancelable(true);

        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(dialog.getWindow().getAttributes());
        layoutParams.width =WindowManager.LayoutParams.MATCH_PARENT;
        layoutParams.height =WindowManager.LayoutParams.MATCH_PARENT;

        Button btBillSubmit = dialog.findViewById(R.id.bt_bill_submit_dialog);
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

        btBillSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getContext(), "Bill Submitting", Toast.LENGTH_SHORT).show();
                showSubmitBillDialog(dialog);
            }
        });

        btCollection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Showing Collection", Toast.LENGTH_SHORT).show();
            }
        });

        btReports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(getContext(), "Reporting", Toast.LENGTH_SHORT).show();

                showReportDialog(dialog);
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
                //Toast.makeText(getContext(), "Complaining", Toast.LENGTH_SHORT).show();
                showComplainDialog();
            }
        });

        dialog.show();
        dialog.getWindow().setAttributes(layoutParams);
    }


    // Submit Bill Dialog
    private void showSubmitBillDialog(final Dialog oldDialog) {

        final Dialog dialog = new Dialog(getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_bill_submit);
        dialog.setCancelable(true);

        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(dialog.getWindow().getAttributes());
        layoutParams.width =WindowManager.LayoutParams.MATCH_PARENT;
        layoutParams.height =WindowManager.LayoutParams.MATCH_PARENT;

        Button btDone = dialog.findViewById(R.id.bt_bill_submit_done);
        Button btCollection = dialog.findViewById(R.id.bt_bill_submit_collection);

        btCollection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Collection", Toast.LENGTH_SHORT).show();

                showCollectionDialog(oldDialog, dialog);
                //dialog.dismiss();
//                oldDialog.dismiss();
            }
        });

        btDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Done", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                oldDialog.dismiss();
            }
        });

        ((ImageButton) dialog.findViewById(R.id.bt_close_submit_done)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
        dialog.getWindow().setAttributes(layoutParams);
    }


    // Showing Collection Dialog
    private void showCollectionDialog(final Dialog oldDialog, final Dialog newDialog) {

        final Dialog dialog = new Dialog(getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_collection);
        dialog.setCancelable(true);

        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(dialog.getWindow().getAttributes());
        layoutParams.width =WindowManager.LayoutParams.MATCH_PARENT;
        layoutParams.height =WindowManager.LayoutParams.MATCH_PARENT;

        final LinearLayout collectionLayout = dialog.findViewById(R.id.collection_layout);
        Button btCancel = dialog.findViewById(R.id.bt_cancel_collection);
        Button btReceivedCollection = dialog.findViewById(R.id.bt_received_collection);

        // this layout will be shown
        // when received button is clicked
        final LinearLayout receivedLayout = dialog.findViewById(R.id.received_layout);
        Button btSaveReceived = dialog.findViewById(R.id.bt_save_received);
        Button btCancelReceived = dialog.findViewById(R.id.bt_cancel_received);

        btReceivedCollection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Received", Toast.LENGTH_SHORT).show();
                collectionLayout.setVisibility(View.GONE);
                receivedLayout.setVisibility(View.VISIBLE);
                /*dialog.dismiss();
                newDialog.dismiss();
                oldDialog.dismiss();*/
            }
        });

        btCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Cancelled", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                newDialog.dismiss();
                oldDialog.dismiss();
            }
        });


        btSaveReceived.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Saved", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                newDialog.dismiss();
                oldDialog.dismiss();
            }
        });

        btCancelReceived.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Cancelled", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        ((ImageButton) dialog.findViewById(R.id.bt_close_collection)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
        dialog.getWindow().setAttributes(layoutParams);
    }




    private void showReportDialog(Dialog oldDialog) {

        final Dialog dialog = new Dialog(getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_schedule);
        dialog.setCancelable(true);

        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(dialog.getWindow().getAttributes());
        layoutParams.width =WindowManager.LayoutParams.MATCH_PARENT;
        layoutParams.height =WindowManager.LayoutParams.MATCH_PARENT;


        dialog.show();
        dialog.getWindow().setAttributes(layoutParams);
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




    // Schedule Dialog
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



    //Complain Dialog
    private void showComplainDialog() {

        final Dialog dialog = new Dialog(getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_complain);
        dialog.setCancelable(true);

        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(dialog.getWindow().getAttributes());
        layoutParams.width =WindowManager.LayoutParams.MATCH_PARENT;
        layoutParams.height =WindowManager.LayoutParams.MATCH_PARENT;

        MaterialSpinner typeSpinner = dialog.findViewById(R.id.type_spinner);
        typeSpinner.setItems("Connection Problem", "Slow", "No Internet", "Not Specific");

        MaterialSpinner prioritySpinner = dialog.findViewById(R.id.priority_spinner);
        prioritySpinner.setItems("Low", "Medium", "High", "Urgent");

        Button btSubmit = dialog.findViewById(R.id.bt_service_request);
        Button btCancel = dialog.findViewById(R.id.bt_cancel_complain);

        prioritySpinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, Object item) {
                Toast.makeText(getContext(), ""+item, Toast.LENGTH_SHORT).show();
            }
        });

        typeSpinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, Object item) {
                Toast.makeText(getContext(), ""+item, Toast.LENGTH_SHORT).show();
            }
        });

        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
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
