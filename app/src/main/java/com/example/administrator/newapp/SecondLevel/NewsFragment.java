package com.example.administrator.newapp.SecondLevel;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.newapp.FirstLevel.MainActivity;
import com.example.administrator.newapp.R;
import com.example.administrator.newapp.SecondLevel.adapter.ViewPagerAdapter_Second;
import com.example.administrator.newapp.ThirdLevel.NewsThirdFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/22 0022.
 */
@SuppressLint("ValidFragment")
public class NewsFragment extends Fragment {
    int i = 0;
    private Activity mActivity;
    private View view;
    private FragmentManager fm;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<Object> list_secondlevel = new ArrayList<Object>();
    private ViewPagerAdapter_Second viewPagerAdapterSecond;



    public NewsFragment(Activity mActivity) {
        this.mActivity = mActivity;

    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view =inflater.inflate(R.layout.news_first,container,false);
        tabLayout_init();
        viewPager_init();

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        } );
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener(){

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                tabLayout.setScrollPosition(position,positionOffset,true);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        return view;
    }

    private void viewPager_init() {
        viewPager = (ViewPager)view.findViewById(R.id.viewPager_second);

        fm = getFragmentManager();
        String[] types = new String[]{
                "top",
                "shehui",
                "guonei",
                "guoji",
                "yule",
                "tiyu",
                "junshi",
                "keji",
                "caijing",
                "shishang"

        };
        for(int i = 0;i<types.length;i++){
            list_secondlevel.add(new NewsThirdFragment(mActivity,types[i]));
        }
        viewPagerAdapterSecond = new ViewPagerAdapter_Second(list_secondlevel);
        viewPager.setAdapter(viewPagerAdapterSecond);
        viewPager.setCurrentItem(0,false);
        viewPager.setOffscreenPageLimit(list_secondlevel.size());




    }

    private void tabLayout_init() {
        tabLayout = (TabLayout)view.findViewById(R.id.tabLayout);
        String[] titles = new String[]{
                "头条",
                "社会",
                "国内",
                "国际",
                "娱乐",
                "体育",
                "军事",
                "科技",
                "财经",
                "时尚"};

        //循环注入标签
        for (String tab:titles){
            tabLayout.addTab(tabLayout.newTab().setText(tab));
        }


    }


}
