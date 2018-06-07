package com.example.administrator.newapp.SecondLevel;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2018/5/26 0026.
 */
@SuppressLint("ValidFragment")
public class News_other_Fragment extends Fragment {
    private View view;
    private int i;


    public News_other_Fragment(int i) {
        this.i = i;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view =inflater.inflate(i,container,false);
        return view;
    }


}
