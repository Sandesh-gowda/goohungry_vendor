package com.pinlab.vendor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.pinlab.vendor.homeFragment.HomeResturantFragment;
import com.pinlab.vendor.homeFragment.OrderFragment;
import com.pinlab.vendor.homeFragment.UserProfileFragment;

/**
 * Created by linuxy on 4/10/17.
 */

public class HomeActivity extends BaseActivity implements View.OnClickListener {
    private  final String TAG = HomeActivity.class.getSimpleName() ;
//    private TextView txt_title;
//    private ImageView img_right;
private TextView txt_title;
    private ImageView img_back;
    private ImageView img_right;
    private ImageView[] imagebuttons ;
    private TextView[] textviews;
    private int index;
    private int currentTabIndex;
    private Fragment[] fragments;
//    private Context context;
    private HomeResturantFragment homeResturantFragment;
    private OrderFragment orderFragment;
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
        orderFragment = new OrderFragment();
        userProfileFragment = new UserProfileFragment();

        fragments = new Fragment[] {
                homeResturantFragment, orderFragment,userProfileFragment};


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
                .add(R.id.fragment_container, orderFragment)
                .add(R.id.fragment_container, userProfileFragment)

                .hide(orderFragment).hide(userProfileFragment)
                .show(homeResturantFragment).commit();

    }



    public void onTabClicked(View view) {

        switch (view.getId()) {
            case R.id.re_resturant:

                // Toast.makeText(getApplicationContext(), "ONe", Toast.LENGTH_LONG).show();
                index = 0;
//                txt_title.setText(R.string.app_name);

                txt_title.setText("Home");
                img_right.setImageResource(R.drawable.logout);
                img_right.setVisibility(View.VISIBLE);
                img_back.setVisibility(View.VISIBLE);

                break;
            case R.id.re_search:
                index = 1;
                txt_title.setText("Orders");
                img_right.setVisibility(View.INVISIBLE);
                img_back.setVisibility(View.INVISIBLE);


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


    private void findViewById() {
        txt_title = (TextView) findViewById(R.id.txt_title);
        img_right = (ImageView) findViewById(R.id.img_right);
        img_back = (ImageView) findViewById(R.id.img_back);
    }

    private void initViews() {

        img_right.setVisibility(View.VISIBLE);
        img_right.setImageResource(R.drawable.logout);
    }

    private void setOnListener() {
        img_right.setOnClickListener(this);
        img_back.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {

        switch(view.getId()){
            case R.id.img_right:
                if(index == 0){
                    Myapp.getInstance().getPrefManager(MysharedPreference.Login_Preferences).logoutUser();
                    Intent i = new Intent(HomeActivity.this, LoginActivity.class);
                    startActivity(i);
                    finish();
                }

            case R.id.img_back:

                if(index == 0){

                }



        }

    }


    /**
     * Created by linuxy on 1/16/17.
     */


}
