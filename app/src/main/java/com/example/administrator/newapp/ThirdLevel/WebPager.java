package com.example.administrator.newapp.ThirdLevel;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.example.administrator.newapp.FirstLevel.MainActivity;
import com.example.administrator.newapp.R;

/**
 * Created by Administrator on 2018/6/6 0006.
 */

public class WebPager extends Activity{

    private WebView webView;
    ProgressDialog progressDialog;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_web);
        webView = (WebView)findViewById(R.id.webview);
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");

        webView.setWebViewClient(new WebViewClientEmb());
        webView.loadUrl(url);

    }

//    public void loadUrl(String url)
//    {
//        if(webView != null)
//        {
//            webView.loadUrl(url);
//            progressDialog = ProgressDialog.show(this,null,"页面加载中，请稍后..");
//            webView.reload();
//        }
//    }

    public void back(View view){
        finish();
    }


    public class WebViewClientEmb extends WebViewClient {

        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            super.onReceivedSslError(view, handler, error);// 接受所有网站的证书
        }

        // 页面载入前调用
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {

                progressDialog =  ProgressDialog.show(webView.getContext(),null,"页面加载中，请稍后..");
        }

        @Override
        public void onPageFinished(WebView view, String url) {

            progressDialog.dismiss();
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {

            return false;

        }
    }
}

