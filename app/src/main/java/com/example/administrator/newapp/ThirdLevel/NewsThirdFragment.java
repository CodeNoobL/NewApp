package com.example.administrator.newapp.ThirdLevel;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.newapp.FirstLevel.MainActivity;
import com.example.administrator.newapp.R;
import com.example.administrator.newapp.ThirdLevel.adapter.ListViewAdapter_third;
import com.example.administrator.newapp.ThirdLevel.adapter.ViewPagerAdapter_third;
import com.example.administrator.newapp.Util;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/6/6 0006.
 */

public class NewsThirdFragment {
    int i = 0;
    private Activity mActivity;
    public View mRootView;
    private String type;  //访问页面类型
    private ViewPager viewPager;
    private ListView listView;
    private List<Bean> bean = new ArrayList<Bean>();
    public Handler handler1 = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if(i<2){
                i++;
                viewPager.setCurrentItem(i);
            }else{
                i = 0;
                viewPager.setCurrentItem(i);
            }
            handler1.sendEmptyMessageDelayed(0,3000);
        }
    };
    public Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            try {
                JSONObject jsonObject = new JSONObject((String) msg.obj);
                JSONObject result = jsonObject.getJSONObject("result");
                JSONArray data = result.getJSONArray("data");
                for (int i = 0; i < data.length(); i++) {
                    JSONObject json = data.getJSONObject(i);
                    String pic = json.optString("thumbnail_pic_s");
                    String title = json.optString("title");
                    String context = json.optString("author_name") + "     "+json.optString("date");
                    String url = json.optString("url");
                    Bean b = new Bean();
                    b.setPicurl(pic);
                    b.setTitle(title);
                    b.setContext(context);
                    b.setUrl(url);
                    bean.add(b);

                }

//                viewPager.setAdapter(new ViewPagerAdapter_third(mActivity,bean));
//                listView.setAdapter(new ListViewAdapter_third(mActivity,bean));

            } catch (JSONException e) {
                e.printStackTrace();
            }finally {
                ViewPagerAdapter_third adapter = new ViewPagerAdapter_third(mActivity,bean);
                viewPager.setAdapter(adapter);
                listView.setAdapter(new ListViewAdapter_third(mActivity,bean));
                BasePager.isLoad = true;
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener(

                ) {


                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                        bean.get(position+3).setClick(true);
                        Intent intent = new Intent(mActivity, WebPager.class);
                        intent.putExtra("url",bean.get(position+3).getUrl());
                        mActivity.startActivity(intent);

                        TextView textViewx = (TextView)view.findViewById(R.id.bigtv);
                        textViewx.setTextColor(Color.GRAY);
                    }
                });
                adapter.setOnItemClick(new ViewPagerAdapter_third.onIntemViewPagerClickListerner() {

                    @Override
                    public void onIntemViewPagerClickListerner(String url) {
                        Intent intent = new Intent(mActivity,WebPager.class);
                        intent.putExtra("url",url);
                        mActivity.startActivity(intent);
                    }
                });
            }
        }
    };

    public NewsThirdFragment(Activity mActivity, String type) {
        this.mActivity = mActivity;
        this.type = type;
        mRootView = init();
    }


    public View init() {
        View view = View.inflate(mActivity,R.layout.news_third,null);
        listView = (ListView)view.findViewById(R.id.listview_third);
        viewPager = (ViewPager)view.findViewById(R.id.viewPager_third);
        handler1.sendEmptyMessageDelayed(0,3000);
        return view;
       }

    public void data_init() {

        final String path = "http://toutiao-ali.juheapi.com/toutiao/index?type="+type;
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(path);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("GET");
                    conn.setRequestProperty("Authorization","APPCODE 0664f1ebcc3a41808e970e6c11f13962");
                    conn.setConnectTimeout(10000);
                    conn.setReadTimeout(10000);
                    if (conn.getResponseCode() == 200) {
                        InputStream is = conn.getInputStream();
                        String s = Util.stream2String(is);
                        Message message = Message.obtain();
                        message.what = 0;
                        message.obj = s;
                        handler.sendMessage(message);
                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (ProtocolException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }


}
