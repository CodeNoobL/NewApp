package com.example.administrator.newapp.ThirdLevel;

/**
 * Created by Administrator on 2018/6/5 0005.
 */

public class Bean {
    private String picurl;
    private String title;
    private String context;
    private String url;
    private boolean click = false;

    public boolean isClick() {
        return click;
    }

    public void setClick(boolean click) {
        this.click = click;
    }
    public boolean getClick(){
        return click;
    }

    public Bean() {
        this.picurl = null;
        this.title = null;
        this.context = null;
        this.url = null;
    }

    public Bean(String picurl, String title) {
        this.picurl = picurl;
        this.title = title;
    }

    public String getPicurl() {
        return picurl;
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Bean(String picurl, String title, String context) {
        this.picurl = picurl;
        this.title = title;

        this.context = context;
    }

    public Bean(String picurl, String title, String context, String url) {
        this.picurl = picurl;
        this.title = title;
        this.context = context;
        this.url = url;
    }


}
