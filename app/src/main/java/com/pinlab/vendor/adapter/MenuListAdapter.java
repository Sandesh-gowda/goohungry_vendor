package com.pinlab.vendor.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SwitchCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.pinlab.vendor.Myapp;
import com.pinlab.vendor.R;
import com.pinlab.vendor.responce.MenuItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by linuxy on 1/24/17.
 */

public class MenuListAdapter extends RecyclerView.Adapter<MenuListAdapter.MenuHolder> {

    private final LayoutInflater mInflater;
    private ArrayList<MenuItem> mMenuList;
    private Context mcontext;


    public MenuListAdapter(ArrayList<MenuItem> mMenuList, Context mcontext) {
        this.mMenuList = mMenuList;
        this.mcontext = mcontext;
        mInflater = LayoutInflater.from(mcontext);

    }

    @Override
    public MenuHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewGroup mainGroup = (ViewGroup) mInflater.inflate(R.layout.disable_menu_card, parent, false);
        return new MenuHolder(mainGroup);
    }

    @Override
    public void onBindViewHolder(MenuHolder holder, int position) {
        final MenuItem model = mMenuList.get(position);
        holder.costTxt.setText("₹" + model.menu_price);
        holder.itemName.setText(model.menu_name);
        /*ImageLoader.loadImage(model.menu_url, holder.productImage, R.drawable.placeholder);

        if (model.type == 0) {
            holder.mealType.setImageResource(R.drawable.ic_non_veg);
        } else {
            holder.mealType.setImageResource(R.drawable.ic_veg);
        }
        holder.ivAddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        holder.ivSubtractProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/


if (model.availability.equals("1")){

    Log.v(" avaliable",model.availability);
    holder.switchCompat.setChecked(true);
}else{
    Log.v("Not avaliable",model.availability);
    holder.switchCompat.setChecked(false);
}
        //hariprasad code

        if(holder.switchCompat.isChecked()){
            holder.switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                    Log.v("hotel id ",model.pid);
                    addCall("not",model.pid,"0");
                    Log.v("not avaliable","5");

                }
            });
        }else {
            holder.switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                    Log.v("hotel id ",model.pid);
                    addCall("not",model.pid,"1");
                    Log.v("avaliable","5");

                }
            });
        }


    }


    @Override
    public int getItemCount() {
        return (null != mMenuList ? mMenuList.size() : 0);
    }




    private void addCall(final String id, final String str, final String menu_price) {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://goohungrry.com/stack/v1/foodstatus",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.v("ASS", response.toString());
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<String, String>();
                map.put("apikey", Myapp.getInstance().getPrefManager("Login_Preferences").getUser().getUuid());
                map.put("status", menu_price);
                map.put("pid", str);


                return map;
            }
        };
        Myapp.getInstance().getRequestQueue().add(stringRequest);
    }




    public class MenuHolder extends RecyclerView.ViewHolder {

      private SwitchCompat switchCompat;
        private LinearLayout llProductInfo;
        private ImageView productImage;
        private ImageView mealType;
        private LinearLayout llCounterLayout;
        private TextView ivSubtractProduct;
        private TextView tvCurrentQuantity;
        private TextView ivAddProduct;
        private TextView costTxt;
        private TextView itemName;

        public MenuHolder(View itemView) {
            super(itemView);

//            llProductInfo = (LinearLayout) itemView.findViewById(R.id.ll_ProductInfo);
//            productImage = (ImageView) itemView.findViewById(R.id.product_image);
//            mealType = (ImageView) itemView.findViewById(R.id.mealType);
//            llCounterLayout = (LinearLayout) itemView.findViewById(R.id.ll_CounterLayout);
//            ivSubtractProduct = (TextView) itemView.findViewById(R.id.ivSubtractProduct);
//            tvCurrentQuantity = (TextView) itemView.findViewById(R.id.tvCurrentQuantity);
//            ivAddProduct = (TextView) itemView.findViewById(R.id.ivAddProduct);
            costTxt = (TextView) itemView.findViewById(R.id.qText);
            itemName = (TextView) itemView.findViewById(R.id.dishname);
            switchCompat=(SwitchCompat)itemView.findViewById(R.id.id_useridview_switch);
        }


    }


}
