package com.example.administrator.newapp.FirstLevel;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.administrator.newapp.FirstLevel.adapter.ViewPagerAdapter_first;
import com.example.administrator.newapp.R;
import com.example.administrator.newapp.SecondLevel.NewsFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    private NoScrollViewPager noScrollViewPager;
    private FragmentManager fm;
    private List<Object>list_firstlevel = new ArrayList<Object>();
    private ViewPagerAdapter_first viewPagerAdapterFirst;
    private RadioGroup radioGroup;
    private RadioButton rb_news,rb_video,rb_menu,rb_show,rb_me;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();//隐藏标题栏
        setContentView(R.layout.activity_main);
        viewPager_init();
        radioGroup_init();
        listener_init();
    }


    private void radioGroup_init() {
        radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        rb_news = (RadioButton)findViewById(R.id.rb_news);
        rb_video = (RadioButton)findViewById(R.id.rb_video);
        rb_menu = (RadioButton)findViewById(R.id.rb_menu);
        rb_show = (RadioButton)findViewById(R.id.rb_show);
        rb_me = (RadioButton)findViewById(R.id.rb_me);

    }

    private void viewPager_init() {
        noScrollViewPager = (NoScrollViewPager)findViewById(R.id.viewPager_firstlevel);
        fm = this.getSupportFragmentManager();
        //加页面
        list_firstlevel.add(new NewsFragment(MainActivity.this));
        list_firstlevel.add(new OtherFragment("视频"));
        list_firstlevel.add(new OtherFragment("菜单"));
        list_firstlevel.add(new OtherFragment("直播"));
        list_firstlevel.add(new OtherFragment("自己"));
        //实例适配器
        viewPagerAdapterFirst = new ViewPagerAdapter_first(fm,list_firstlevel);
        noScrollViewPager.setAdapter(viewPagerAdapterFirst);
        noScrollViewPager.setCurrentItem(0,false);//设置初始页面
        noScrollViewPager.setScanScroll(false);  //设置不可滑动
        noScrollViewPager.setOffscreenPageLimit(list_firstlevel.size());
    }
    private void listener_init() {
        radioGroup.setOnCheckedChangeListener(this);
    }
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.rb_news:
                noScrollViewPager.setCurrentItem(0);
                break;
            case R.id.rb_video:
                noScrollViewPager.setCurrentItem(1);
                rb_news = (RadioButton)findViewById(R.id.rb_news);
                rb_news.setChecked(false);
                break;
            case R.id.rb_menu:
                noScrollViewPager.setCurrentItem(2);
                rb_news = (RadioButton)findViewById(R.id.rb_news);
                rb_news.setChecked(false);
                break;
            case R.id.rb_show:
                noScrollViewPager.setCurrentItem(3);
                rb_news = (RadioButton)findViewById(R.id.rb_news);
                rb_news.setChecked(false);
                break;
            case R.id.rb_me:
                noScrollViewPager.setCurrentItem(4);
                rb_news = (RadioButton)findViewById(R.id.rb_news);
                rb_news.setChecked(false);
                break;
        }
    }

}
