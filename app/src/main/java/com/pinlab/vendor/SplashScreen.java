package com.pinlab.vendor;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;


/**
 * Created by linuxy on 4/9/17.
 */

public class SplashScreen extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashsreen);



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


                //  final Intent mainIntent = new Intent(SplashScreen.this, Gpssetting.class);
                //   final Intent mainIntent = new Intent(SplashScreen.this, Registration.class);
                if (Myapp.getInstance().getPrefManager("Login_Preferences").getUser() != null) {
                    final Intent mainIntent = new Intent(SplashScreen.this, HomeActivity.class);
                    SplashScreen.this.startActivity(mainIntent);
                    SplashScreen.this.finish();
                }else{

                    final Intent mainIntent = new Intent(SplashScreen.this, LoginActivity.class);
                    SplashScreen.this.startActivity(mainIntent);
                    SplashScreen.this.finish();
                }


            }
        }, 5000);


    }



}
