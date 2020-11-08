package com.ervinod.expandablerecyclerview;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TripAdapter extends RecyclerView.Adapter<TripAdapter.MyViewHolder> {

    private List<TripData> tripList;
    Activity activity;


    public TripAdapter(List<TripData> tripDriverPickUpLocationList, Activity activity) {
        this.tripList = tripDriverPickUpLocationList;
        this.activity = activity;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvTripId, tvTripTitle, tvTripDate, tvPickup, tvDrop, tvPickupDate, tvDropDate;
        ImageView ivIndicator;
        Button btnViewDetails;
        LinearLayout layoutTripDetails;

        public MyViewHolder(View view) {
            super(view);

            layoutTripDetails = view.findViewById(R.id.layoutTripDetails);
            tvTripId = view.findViewById(R.id.tvTripId);
            tvTripTitle = view.findViewById(R.id.tvTripTitle);
            tvTripDate = view.findViewById(R.id.tvTripDate);
            tvPickup = view.findViewById(R.id.tvPickup);
            tvPickupDate = view.findViewById(R.id.tvPickupDate);
            tvDrop = view.findViewById(R.id.tvDrop);
            tvDropDate = view.findViewById(R.id.tvDropDate);

            btnViewDetails = view.findViewById(R.id.btnViewDetails);

            ivIndicator = view.findViewById(R.id.ivIndicator);

        }
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_trip, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        if(tripList.get(position).isExpanded()){
            holder.layoutTripDetails.setVisibility(View.VISIBLE);
        }else{
            holder.layoutTripDetails.setVisibility(View.GONE);
        }

        holder.tvTripTitle.setText(tripList.get(position).getTripTitle());
        holder.tvTripDate.setText(tripList.get(position).getTripDate());
        holder.tvTripId.setText(tripList.get(position).getTripId());
        holder.tvPickup.setText(tripList.get(position).getPickup());
        holder.tvDrop.setText(tripList.get(position).getDrop());
        holder.ivIndicator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (tripList.get(position).isExpanded()) {
                    holder.ivIndicator.setBackground(activity.getResources().getDrawable(R.drawable.ic_drop_up));
                    tripList.get(position).setExpanded(false);
                    Helper.collapse(holder.layoutTripDetails);
                } else {
                    holder.ivIndicator.setBackground(activity.getResources().getDrawable(R.drawable.ic_drop_down));
                    tripList.get(position).setExpanded(true);
                    Helper.expand(holder.layoutTripDetails);
                    collapseCard(position); //to collapse expanded card
                }
                //notifyDataSetChanged();
            }
        });

        holder.btnViewDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Helper.showToast("View Details", "TOAST_SUCCESS", activity);
            }
        });

    }

    @Override
    public int getItemCount() {
        return tripList.size();
    }

    public String getFormattedDate(String mDate) {

        if(mDate==null){
            return "Not Available";
        }
        DateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        DateFormat targetFormat = new SimpleDateFormat("dd MMMM, yyyy");
        Date date = null;
        try {
            date = originalFormat.parse(mDate);
        } catch (ParseException e) {
            e.printStackTrace();
            return mDate;
        }
        return targetFormat.format(date);
    }

    public String getFormattedDateTime(String mDate) {
        if(mDate==null){
            return "Not Available";
        }
        DateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        DateFormat targetFormat = new SimpleDateFormat("dd MMMM, yyyy | hh:mm a");
        Date date = null;
        try {
            date = originalFormat.parse(mDate);
        } catch (ParseException e) {
            e.printStackTrace();
            return mDate;
        }
        return targetFormat.format(date);
    }


    public void collapseCard(int expandPosition){
        for(int i=0; i<tripList.size(); i++){
            if(i!=expandPosition && tripList.get(i).isExpanded()){
                tripList.get(i).setExpanded(false);
                notifyItemChanged(i);
            }
        }

    }

}

