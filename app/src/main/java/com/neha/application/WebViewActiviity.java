package com.neha.application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActiviity extends AppCompatActivity {
    WebView webView;

    void initViews(){

        Intent rcv = getIntent();

        News news = (News)rcv.getSerializableExtra("keyNews");



        //getSupportActionBar().setTitle("Amazon");
        getSupportActionBar().hide();
        getSupportActionBar().setTitle(news.title);

        webView = findViewById(R.id.webView);


        webView.loadUrl("https://www.ndtv.com/");
        webView.loadUrl(news.url);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_activiity);
        initViews();
    }
}
