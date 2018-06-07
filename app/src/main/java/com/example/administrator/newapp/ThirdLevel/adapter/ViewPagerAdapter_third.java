package com.example.administrator.newapp.ThirdLevel.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.newapp.R;
import com.example.administrator.newapp.ThirdLevel.Bean;


import java.util.List;

/**
 * Created by 18573 on 2018/6/4.
 */
public class ViewPagerAdapter_third extends PagerAdapter {
    private List<Bean> list;
    private Context context;
    private onIntemViewPagerClickListerner item;
    public ViewPagerAdapter_third(Context context, List<Bean> list) {
        this.list = list;
        this.context = context;
    }
    public interface  onIntemViewPagerClickListerner{
       void onIntemViewPagerClickListerner(String url);
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        View view = View.inflate(context, R.layout.basepager,null);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item.onIntemViewPagerClickListerner(list.get(position).getUrl());
            }
        });
        ImageView iv = (ImageView) view.findViewById(R.id.imageview);
        Glide.with(context).load(list.get(position).getPicurl()).placeholder(R.drawable.wait).into(iv);
        TextView tv = (TextView)view.findViewById(R.id.textview);
        tv.setText(list.get(position).getTitle());
        container.addView(view);
        return view;
    }

    public void setOnItemClick(onIntemViewPagerClickListerner item){
        this.item = item;
    }
}
