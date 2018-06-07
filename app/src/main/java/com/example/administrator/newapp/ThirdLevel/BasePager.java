package com.example.administrator.newapp.ThirdLevel;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.newapp.R;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Administrator on 2018/6/5 0005.
 */

public class BasePager {


    public Activity mActivity;
    public View mRootView; //当前页面根布局
    private View view;
    private ImageView imageView;
    private TextView textView;
    private Bean bean;
    public static boolean isLoad = false;

    public BasePager(Activity mActivity,Bean bean) {
        this.mActivity = mActivity;
        this.bean = bean;
        mRootView = initView();
    }

    @Nullable
    public View initView() {
        view = View.inflate(mActivity, R.layout.basepager,null);
        imageView_init();
        textView_init();
        return view;
    }

    public void imageView_init() {
        imageView = (ImageView)view.findViewById(R.id.imageview);
        try {
            URL u = new URL(bean.getPicurl());
            Glide.with(mActivity)
                    .load(u)
                    .placeholder(R.drawable.wait)
                    .into(imageView);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


    }

    public void textView_init() {
        textView = (TextView)view.findViewById(R.id.textview);
        textView.setText(bean.getTitle());
    }

}
