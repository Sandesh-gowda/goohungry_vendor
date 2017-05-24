package com.pinlab.vendor.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.pinlab.vendor.R;
import com.pinlab.vendor.helper.RecyclerView_OnClickListener;
import com.pinlab.vendor.ui.GooTextView;

/**
 * Created by linuxy on 4/12/17.
 */

public class OrderviewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


    public GooTextView res, delvertime;
    public TextView cost;
    public GooTextView cusinName;
    public ImageView draweeView;
    public View rowItem;


    public RecyclerView_OnClickListener.OnClickListener onClickListener;

    public OrderviewHolder(View itemView) {
        super(itemView);
        rowItem = itemView;
        res = (GooTextView) itemView.findViewById(R.id.OrderName);
        delvertime =(GooTextView) itemView.findViewById(R.id.qText);
                cost =(TextView) itemView.findViewById(R.id.id_cost);
         }

    @Override
    public void onClick(View view) {

    }
}
