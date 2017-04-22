package com.goohungrry.ecode;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

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




    public boolean isNetworkAvailable() {
        return Utils.isNetworkAvailable(getApplicationContext());
    }


    @Override
    public void onSuccess(String responce, Object data, int urlId, int position) {

    }

    @Override
    public void onFailure(Exception e, int urlId) {

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
