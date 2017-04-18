package com.goohungrry.ecode;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.multidex.MultiDexApplication;

import com.google.android.gms.common.api.GoogleApiClient;


public class MyApplication extends MultiDexApplication {

    private static Context mApplicationContext;
    public static GoogleApiClient mGoogleApiClient;
    public static Handler sHandler = new Handler(Looper.getMainLooper());

    @Override
    public void onCreate() {
        super.onCreate();
        mApplicationContext = getApplicationContext();
    }


    public static Context getContext() {
        return mApplicationContext;
    }

}
