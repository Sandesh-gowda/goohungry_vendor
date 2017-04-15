package com.goohungrry.ecode;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;

import com.goohungrry.ecode.helper.Utils;

/**
 * Created by linuxy on 4/10/17.
 */

public abstract class BasicActivity extends AppCompatActivity {
    protected Activity context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;

        initControl();
        initView();
        initData();
        setListener();
    }


    @Override
    protected void onResume() {
        super.onResume();
    }

    public void onPause() {
        super.onPause();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Utils.finish(this);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


    protected abstract void initControl();

    protected abstract void initView();
    protected abstract void initData();
    protected abstract void setListener();

    public void finish(Activity activity) {
        Utils.finish(activity);
    }

    public boolean isNetworkAvailable(Context context) {
        return Utils.isNetworkAvailable(context);
    }
}
