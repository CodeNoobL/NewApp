package com.example.administrator.newapp.FirstLevel.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2018/5/22 0022.
 */

public class ViewPagerAdapter_first extends FragmentPagerAdapter {
    private List<Object> views;

    public ViewPagerAdapter_first(FragmentManager fm, List<Object> views) {
        super(fm);
        this.views = views;
    }

    @Override
    public Fragment getItem(int position) {
        return (Fragment)views.get(position);
    }

    @Override
    public int getCount() {
        return views.size();
    }
}
