package com.goohungrry.ecode.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.goohungrry.ecode.R;
import com.goohungrry.ecode.helper.OnitemClickLIstener;
import com.goohungrry.ecode.holder.ResturantHolder;
import com.goohungrry.ecode.model.resturantList.RestList;
import com.goohungrry.ecode.model.resturantList.ResturantList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by linuxy on 4/12/17.
 */

public class ResturantListAdapter extends RecyclerView.Adapter<ResturantHolder> {
    private OnitemClickLIstener onItemClickListener;
    private final LayoutInflater mInflater;
    private Context mcontext;
    public ArrayList<RestList> catLists;


    public ResturantListAdapter(ArrayList<RestList> catLists, Context mcontext) {
        this.catLists = catLists;
        this.mcontext = mcontext;
        mInflater = LayoutInflater.from(mcontext);

    }

    @Override
    public ResturantHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewGroup mainGroup = (ViewGroup) mInflater.inflate(R.layout.card

                , parent, false);

        return new ResturantHolder(mainGroup);
    }

    @Override
    public void onBindViewHolder(ResturantHolder holder, int position) {
        final RestList model = catLists.get(position);
        Log.v("ResturantName",model.getName());
        List<String> cuisn =model.getCuisine();


        holder.cusinName.setText(android.text.TextUtils.join(",", cuisn));
        holder.res.setText(model.getName());
        Uri imageUri = Uri.parse(model.getImage());
        holder.draweeView.setImageURI(imageUri);
    }



    @Override
    public int getItemCount() {
        return (null != catLists ? catLists.size() : 0);
    }
}
