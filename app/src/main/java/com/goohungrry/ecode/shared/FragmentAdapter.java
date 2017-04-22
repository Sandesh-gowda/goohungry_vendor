package com.goohungrry.ecode.shared;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kalyan pvs on 22-Sep-16.
 */
public class FragmentAdapter extends android.support.v4.app.FragmentStatePagerAdapter {
    private List<Fragment> mFragments;
    private List<String> mFragmentTitles;

    public FragmentAdapter(FragmentManager fm) {
        super(fm);
        mFragmentTitles = new ArrayList<>();
        mFragments = new ArrayList<>();
    }

    public FragmentAdapter(FragmentManager fm, ArrayList<Fragment> fragmentArrayList, ArrayList<String> mFragmentTitles) {
        super(fm);
        this.mFragmentTitles = mFragmentTitles;
        mFragments = fragmentArrayList;
    }

    public void addFragment(Fragment fragment, String title) {
        mFragments.add(fragment);
        mFragmentTitles.add(title);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitles.get(position);
    }

}
