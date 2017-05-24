package com.pinlab.vendor.homeFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pinlab.vendor.BaseFragment;
import com.pinlab.vendor.Myapp;
import com.pinlab.vendor.R;
import com.pinlab.vendor.adapter.ResturantsListAdapter;
import com.pinlab.vendor.network.RestClient;
import com.pinlab.vendor.network.URLData;
import com.pinlab.vendor.request.VendorResturant;
import com.pinlab.vendor.responce.Banners;
import com.pinlab.vendor.responce.RestaurentList;
import com.pinlab.vendor.responce.RestuarentData;
import com.pinlab.vendor.utils.Utils;
import com.malinskiy.superrecyclerview.SuperRecyclerView;

import java.util.ArrayList;

/**
 * Created by linuxy on 4/10/17.
 */


public class HomeResturantFragment extends BaseFragment {
    private View view;
    private SuperRecyclerView recyclerView;

    public HomeResturantFragment() {
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.home_fragment, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initializeView();
        makeHotelsListApi();
    }

    private void makeHotelsListApi() {
        RestClient restClient = RestClient.getInstance();
        VendorResturant req =new  VendorResturant();
        req.api_key = Myapp.getInstance().getPrefManager("Login_Preferences").getUser().getUuid();
        restClient.post(getActivity(), req, RestuarentData.class, this, URLData.URL_HOTELS_VENDOR);
    }

    @Override
    public void onSuccess(String responce, Object data, int urlId, int position) {
        if (urlId == URLData.URL_HOTELS_VENDOR.getUrlId() && isAdded()) {
            RestuarentData restuarentData = (RestuarentData) data;
            if (restuarentData != null) {
                ArrayList<RestaurentList> rest_list = restuarentData.rest_list;
                ArrayList<Banners> banners = restuarentData.banners;
                if (!Utils.isEmpty(rest_list)) {
                    if (!Utils.isEmpty(banners)) {
                        RestaurentList restaurentList = new RestaurentList();
                        restaurentList.itemType = ResturantsListAdapter.FIRST_ITEM;
                        rest_list.add(0, restaurentList);
                    }
                    ResturantsListAdapter adapter = new ResturantsListAdapter(getActivity(), rest_list, banners);
                    recyclerView.setAdapter(adapter);
                } else {
                    recyclerView.setEmptyAdapter("No data", false, 0);
                }
            } else {
                recyclerView.setEmptyAdapter("Some thing went wrong", false, 0);
            }
        }
    }

    private void initializeView() {
        recyclerView = (SuperRecyclerView) getView().findViewById(R.id.hotelsRecycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setEmptyListener(this);
        recyclerView.setEmptyText("No results found!!");
        recyclerView.setRefreshListener(this);
        recyclerView.setRefreshingColorResources(android.R.color.holo_orange_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_orange_light);
//        recyclerView.setupMoreListener(this, 1);
    }


    @Override
    public void onRefresh() {
        makeHotelsListApi();
    }
}
