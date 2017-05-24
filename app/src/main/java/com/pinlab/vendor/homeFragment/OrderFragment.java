package com.pinlab.vendor.homeFragment;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
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
import com.malinskiy.superrecyclerview.SuperRecyclerView;
import com.pinlab.vendor.BaseFragment;
import com.pinlab.vendor.Myapp;
import com.pinlab.vendor.R;
import com.pinlab.vendor.adapter.OrderResturantAdapter;
import com.pinlab.vendor.helper.VolleyMultipartRequest;
import com.pinlab.vendor.model.OrderData;
import com.pinlab.vendor.model.OrderNewList;
import com.pinlab.vendor.model.over.OrderList;
import com.pinlab.vendor.model.over.Orderlist;
import com.pinlab.vendor.network.RestClient;
import com.pinlab.vendor.network.URLData;
import com.pinlab.vendor.request.VendorResturant;
import com.pinlab.vendor.responce.RestuarentData;
import com.pinlab.vendor.utils.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by linuxy on 4/10/17.
 */

public class OrderFragment extends BaseFragment {
    private SuperRecyclerView recyclerView;
    protected Gson gson = new Gson();
    protected ArrayList<Orderlist> orderlists;

    public OrderFragment() {
    }


    private View view;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.order_fragment, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initializeView();


        //makeNewOrderApi();
        updateOrders("hi");
    }


    private void makeNewOrderApi() {
        RestClient restClient = RestClient.getInstance();
        VendorResturant req =new  VendorResturant();
        req.rapikey =  "VAS60550" ;//Myapp.getInstance().getPrefManager("Login_Preferences").getUser().getUuid();
        restClient.post(getActivity(), req, OrderData.class, this, URLData.URL_HOTELS_LIST);
    }




    private void initializeView() {
        recyclerView = (SuperRecyclerView) getView().findViewById(R.id.hotelOrderRecycleView);
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
    public void onSuccess(String responce, Object data, int urlId, int position) {
        if (urlId == URLData.URL_HOTELS_LIST.getUrlId() && isAdded()) {
            OrderData restuarentData = (OrderData) data;
            if (restuarentData != null) {
                ArrayList<OrderNewList> rest_list = restuarentData.orderlist;

                if (!Utils.isEmpty(rest_list)) {

                        OrderNewList restaurentList = new OrderNewList();

                        rest_list.add(restaurentList);


                } else {
                    recyclerView.setEmptyAdapter("No data", false, 0);
                }
            } else {
                recyclerView.setEmptyAdapter("Some thing went wrong", false, 0);
            }
        }
    }


    protected void setData(String response) {
        try {
            if (isAdded()) {
                OrderList menuList = gson.fromJson(response, OrderList.class);
                orderlists = menuList.getOrderlist();
                if (orderlists == null || orderlists.size() == 0) {


                    // no stock

                } else {

                    ArrayList<Orderlist> o = orderlists;
                    final  Orderlist model =  o.get(0);




                    OrderResturantAdapter adapter = new OrderResturantAdapter(getActivity(), orderlists);
                    recyclerView.setAdapter(adapter);


                }
            }
        } catch (JsonSyntaxException e) {
            e.printStackTrace();

        }
    }


//    ------------ broing actibvity


    public void updateOrders(final String hi) {
        String url = "https://goohungrry.com/stack/v1/adminorders";//Put update car API Over here
        VolleyMultipartRequest multipartRequest = new VolleyMultipartRequest(Request.Method.POST, url, new Response.Listener<NetworkResponse>() {
            @Override
            public void onResponse(NetworkResponse response) {
                String resultResponse = new String(response.data);


                Log.v("resp",resultResponse);
                setData(resultResponse);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                NetworkResponse networkResponse = error.networkResponse;
                String errorMessage = "Unknown error";
                if (networkResponse == null) {
                    if (error.getClass().equals(TimeoutError.class)) {
                        errorMessage = "Request timeout";

                    }
                } else {
                    String result = new String(networkResponse.data);


//                    try {
//                        JSONObject response = new JSONObject(result);
//                        String status = response.getString("status");
//                        String message = response.getString("message");
// swipeRefreshLayout.setRefreshing(false);
//
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
                }
                Log.i("Error", errorMessage);
                error.printStackTrace();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();

                /*sumeeth code for addding car*/




                /* for check box */

                params.put("rapikey", Myapp.getInstance().getPrefManager("Login_Preferences").getUser().getUuid());


                return params;
            }

            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            protected Map<String, DataPart> getByteData() {


                Map<String, DataPart> params = new HashMap<>();



                return params;
            }
        };


        Myapp.getInstance().addToRequestQueue(multipartRequest);
    }
}
