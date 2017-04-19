package com.goohungrry.ecode.homeFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.goohungrry.ecode.BaseFragment;
import com.goohungrry.ecode.HomeActivity;
import com.goohungrry.ecode.Myapp;
import com.goohungrry.ecode.R;
import com.goohungrry.ecode.adapter.ResturantListAdapter;
import com.goohungrry.ecode.helper.VolleyMultipartRequest;
import com.goohungrry.ecode.model.resturantList.RestList;
import com.goohungrry.ecode.network.RestClient;
import com.goohungrry.ecode.network.URLData;
import com.malinskiy.superrecyclerview.SuperRecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by linuxy on 4/10/17.
 */


public class HomeResturantFragment extends BaseFragment {
    private View view;
    private SuperRecyclerView recyclerView;
    private ResturantListAdapter adapter;

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
        //  intiTask();
        updatePhonNetwork();
        makeHotelsListApi();
    }

    private void makeHotelsListApi() {
        RestClient restClient = RestClient.getInstance();
        restClient.post(getActivity(),null,null,this, URLData.URL_HOTELS_LIST);
    }

    @Override
    public void onSuccess(String responce, Object data, int urlId, int position) {
        if (urlId==URLData.URL_HOTELS_LIST.getUrlId()){

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
        recyclerView.setupMoreListener(this, 1);
    }




    public void updatePhonNetwork() {

        String url = "https://goohungrry.com/stack/v1/list";
        VolleyMultipartRequest multipartRequest = new VolleyMultipartRequest(Request.Method.POST, url, new Response.Listener<NetworkResponse>() {
            @Override
            public void onResponse(NetworkResponse response) {
                String resultResponse = new String(response.data);

                try {
                    JSONObject json = new JSONObject(resultResponse);
                    JSONArray arrJson = json.getJSONArray("rest_list");
                    setData(String.valueOf(arrJson));

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {


                NetworkResponse networkResponse = error.networkResponse;
                String errorMessg = "Unknown error";
                if (networkResponse == null) {
                    if (error.getClass().equals(TimeoutError.class)) {
                        errorMessg = "RequestTimeOut";
                    }
                } else {
                    String result = new String(networkResponse.data);
                    try {
                        JSONObject response = new JSONObject(result);

                    } catch (JSONException e) {
                        e.printStackTrace();

                    }
                }
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();

                //  params.put("latitude",lat);
                //  params.put("longitude",logn);


                return params;

            }


        };
        Myapp.getInstance().addToRequestQueue(multipartRequest);


    }

    protected void setData(String response) {
        try {
            if (isAdded()) {
                Type listOfTestObject = new TypeToken<List<RestList>>() {
                }.getType();
                Gson gson = new Gson();
                ArrayList<RestList> Menulist = gson.fromJson(response, listOfTestObject);
                if (Menulist == null || Menulist.size() == 0) {
                    //TODO : nothing to show here.
                } else {
                    adapter = new ResturantListAdapter(Menulist, getActivity());
                    recyclerView.setAdapter(adapter);
                }
            }

        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
    }
}
