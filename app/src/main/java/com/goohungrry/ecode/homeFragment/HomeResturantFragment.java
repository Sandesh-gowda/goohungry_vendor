package com.goohungrry.ecode.homeFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.goohungrry.ecode.BaseFragment;
import com.goohungrry.ecode.R;
import com.goohungrry.ecode.adapter.ResturantsListAdapter;
import com.goohungrry.ecode.network.RestClient;
import com.goohungrry.ecode.network.URLData;
import com.goohungrry.ecode.responce.Banners;
import com.goohungrry.ecode.responce.RestaurentList;
import com.goohungrry.ecode.responce.RestuarentData;
import com.goohungrry.ecode.utils.Utils;
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
        restClient.post(getActivity(), null, RestuarentData.class, this, URLData.URL_HOTELS_LIST);
    }

    @Override
    public void onSuccess(String responce, Object data, int urlId, int position) {
        if (urlId == URLData.URL_HOTELS_LIST.getUrlId() && isAdded()) {
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
