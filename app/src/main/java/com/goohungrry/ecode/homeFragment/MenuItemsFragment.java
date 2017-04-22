package com.goohungrry.ecode.homeFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.reflect.TypeToken;
import com.goohungrry.ecode.BaseFragment;
import com.goohungrry.ecode.R;
import com.goohungrry.ecode.adapter.MenuListAdapter;
import com.goohungrry.ecode.network.RestClient;
import com.goohungrry.ecode.network.URLData;
import com.goohungrry.ecode.request.HotelDetailsReq;
import com.goohungrry.ecode.responce.MenuCategory;
import com.goohungrry.ecode.responce.MenuItem;
import com.goohungrry.ecode.utils.Utils;
import com.malinskiy.superrecyclerview.SuperRecyclerView;

import java.lang.reflect.Type;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MenuItemsFragment extends BaseFragment {
    private static final String ARG_PARAM1 = "param1";
    @BindView(R.id.menuRecycleView)
    SuperRecyclerView menuRecycleView;
    Unbinder unbinder;
    private MenuCategory menuCategory;


    public MenuItemsFragment() {
        // Required empty public constructor
    }

    public static MenuItemsFragment newInstance(MenuCategory param1) {
        MenuItemsFragment fragment = new MenuItemsFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            menuCategory = getArguments().getParcelable(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu_itemsk, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initializeView();
        makeItemsListApi();
    }

    private void initializeView() {
        menuRecycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        menuRecycleView.setEmptyListener(this);
        menuRecycleView.setEmptyText("No results found!!");
//        recyclerView.setupMoreListener(this, 1);
    }

    private void makeItemsListApi() {
        try {
            if (Utils.isOnline(getContext())) {
                HotelDetailsReq req = new HotelDetailsReq();
                req.categoryId = menuCategory.catgoryId;
                Type type = new TypeToken<ArrayList<MenuItem>>() {
                }.getType();
                RestClient.getInstance().post(getActivity(), req, type, this, URLData.URL_HOTELS_MENU_LIST_DETAILS);
            } else {
                menuRecycleView.setEmptyAdapter("Sorry!!No internet connection", false, 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onSuccess(String responce, Object data, int urlId, int position) {
        super.onSuccess(responce, data, urlId, position);
        if (data != null && isAdded()) {
            if (urlId == URLData.URL_HOTELS_MENU_LIST_DETAILS.getUrlId()) {
                ArrayList<MenuItem> menuItems = (ArrayList<MenuItem>) data;
                MenuListAdapter adapter = new MenuListAdapter(menuItems, getActivity());
                menuRecycleView.setAdapter(adapter);
            }
        }

    }
}
