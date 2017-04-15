package com.goohungrry.ecode.helper;

import android.view.View;

/**
 * Created by Innovative_lab .
 */
public interface RecyclerView_OnClickListener {
    /**
     * Interface for Item Click over Recycler View Items
     **/
    public interface OnClickListener {
        public void OnItemClick(View view, int position);
    }
}
