package com.goohungrry.ecode.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.goohungrry.ecode.R;
import com.goohungrry.ecode.responce.MenuItem;
import com.goohungrry.ecode.utils.ImageLoader;

import java.util.ArrayList;

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
        ViewGroup mainGroup = (ViewGroup) mInflater.inflate(R.layout.hotel_menu_item_layout, parent, false);
        return new MenuHolder(mainGroup);
    }

    @Override
    public void onBindViewHolder(MenuHolder holder, int position) {
        final MenuItem model = mMenuList.get(position);
        holder.costTxt.setText("₹" + model.menu_price);
        holder.itemName.setText(model.menu_name);
        ImageLoader.loadImage(model.menu_url, holder.productImage, R.drawable.placeholder);

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
        });

    }


    @Override
    public int getItemCount() {
        return (null != mMenuList ? mMenuList.size() : 0);
    }


    public class MenuHolder extends RecyclerView.ViewHolder {


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

            llProductInfo = (LinearLayout) itemView.findViewById(R.id.ll_ProductInfo);
            productImage = (ImageView) itemView.findViewById(R.id.product_image);
            mealType = (ImageView) itemView.findViewById(R.id.mealType);
            llCounterLayout = (LinearLayout) itemView.findViewById(R.id.ll_CounterLayout);
            ivSubtractProduct = (TextView) itemView.findViewById(R.id.ivSubtractProduct);
            tvCurrentQuantity = (TextView) itemView.findViewById(R.id.tvCurrentQuantity);
            ivAddProduct = (TextView) itemView.findViewById(R.id.ivAddProduct);
            costTxt = (TextView) itemView.findViewById(R.id.costTxt);
            itemName = (TextView) itemView.findViewById(R.id.itemName);
        }


    }


}
