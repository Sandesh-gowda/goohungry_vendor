package com.pinlab.vendor;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.pinlab.vendor.helper.VolleyMultipartRequest;
import com.pinlab.vendor.model.OrderItems;
import com.pinlab.vendor.model.over.MenuItem;
import com.pinlab.vendor.model.over.Orderlist;
import com.pinlab.vendor.utils.ConstantUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderMenuList extends AppCompatActivity {
    public ArrayList<OrderItems> catLists;
    private Orderlist orderlist;
    private List<com.pinlab.vendor.model.over.MenuItem> menuItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_menu_list);
        orderlist = (Orderlist) getIntent().getSerializableExtra(ConstantUtils.LISTOFORDERITEMS);
        menuItems = orderlist.getMenu_items();
        int si = menuItems.size();

        Log.v("Item", String.valueOf(si));




        LinearLayout m_ll = (LinearLayout) findViewById(R.id.llMain);
        //button accepted

        Button accept = new Button(this);


        accept.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        LinearLayout.LayoutParams ll = (LinearLayout.LayoutParams) accept.getLayoutParams();
        ll.gravity = Gravity.CENTER;
        accept.setLayoutParams(ll);
        accept.setText("Accept");
        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callAccept();
            }
        });


        // declin button

        Button decline = new Button(this);
        decline.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        LinearLayout.LayoutParams lld = (LinearLayout.LayoutParams) decline.getLayoutParams();
        lld.gravity = Gravity.CENTER;
        decline.setLayoutParams(lld);
        decline.setText("Decline");
        decline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callDecline();
            }
        });
        //
        TextView address = new TextView(this);
        address.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));

        TextView deliveryType = new TextView(this);
        deliveryType.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        deliveryType.setText("Payment Type : " + orderlist.getPayment());
        deliveryType.setPadding(30, 30, 0, 80);
        deliveryType.setGravity(Gravity.CENTER);

        address.setText("Address :  " + orderlist.getAddress());
        address.setPadding(30, 30, 0, 0);
        address.setGravity(Gravity.CENTER);
        address.setTextColor(Color.BLUE);
        //  LinearLay.addView(v);
        for (int i = 0; i < si; i++) {

            View v = new View(this);
            v.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    1
            ));


            v.setBackgroundColor(Color.parseColor("#B3B3B3"));
            MenuItem m = menuItems.get(i);
            TextView text = new TextView(this);
            text.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            text.setText(m.getMenu_name() + "       " +
                    "- -  " + m.getQuantity() + "   =   " + m.getTotalcost());
            text.setTextSize(TypedValue.COMPLEX_UNIT_PX,
                    getResources().getDimension(R.dimen.result_font));
            text.setPadding(30, 30, 0, 15);
            text.setGravity(Gravity.LEFT);

            m_ll.addView(text);
            m_ll.addView(v);

        }

        m_ll.addView(address);
        m_ll.addView(deliveryType);

        if (orderlist.getAchoice().equals("")) {
            m_ll.addView(accept);
            m_ll.addView(decline);
        } else if (orderlist.getAchoice().equals("1")) {
            accept.setClickable(false);
            accept.setText("Accepted");
            decline.setVisibility(View.GONE);
            decline.setClickable(false);
            m_ll.addView(accept);

            m_ll.addView(decline);
        } else if (orderlist.getAchoice().equals("0")) {
            decline.setClickable(false);
            accept.setVisibility(View.GONE);
            decline.setText("Declined");
            m_ll.addView(accept);

            m_ll.addView(decline);

        }



    }





    private void callDecline() {


        String url = "https://goohungrry.com/stack/v1/deliverystatus";//Put update SMS API Over here
        VolleyMultipartRequest multipartRequest = new VolleyMultipartRequest(Request.Method.POST, url, new Response.Listener<NetworkResponse>() {
            @Override
            public void onResponse(NetworkResponse response) {
                String resultResponse = new String(response.data);


                Log.v("resp", resultResponse);


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





                /* for check box */

                params.put("orderid", orderlist.getOrder_code());
                params.put("status", "0");
                return params;
            }

            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            protected Map<String, VolleyMultipartRequest.DataPart> getByteData() {


                Map<String, VolleyMultipartRequest.DataPart> params = new HashMap<>();


                return params;
            }
        };


        Myapp.getInstance().addToRequestQueue(multipartRequest);


        Toast.makeText(getApplicationContext(), "Decline", Toast.LENGTH_LONG).show();
    }

    private void callAccept() {

        String url = "https://goohungrry.com/stack/v1/deliverystatus";//Put update SMS API Over here
        VolleyMultipartRequest multipartRequest = new VolleyMultipartRequest(Request.Method.POST, url, new Response.Listener<NetworkResponse>() {
            @Override
            public void onResponse(NetworkResponse response) {
                String resultResponse = new String(response.data);

                Log.v("resp", resultResponse);


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


              }
                Log.i("Error", errorMessage);
                error.printStackTrace();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();





                /* for check box */

                params.put("orderid", orderlist.getOrder_code());
                params.put("status", "1");
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


        Toast.makeText(getApplicationContext(), "Accept", Toast.LENGTH_LONG).show();
    }
}
