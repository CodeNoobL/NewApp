package com.example.administrator.newapp.splash;


import android.content.Intent;
import android.os.Bundle;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.example.administrator.newapp.FirstLevel.MainActivity;
import com.example.administrator.newapp.R;

import static java.lang.Thread.sleep;

/**
 * Created by Administrator on 2018/6/6 0006.
 */
public class Splash extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);//隐藏状态栏
        getSupportActionBar().hide();//隐藏标题栏

        setContentView(R.layout.splash);


        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sleep(2500);//使程序休眠五秒
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent it=new Intent(getApplicationContext(),MainActivity.class);//启动MainActivity
                startActivity(it);
                finish();//关闭当前活动
            }
        }).start();
    }
}
