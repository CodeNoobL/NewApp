package com.example.administrator.newapp.ThirdLevel.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.newapp.R;
import com.example.administrator.newapp.ThirdLevel.Bean;

import java.util.List;

/**
 * Created by 18573 on 2018/6/4.
 */

public class ListViewAdapter_third extends BaseAdapter{
    private List<Bean> list;
    private Context context;
    private int length;

    public ListViewAdapter_third(Context context, List<Bean> list) {
        this.list = list;
        this.context = context;
        length = list.size()-3;
    }

    @Override
    public int getCount() {
        return length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view ;
        ViewHolder holder ;
        if(convertView == null){
            view = View.inflate(context, R.layout.listview_third,null);
            holder = new ViewHolder();
            holder.tvTitle = (TextView) view.findViewById(R.id.bigtv);
            holder.tvName = (TextView) view.findViewById(R.id.smalltv);
            holder.ivIcon = (ImageView) view.findViewById(R.id.iv);
            view.setTag(holder);
        }else{
            view = convertView;
            holder = (ViewHolder) view.getTag();
            if(list.get(position+3).getClick()== true){
                holder.tvTitle.setTextColor(Color.GRAY);
            }else{
                holder.tvTitle.setTextColor(Color.BLACK);
            }


        }
        if(position+3<list.size() ) {
            holder.tvTitle.setText(list.get(position + 3).getTitle());
            holder.tvName.setText(list.get(position + 3).getContext());
            Glide.with(context).load(list.get(position + 3).getPicurl()).placeholder(R.drawable.wait).into(holder.ivIcon);
        }
        return view;
    }
    class ViewHolder {
        TextView tvTitle;
        TextView tvName;
        ImageView ivIcon;
    }
}
