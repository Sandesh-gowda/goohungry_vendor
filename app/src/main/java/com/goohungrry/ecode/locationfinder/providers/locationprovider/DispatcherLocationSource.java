package com.goohungrry.ecode.locationfinder.providers.locationprovider;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.support.annotation.Nullable;

import com.google.android.gms.common.GoogleApiAvailability;
import com.goohungrry.ecode.locationfinder.helper.continuoustask.ContinuousTask;

class DispatcherLocationSource {

    static final String GOOGLE_PLAY_SERVICE_SWITCH_TASK = "googlePlayServiceSwitchTask";

    private ContinuousTask gpServicesSwitchTask;

    DefaultLocationProvider createDefaultLocationProvider() {
        return new DefaultLocationProvider();
    }

    GooglePlayServicesLocationProvider createGooglePlayServicesLocationProvider() {
        return new GooglePlayServicesLocationProvider();
    }

    void createSwitchTask(ContinuousTask.ContinuousTaskRunner continuousTaskRunner) {
        this.gpServicesSwitchTask = new ContinuousTask(GOOGLE_PLAY_SERVICE_SWITCH_TASK, continuousTaskRunner);
    }

    ContinuousTask gpServicesSwitchTask() {
        return gpServicesSwitchTask;
    }

    int isGoogleApiAvailable(Context context) {
        if (context == null) return -1;
        return GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context);
    }

    boolean isGoogleApiErrorUserResolvable(int gpServicesAvailability) {
        return GoogleApiAvailability.getInstance().isUserResolvableError(gpServicesAvailability);
    }

    @Nullable Dialog getGoogleApiErrorDialog(Activity activity, int gpServicesAvailability, int requestCode,
          OnCancelListener onCancelListener) {
        if (activity == null) return null;
        return GoogleApiAvailability.getInstance()
              .getErrorDialog(activity, gpServicesAvailability, requestCode, onCancelListener);
    }

}
