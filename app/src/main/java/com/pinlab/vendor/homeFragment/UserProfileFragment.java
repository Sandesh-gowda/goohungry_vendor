package com.pinlab.vendor.homeFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pinlab.vendor.R;

/**
 * Created by linuxy on 4/10/17.
 */

public class UserProfileFragment  extends Fragment{

    public UserProfileFragment() {
    }

    private View view;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.cart_list, container, false);


        return view;
    }
}
