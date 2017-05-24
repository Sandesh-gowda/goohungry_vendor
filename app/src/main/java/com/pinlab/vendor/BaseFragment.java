package com.pinlab.vendor;

import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;

import com.pinlab.vendor.network.ResponseHandler;
import com.malinskiy.superrecyclerview.OnEmptyClickListener;
import com.malinskiy.superrecyclerview.OnMoreListener;

/**
 * Created by Kalyan on 4/19/2017.
 */

public class BaseFragment extends Fragment implements OnMoreListener,OnEmptyClickListener,SwipeRefreshLayout.OnRefreshListener,ResponseHandler {
    @Override
    public void onRefresh() {

    }

    @Override
    public void onEmptyItemClick(int emptyId) {

    }

    @Override
    public void onMoreAsked(int overallItemsCount, int itemsBeforeMore, int maxLastVisiblePosition) {

    }

    @Override
    public void onSuccess(String responce, Object data, int urlId, int position) {

    }

    @Override
    public void onFailure(Exception e, int urlId) {

    }
}
