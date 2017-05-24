package com.pinlab.vendor.homeFragment;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.reflect.TypeToken;
import com.pinlab.vendor.BaseActivity;
import com.pinlab.vendor.R;
import com.pinlab.vendor.network.RestClient;
import com.pinlab.vendor.network.URLData;
import com.pinlab.vendor.request.HotelDetailsReq;
import com.pinlab.vendor.responce.HotelMenuDetails;
import com.pinlab.vendor.responce.MenuCategory;
import com.pinlab.vendor.shared.FragmentAdapter;
import com.pinlab.vendor.ui.SampleProgressView;
import com.pinlab.vendor.utils.ConstantUtils;
import com.pinlab.vendor.utils.ImageLoader;
import com.pinlab.vendor.utils.Utils;

import java.lang.reflect.Type;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HotelMenuActivity extends BaseActivity {

    @BindView(R.id.collapsing_image)
    ImageView collapsingImage;
    //    @BindView(R.id.cordinator_layout)
//    RelativeLayout cordinatorLayout;
    @BindView(R.id.toolbarCollapse)
    Toolbar toolbarCollapse;
    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;
    @BindView(R.id.app_bar_layout)
    AppBarLayout appBarLayout;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.relativeLayout)
    LinearLayout relativeLayout;
    //    @BindView(R.id.cordinator_layout)
//    CoordinatorLayout cordinatorLayout;
    @BindView(R.id.progressview)
    SampleProgressView mProgressview;
    @BindView(R.id.alertText)
    TextView mAlertText;
    @BindView(R.id.progressLyt)
    RelativeLayout mProgressLyt;
    @BindView(R.id.cartFab)
    FloatingActionButton cartFab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_menu);
        ButterKnife.bind(this);
        String hotelId = getIntent().getStringExtra(ConstantUtils.DATA);
        makeDetailsApi(hotelId);
    }

    private void makeDetailsApi(String hotelId) {
        try {
            if (isNetworkAvailable()) {
                handleProgress(getString(R.string.progress));
                HotelDetailsReq req = new HotelDetailsReq();
                req.hotelId = hotelId;
                Type type = new TypeToken<ArrayList<HotelMenuDetails>>() {
                }.getType();
                RestClient.getInstance().post(this, req, type, this, URLData.URL_HOTELS_MENU_DETAILS);
            } else {
                handleProgress("No Internet");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void handleProgress(String text) {
        if (TextUtils.isEmpty(text)) {
            mProgressLyt.setVisibility(View.GONE);
//            contentView.setVisibility(View.VISIBLE);
        } else if (getString(R.string.progress).equalsIgnoreCase(text)) {
            mProgressLyt.setVisibility(View.VISIBLE);
            mProgressview.setVisibility(View.VISIBLE);
//            contentView.setVisibility(View.INVISIBLE);
            mAlertText.setVisibility(View.GONE);
        } else {
//            contentView.setVisibility(View.INVISIBLE);
            mProgressLyt.setVisibility(View.VISIBLE);
            mProgressview.setVisibility(View.GONE);
            mAlertText.setVisibility(View.VISIBLE);
            mAlertText.setText(text);
        }
    }


    @Override
    public void onSuccess(String responce, Object data, int urlId, int position) {
        super.onSuccess(responce, data, urlId, position);
        if (data != null) {
            if (urlId == URLData.URL_HOTELS_MENU_DETAILS.getUrlId()) {
                ArrayList<HotelMenuDetails> details = (ArrayList<HotelMenuDetails>) data;
                setData(details.get(0));
            }

        }
    }

    private void setData(HotelMenuDetails details) {
        handleProgress(null);
        ArrayList<MenuCategory> categoryArrayList = details.catogory;
        setUpToolbar(details.name, false);
        ImageLoader.loadImage(details.image, collapsingImage, R.drawable.placeholder);
        if (!Utils.isEmpty(categoryArrayList)) {
            ArrayList<String> headersList = new ArrayList<>();
            ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
            for (MenuCategory menuCategory : categoryArrayList) {
                headersList.add(menuCategory.catagoryName);
                fragmentArrayList.add(MenuItemsFragment.newInstance(menuCategory));
            }
            FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager(), fragmentArrayList, headersList);
            viewpager.setAdapter(adapter);
            tabLayout.setupWithViewPager(viewpager);
        }
    }

    public void setUpToolbar(String title, boolean enableBack) {
        try {
            setSupportActionBar(toolbarCollapse);
            ActionBar actionBar = getSupportActionBar();
            actionBar.setTitle(null);
            toolbarCollapse.setTitle(title);
            actionBar.setDisplayHomeAsUpEnabled(enableBack);
        } catch (Exception e) {
            Utils.logCrash(e);
        }
    }
}
