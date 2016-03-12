package com.dutsonpa.mylocation;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;

public class MyLocationService extends Service implements LocationListener {

    protected LocationManager locationManager;
    Location location;

    // create a distance value in meters to use for update frequency
    private static final long UPDATE_DISTANCE_FREQUENCY = 10;
    // create a 2 minute time value for use as update frequency
    private static final long UPDATE_MIN_FREQUENCY = 1000 * 60 * 2;

    /*
    * Note that using a value of "0" for the variables above will request
    * updates as often as the device can provide, however this will require
    * much more battery usage, avoid using "0" if possible
     */

    public MyLocationService(Context context) {
        locationManager = (LocationManager) context.getSystemService(LOCATION_SERVICE);
    }

    // create a getter for location
    public Location getLocation(String provider) {
        // Is a location provider enabled?
        if (locationManager.isProviderEnabled(provider)){
            locationManager.requestLocationUpdates(provider, UPDATE_MIN_FREQUENCY, UPDATE_DISTANCE_FREQUENCY, this);
            // Has it been 2 minutes or moved 10 meters?
            if (locationManager != null){
                // There is a provider and it is time to send a location update
                location = locationManager.getLastKnownLocation(provider);
                return location;
            }
        }
        // Location provider is not enabled, return null
        return null;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onLocationChanged(Location location) {
        // specific logic for location change
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        // specific logic for a status change
    }

    @Override
    public void onProviderEnabled(String provider) {
        // specific logic for a provider being enabled
    }

    @Override
    public void onProviderDisabled(String provider) {
        // specific logic for a provider being disabled
    }
}
