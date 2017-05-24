package com.pinlab.vendor.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.pinlab.vendor.OrderMenuList;
import com.pinlab.vendor.R;
import com.pinlab.vendor.helper.OnitemClickLIstener;
import com.pinlab.vendor.holder.OrderviewHolder;
import com.pinlab.vendor.model.over.MenuItem;
import com.pinlab.vendor.model.over.Orderlist;
import com.pinlab.vendor.utils.ConstantUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by linuxy on 5/2/17.
 */

public class OrderResturantAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<MenuItem> menuItems;

    private OnitemClickLIstener onItemClickListener;
    private final LayoutInflater mInflater;
    private Context mcontext;
    public ArrayList<Orderlist> catLists;



   public OrderResturantAdapter(Context mcontext, ArrayList<Orderlist> catLists){
       this.catLists = catLists;
       this.mcontext = mcontext;
       mInflater = LayoutInflater.from(mcontext);
    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View mainGroup = mInflater.inflate(R.layout.order_card, parent, false);
            return new OrderviewHolder(mainGroup);
        }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int viewType = getItemViewType(position);

            OrderviewHolder resturantHolder = (OrderviewHolder) holder;
            setNormalData(position, resturantHolder);

    }



    private void setNormalData(final int position, OrderviewHolder holder) {
        final Orderlist model = catLists.get(position);


        holder.res.setText(model.getUser());
        holder.delvertime.setText(model.getOrdertime());
        holder.cost.setText("₹"+model.getFinalcost());

        holder.rowItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(mcontext, OrderMenuList.class);
                intent.putExtra(ConstantUtils.LISTOFORDERITEMS, catLists.get(position));
               mcontext.startActivity(intent);
            }
        });

    }




    @Override
    public int getItemCount() {
        return (null != catLists ? catLists.size() : 0);
    }


}
