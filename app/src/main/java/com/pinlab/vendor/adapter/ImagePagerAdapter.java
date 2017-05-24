package com.pinlab.vendor.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.pinlab.vendor.R;
import com.pinlab.vendor.utils.ImageLoader;

import java.util.ArrayList;


public class ImagePagerAdapter extends PagerAdapter {

    ArrayList<String> image_urls;
    Context ctx;
    LayoutInflater inflater;

    public ImagePagerAdapter(Context ctx, ArrayList<String> image_urls) {
        this.image_urls = image_urls;
        this.ctx = ctx;
    }

    @Override
    public int getCount() {
        return image_urls.size();
    }

    @Override
    public View instantiateItem(ViewGroup container, int position) {
        inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.image_pager_item, container, false);
        ImageView photoView = (ImageView) itemView.findViewById(R.id.photoview);
        ImageLoader.loadImage(image_urls.get(position), photoView, R.drawable.placeholder);
        itemView.setTag("TAG" + position);
        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        try {
            container.removeView((RelativeLayout) object);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

}
