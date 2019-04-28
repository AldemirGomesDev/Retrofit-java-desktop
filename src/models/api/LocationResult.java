package models.api;

import com.google.gson.annotations.SerializedName;

import models.Location;

public class LocationResult extends APIResult {
    @SerializedName("localizacao")
    private Location location;

    public Location getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "LocationResult{" +
                "location=" + location +
                '}';
    }
}