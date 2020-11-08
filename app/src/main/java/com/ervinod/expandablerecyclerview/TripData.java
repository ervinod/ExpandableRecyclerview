package com.ervinod.expandablerecyclerview;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TripData {

    @SerializedName("tripTitle")
    @Expose
    private String tripTitle;

    @SerializedName("tripId")
    @Expose
    private String tripId;

    @SerializedName("tripDate")
    @Expose
    private String tripDate;

    @SerializedName("pickup")
    @Expose
    private String pickup;

    @SerializedName("pickupDate")
    @Expose
    private String pickupDate;

    @SerializedName("pickupAddress")
    @Expose
    private String pickupAddress;

    @SerializedName("drop")
    @Expose
    private String drop;

    @SerializedName("dropDate")
    @Expose
    private String dropDate;

    @SerializedName("dropAddress")
    @Expose
    private String dropAddress;

    boolean isExpanded = false;

    public TripData(String tripId, String tripTitle, String tripDate, String pickup, String drop) {
        this.tripTitle = tripTitle;
        this.tripId = tripId;
        this.tripDate = tripDate;
        this.pickup = pickup;
        this.drop = drop;
    }

    public String getTripTitle() {
        return tripTitle;
    }

    public void setTripTitle(String tripTitle) {
        this.tripTitle = tripTitle;
    }

    public String getTripId() {
        return tripId;
    }

    public void setTripId(String tripId) {
        this.tripId = tripId;
    }

    public String getTripDate() {
        return tripDate;
    }

    public void setTripDate(String tripDate) {
        this.tripDate = tripDate;
    }

    public String getPickup() {
        return pickup;
    }

    public void setPickup(String pickup) {
        this.pickup = pickup;
    }

    public String getPickupAddress() {
        return pickupAddress;
    }

    public void setPickupAddress(String pickupAddress) {
        this.pickupAddress = pickupAddress;
    }

    public String getDrop() {
        return drop;
    }

    public void setDrop(String drop) {
        this.drop = drop;
    }

    public String getDropAddress() {
        return dropAddress;
    }

    public void setDropAddress(String dropAddress) {
        this.dropAddress = dropAddress;
    }

    public boolean isExpanded() {
        return isExpanded;
    }

    public void setExpanded(boolean expanded) {
        isExpanded = expanded;
    }

}


