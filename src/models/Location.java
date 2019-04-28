package models;

import com.google.gson.annotations.SerializedName;

public class Location {
	
	 	@SerializedName("id")
	    private int id;
	    @SerializedName("user_id")
	    private int user_id;
	    @SerializedName("lat")
	    private double lat;
	    @SerializedName("lng")
	    private double lng;

	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public int getUser_id() {
	        return user_id;
	    }

	    public void setUser_id(int user_id) {
	        this.user_id = user_id;
	    }

	    public double getLat() {
	        return lat;
	    }

	    public void setLat(double lat) {
	        this.lat = lat;
	    }

	    public double getLng() {
	        return lng;
	    }

	    public void setLng(double lng) {
	        this.lng = lng;
	    }

	    @Override
	    public String toString() {
	        return "Location{" +
	                "id=" + id +
	                ", user_id=" + user_id +
	                ", lat=" + lat +
	                ", lng=" + lng +
	                '}';
	    }

}
