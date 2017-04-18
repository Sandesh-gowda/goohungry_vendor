package com.goohungrry.ecode;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;

import com.goohungrry.ecode.helper.Utils;
import com.goohungrry.ecode.network.ResponseHandler;

/**
 * Created by linuxy on 4/10/17.
 */

public  class BaseActivity extends AppCompatActivity implements ResponseHandler{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }




    public boolean isNetworkAvailable(Context context) {
        return Utils.isNetworkAvailable(context);
    }

    @Override
    public void onSuccess(String responce, int urlId, int position) {

    }

    @Override
    public void onFailure(Exception e, int urlId) {

    }
}
