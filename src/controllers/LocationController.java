package controllers;

import java.io.IOException;

import models.api.LocationResult;
import services.LocationService;

public class LocationController {
	
	private LocationService locationService;

    public LocationController(){
        locationService = LocationService.INSTANCE;
    }

    public LocationResult saveLocation(int user_id, String user_type, int type_function, double lat, double lng ) throws IOException {
        return locationService.saveLocation(user_id, user_type, type_function, lat, lng);
    }


}
