package com.ervinod.expandablerecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView tvMessage;
    private ProgressBar progressBar;
    private RecyclerView rvTrips;
    private TripAdapter tripAdapter;
    List<TripData> tripDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initAdapter();
        getTripData();
    }


    private void initViews() {
        rvTrips = findViewById(R.id.rvTrip);
        tvMessage = findViewById(R.id.tvMessage);
        progressBar = findViewById(R.id.progressBar);
    }

    private void initAdapter() {
        tripDataList = new ArrayList<>();
        tripAdapter = new TripAdapter(tripDataList, this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        rvTrips.setLayoutManager(mLayoutManager);
        rvTrips.setAdapter(tripAdapter);
    }

    public void getTripData(){

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                addDummyData();
                progressBar.setVisibility(View.GONE);
                tripAdapter.notifyDataSetChanged();
            }
        }, 1500);
    }

    public void addDummyData(){
        tripDataList.add(new TripData("TP1267", "Dhule to Nasik", "12-10-2020", "Dhule", "Nashik"));
        tripDataList.add(new TripData("TP1277", "Nashik to Agra", "14-10-2020", "Nashik", "Agra"));
        tripDataList.add(new TripData("TP1279", "Punjab to Haryana", "17-10-2020", "Punjab", "Haryana"));
        tripDataList.add(new TripData("TP1281", "Delhi to Goa", "21-10-2020", "Delhi", "Goa"));
        tripDataList.add(new TripData("TP1289", "Gurugram to Noida", "27-10-2020", "Gurugram", "Noida"));
        tripDataList.add(new TripData("TP1290", "Lucknow to Delhi", "01-11-2020", "Lucknow", "Delhi"));
        tripDataList.add(new TripData("TP1291", "Pune to Aurangabad", "02-11-2020", "Pune", "Aurangabad"));
        tripDataList.add(new TripData("TP1305", "Mumbai to Pune", "04-11-2020", "Mumbai", "Pune"));
        tripDataList.add(new TripData("TP1367", "Dhule to Nasik", "12-11-2020", "Dhule", "Nashik"));
        tripDataList.add(new TripData("TP1377", "Nashik to Agra", "14-11-2020", "Nashik", "Agra"));
        tripDataList.add(new TripData("TP1379", "Punjab to Haryana", "17-11-2020", "Punjab", "Haryana"));
        tripDataList.add(new TripData("TP1381", "Delhi to Goa", "21-11-2020", "Delhi", "Goa"));
        tripDataList.add(new TripData("TP1389", "Gurugram to Noida", "27-11-2020", "Gurugram", "Noida"));
        tripDataList.add(new TripData("TP1390", "Lucknow to Delhi", "01-12-2020", "Lucknow", "Delhi"));
        tripDataList.add(new TripData("TP1391", "Pune to Aurangabad", "02-12-2020", "Pune", "Aurangabad"));
        tripDataList.add(new TripData("TP1405", "Mumbai to Pune", "04-12-2020", "Mumbai", "Pune"));

    }

}