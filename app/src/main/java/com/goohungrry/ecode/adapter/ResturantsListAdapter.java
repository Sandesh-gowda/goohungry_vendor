package com.goohungrry.ecode.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.goohungrry.ecode.R;
import com.goohungrry.ecode.helper.OnitemClickLIstener;
import com.goohungrry.ecode.helper.RecyclerView_OnClickListener;
import com.goohungrry.ecode.holder.ResturantHolder;
import com.goohungrry.ecode.homeFragment.HotelMenuActivity;
import com.goohungrry.ecode.responce.Banners;
import com.goohungrry.ecode.responce.RestaurentList;
import com.goohungrry.ecode.utils.ConstantUtils;
import com.goohungrry.ecode.utils.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by linuxy on 4/12/17.
 */

public class ResturantsListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static int NORMAL_ITEM = 0;
    public static int FIRST_ITEM = 1;

    private OnitemClickLIstener onItemClickListener;
    private final LayoutInflater mInflater;
    private ArrayList<Banners> bannersArrayList;
    private Context mcontext;
    public ArrayList<RestaurentList> catLists;


    public ResturantsListAdapter(Context mcontext, ArrayList<RestaurentList> catLists, ArrayList<Banners> bannersArrayList) {
        this.catLists = catLists;
        this.mcontext = mcontext;
        mInflater = LayoutInflater.from(mcontext);
        this.bannersArrayList = bannersArrayList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == NORMAL_ITEM) {
            View mainGroup = mInflater.inflate(R.layout.card, parent, false);
            return new ResturantHolder(mainGroup);
        } else {
            View mainGroup = mInflater.inflate(R.layout.resturent_pager, parent, false);
            return new ResturantPagerHolder(mainGroup);
        }
    }

    @Override
    public int getItemViewType(int position) {
        final RestaurentList model = catLists.get(position);
        return model.itemType;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int viewType = getItemViewType(position);
        if (viewType == NORMAL_ITEM) {
            ResturantHolder resturantHolder = (ResturantHolder) holder;
            setNormalData(position, resturantHolder);
        } else {
            ResturantPagerHolder resturantHolder = (ResturantPagerHolder) holder;
            setPagerData(resturantHolder);
        }
    }

    private void setPagerData(ResturantPagerHolder resturantHolder) {
        ArrayList<String> imageList = new ArrayList<>();
        for (Banners banners : bannersArrayList) {
            imageList.add(banners.bgurl);
        }
        ImagePagerAdapter adapter = new ImagePagerAdapter(mcontext, imageList);
        resturantHolder.pager.setAdapter(adapter);

        resturantHolder.tabLayout.setupWithViewPager(resturantHolder.pager, true);
    }

    private void setNormalData(int position, ResturantHolder holder) {
        final RestaurentList model = catLists.get(position);
        List<String> cuisn = model.cuisine;
        holder.cusinName.setText(android.text.TextUtils.join(",", cuisn));
        holder.res.setText(model.name);
        ImageLoader.loadImage(model.image, holder.draweeView, R.drawable.placeholder);
        holder.rowItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mcontext, HotelMenuActivity.class);
                intent.putExtra(ConstantUtils.DATA, model.uuid);
                mcontext.startActivity(intent);
            }
        });

    }


    @Override
    public int getItemCount() {
        return (null != catLists ? catLists.size() : 0);
    }


    public class ResturantPagerHolder extends RecyclerView.ViewHolder {


        private final ViewPager pager;
        TabLayout tabLayout;

        public View rowItem;


        public RecyclerView_OnClickListener.OnClickListener onClickListener;

        public ResturantPagerHolder(View itemView) {
            super(itemView);
            rowItem = itemView;
            tabLayout = (TabLayout) itemView.findViewById(R.id.tab_layout);
            pager = (ViewPager) itemView.findViewById(R.id.pager);
        }

    }

}
