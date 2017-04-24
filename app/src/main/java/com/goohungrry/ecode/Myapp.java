package com.goohungrry.ecode;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.google.android.gms.common.api.GoogleApiClient;
import com.goohungrry.ecode.utils.Prefs;

/**
 * Created by Kalyan on 4/19/2017.
 */

public class Myapp extends Application {
    private RequestQueue mRequestQueue;
    private static Myapp mInstance;


    private static Context mApplicationContext;
    public static GoogleApiClient mGoogleApiClient;
    public static Handler sHandler = new Handler(Looper.getMainLooper());

    @Override
    public void onCreate() {
        super.onCreate();
        mApplicationContext = getApplicationContext();
        Fresco.initialize(this);
        Prefs.initPrefs(getApplicationContext());
        mInstance = this;
    }


    public static Context getContext() {
        return mApplicationContext;
    }


    public static final String TAG = Myapp.class
            .getSimpleName();


    public static synchronized Myapp getInstance() {
        return mInstance;
    }


    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        }

        return mRequestQueue;
    }


    public <T> void addToRequestQueue(Request<T> req, String tag) {
        // set the default tag if tag is empty
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getRequestQueue().add(req);
    }

    public <T> void addToRequestQueue(Request<T> req) {
        req.setTag(TAG);
        getRequestQueue().add(req);
    }

    public void cancelPendingRequests(Object tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }
}
