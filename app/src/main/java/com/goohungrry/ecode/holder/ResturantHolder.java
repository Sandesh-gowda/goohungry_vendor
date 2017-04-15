package com.goohungrry.ecode.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.goohungrry.ecode.R;
import com.goohungrry.ecode.helper.RecyclerView_OnClickListener;
import com.goohungrry.ecode.ui.GooTextView;

/**
 * Created by linuxy on 4/12/17.
 */

public class ResturantHolder extends RecyclerView.ViewHolder implements View.OnClickListener
        {


public GooTextView res;
            public GooTextView cusinName;
            public SimpleDraweeView draweeView;


            public RecyclerView_OnClickListener.OnClickListener onClickListener;
            public ResturantHolder(View itemView) {
                super(itemView);

                draweeView = (SimpleDraweeView) itemView.findViewById(R.id.item_image);
                res = (GooTextView) itemView.findViewById(R.id.dishname);
                cusinName =(GooTextView) itemView.findViewById(R.id.qText);
            }

            @Override
            public void onClick(View view) {

            }
        }
