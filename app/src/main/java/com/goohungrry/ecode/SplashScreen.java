package com.goohungrry.ecode;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;

import com.goohungrry.ecode.helper.Utils;
import com.goohungrry.ecode.locationfinder.LocationBaseActivity;
import com.goohungrry.ecode.locationfinder.configuration.Configurations;
import com.goohungrry.ecode.locationfinder.configuration.LocationConfiguration;
import com.goohungrry.ecode.locationfinder.constant.FailType;
import com.goohungrry.ecode.locationfinder.constant.ProcessType;

/**
 * Created by linuxy on 4/9/17.
 */

public class SplashScreen extends LocationBaseActivity {

    @Override
    public LocationConfiguration getLocationConfiguration() {
        return Configurations.defaultConfiguration("Missing permission!", "Would you mind to turn GPS on?");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashsreen);
        getSupportActionBar().hide();



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                getLocation();

                }



        }, 5000);



    }

    @Override
    public void onLocationChanged(Location location) {
setText(location);
    }

    private void setText(Location location) {
        String appendValue = location.getLatitude() + ", " + location.getLongitude() + "\n";
        String newValue;
        CharSequence current = null ;

        if (!TextUtils.isEmpty(current)) {
            newValue = current + appendValue;
        } else {
            newValue = appendValue;
        }

        double lat = location.getLatitude();
        double lon = location.getLongitude();


//        this code will get the over all address


        //
      // setlatlog(lat,lon);


        Log.v("Lat Long",newValue);
        if (!TextUtils.isEmpty(newValue)) {

            Intent i = new Intent(SplashScreen.this,Dashboard.class);
            startActivity(i);
        }



        // sending the value to another;


    }


    public void onLocationFailed(@FailType int failType) {


        switch (failType) {
            case FailType.TIMEOUT: {

                Utils.showLongToast(getApplicationContext(),"Couldn't get location, and timeout!");
                break;
            }
            case FailType.PERMISSION_DENIED: {

                Utils.showLongToast(getApplicationContext(),"Couldn't get location, because user didn't give permission!");
                Intent i = new Intent(SplashScreen.this,TurnOnLocationActivity.class);
                startActivity(i);
                break;
            }
            case FailType.NETWORK_NOT_AVAILABLE: {

                Utils.showLongToast(getApplicationContext(),"Couldn't get location, because network is not accessible!");

                break;
            }
            case FailType.GOOGLE_PLAY_SERVICES_NOT_AVAILABLE: {

                Utils.showLongToast(getApplicationContext(),"Couldn't get location, because Google Play Services not available!");

                break;
            }
            case FailType.GOOGLE_PLAY_SERVICES_CONNECTION_FAIL: {

                Utils.showLongToast(getApplicationContext(),"Couldn't get location, because Google Play Services connection failed!");
                break;
            }
            case FailType.GOOGLE_PLAY_SERVICES_SETTINGS_DIALOG: {

                Utils.showLongToast(getApplicationContext(),"Couldn't display settingsApi dialog!");
                break;
            }
            case FailType.GOOGLE_PLAY_SERVICES_SETTINGS_DENIED: {
                Utils.showLongToast(getApplicationContext(),"Couldn't get location, because user didn't activate providers via settingsApi!");
                break;
            }
            case FailType.VIEW_DETACHED: {

                Utils.showLongToast(getApplicationContext(),"Couldn't get location, because in the process view was detached!");
                break;
            }
            case FailType.VIEW_NOT_REQUIRED_TYPE: {

               Utils.showLongToast(getApplicationContext(),"Couldn't get location,because view wasn't sufficient enough to fulfill given configuration!");
                break;
            }
            case FailType.UNKNOWN: {
                Utils.showLongToast(getApplicationContext(),"Opps Unknown Error");
                break;
            }
        }
    }

    public void onProcessTypeChanged(@ProcessType int newProcess) {
        switch (newProcess) {
            case ProcessType.GETTING_LOCATION_FROM_GOOGLE_PLAY_SERVICES: {

                Utils.showLongToast(getApplicationContext(),"Getting Location from Google Play Services...");
                break;
            }
            case ProcessType.GETTING_LOCATION_FROM_GPS_PROVIDER: {
                Utils.showLongToast(getApplicationContext(),"Getting Location from GPS...");


                break;
            }
            case ProcessType.GETTING_LOCATION_FROM_NETWORK_PROVIDER: {

                Utils.showLongToast(getApplicationContext(),"Getting Location from Network...");
                break;
            }
            case ProcessType.ASKING_PERMISSIONS:
            case ProcessType.GETTING_LOCATION_FROM_CUSTOM_PROVIDER:
                // Ignored
                break;
        }
    }
}
