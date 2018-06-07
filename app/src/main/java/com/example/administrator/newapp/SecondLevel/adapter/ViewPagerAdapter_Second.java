package com.example.administrator.newapp.SecondLevel.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.newapp.ThirdLevel.NewsThirdFragment;

import java.util.List;

/**
 * Created by Administrator on 2018/5/21 0021.
 */

public class ViewPagerAdapter_Second extends PagerAdapter {
    private List<Object> l1;


    public ViewPagerAdapter_Second(List<Object> l1) {
        this.l1 = l1;

    }

    @Override
    public CharSequence getPageTitle(int position) {
        return (CharSequence) l1.get(position);
    }

    @Override
    public int getCount() {
        return l1.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        NewsThirdFragment newsThirdFragment = (NewsThirdFragment) l1.get(position);
        newsThirdFragment.data_init();
        container.addView(newsThirdFragment.mRootView);
        return newsThirdFragment.mRootView;
    }
}
