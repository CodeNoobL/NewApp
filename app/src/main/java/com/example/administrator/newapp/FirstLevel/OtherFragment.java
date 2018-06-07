package com.example.administrator.newapp.FirstLevel;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.newapp.R;

/**
 * Created by Administrator on 2018/5/22 0022.
 */
@SuppressLint("ValidFragment")
public class OtherFragment extends Fragment {
    private View view;
    private TextView textView;
    private String s;

    public OtherFragment(String s) {
        this.s = s;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view =inflater.inflate(R.layout.other_first,container,false);
        textView = (TextView)view.findViewById(R.id.textview);
        textView.setText(s);
        return view;
    }
}
