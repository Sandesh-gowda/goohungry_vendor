package com.pinlab.vendor.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.pinlab.vendor.R;
import com.pinlab.vendor.helper.RecyclerView_OnClickListener;
import com.pinlab.vendor.ui.GooTextView;

/**
 * Created by linuxy on 4/12/17.
 */

public class ResturantHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


    public GooTextView res, delvertime;
    public GooTextView cusinName;
    public ImageView draweeView;
    public View rowItem;


    public RecyclerView_OnClickListener.OnClickListener onClickListener;

    public ResturantHolder(View itemView) {
        super(itemView);
        rowItem = itemView;
        draweeView = (ImageView) itemView.findViewById(R.id.item_image);
        res = (GooTextView) itemView.findViewById(R.id.dishname);
        cusinName = (GooTextView) itemView.findViewById(R.id.qText);
        delvertime =(GooTextView) itemView.findViewById(R.id.restaurant_delivery_time);
    }

    @Override
    public void onClick(View view) {

    }
}
