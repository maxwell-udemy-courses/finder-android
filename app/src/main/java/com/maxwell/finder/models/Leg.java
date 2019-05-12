package com.maxwell.finder.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Leg {
    private List<Step> steps;
    @SerializedName("start_location")
    private Location startLocation;
    @SerializedName("end_location")
    private Location endLocation;
    @SerializedName("start_address")
    private String startAddress;
    @SerializedName("end_address")
    private String endAddress;

    public List<Step> getSteps() {
        return steps;
    }

    public Location getStartLocation() {
        return startLocation;
    }

    public Location getEndLocation() {
        return endLocation;
    }

    public String getStartAddress() {
        return startAddress;
    }

    public String getEndAddress() {
        return endAddress;
    }
}
