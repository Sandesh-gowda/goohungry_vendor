package com.goohungrry.ecode;

import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;

import com.malinskiy.superrecyclerview.OnEmptyClickListener;
import com.malinskiy.superrecyclerview.OnMoreListener;

/**
 * Created by Kalyan on 4/19/2017.
 */

public class BaseFragment extends Fragment implements OnMoreListener,OnEmptyClickListener,SwipeRefreshLayout.OnRefreshListener {
    @Override
    public void onRefresh() {

    }

    @Override
    public void onEmptyItemClick(int emptyId) {

    }

    @Override
    public void onMoreAsked(int overallItemsCount, int itemsBeforeMore, int maxLastVisiblePosition) {

    }
}
