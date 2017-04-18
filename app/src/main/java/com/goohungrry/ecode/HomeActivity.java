package com.goohungrry.ecode;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.google.android.gms.common.api.GoogleApiClient;
import com.goohungrry.ecode.homeFragment.HomeResturantFragment;
import com.goohungrry.ecode.homeFragment.SearchResturantFragment;
import com.goohungrry.ecode.homeFragment.UserProfileFragment;

/**
 * Created by linuxy on 4/10/17.
 */

public class HomeActivity extends BaseActivity implements View.OnClickListener {
    private  final String TAG = HomeActivity.class.getSimpleName() ;
//    private TextView txt_title;
//    private ImageView img_right;
    private ImageView[] imagebuttons ;
    private TextView[] textviews;
    private int index;
    private int currentTabIndex;
    private Fragment[] fragments;
//    private Context context;
    private HomeResturantFragment homeResturantFragment;
    private SearchResturantFragment searchResturantFragment;
    private UserProfileFragment userProfileFragment;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_context);
        findViewById();
        initViews();
        setOnListener();


        intitTabview();


    }


    private void intitTabview(){
        homeResturantFragment = new HomeResturantFragment();
        searchResturantFragment = new SearchResturantFragment();
        userProfileFragment = new UserProfileFragment();

        fragments = new Fragment[] {
                homeResturantFragment, searchResturantFragment,userProfileFragment};


        imagebuttons = new ImageView[3];
        imagebuttons[0] = (ImageView) findViewById(R.id.iv_resturant);
        imagebuttons[1] = (ImageView) findViewById(R.id.ib_contact_list);
        imagebuttons[2] = (ImageView) findViewById(R.id.ib_profile);


        imagebuttons[0].setSelected(true);
        textviews = new TextView[3];
        textviews[0] = (TextView) findViewById(R.id.tv_resturant);
        textviews[1] = (TextView) findViewById(R.id.tv_contact_list);

        textviews[2] = (TextView) findViewById(R.id.tv_profile);
        textviews[0].setTextColor(0xFF45C01A);


        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, homeResturantFragment)
                .add(R.id.fragment_container, searchResturantFragment )
                .add(R.id.fragment_container, userProfileFragment)

                .hide(searchResturantFragment).hide(userProfileFragment)
                .show(homeResturantFragment).commit();

    }



    public void onTabClicked(View view) {

        switch (view.getId()) {
            case R.id.re_resturant:

                // Toast.makeText(getApplicationContext(), "ONe", Toast.LENGTH_LONG).show();
                index = 0;
//                txt_title.setText(R.string.app_name);

                break;
            case R.id.re_search:
                index = 1;


                //  Toast.makeText(getApplicationContext(), "TWo", Toast.LENGTH_LONG).show();

                break;
            case R.id.re_profile:
                index = 2;

                // Toast.makeText(getApplicationContext(), "Three", Toast.LENGTH_LONG).show();

                break;


        }


        if (currentTabIndex != index) {
            FragmentTransaction trx = getSupportFragmentManager()
                    .beginTransaction();
            trx.hide(fragments[currentTabIndex]);
            if (!fragments[index].isAdded()) {
                trx.add(R.id.fragment_container, fragments[index]);
            }
            trx.show(fragments[index]).commit();
        }
        imagebuttons[currentTabIndex].setSelected(false);

        imagebuttons[index].setSelected(true);
        textviews[currentTabIndex].setTextColor(0xFF999999);
        textviews[index].setTextColor(0xFF45C01A);
        currentTabIndex = index;

    }



    private void findViewById(){

    }


    private void initViews(){

    }


    private void setOnListener() {}


    @Override
    public void onClick(View view) {}

    /**
     * Created by linuxy on 1/16/17.
     */


}
