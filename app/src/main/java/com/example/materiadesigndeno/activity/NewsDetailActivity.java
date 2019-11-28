package com.example.materiadesigndeno.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.example.materiadesigndeno.R;
import com.example.materiadesigndeno.model.News;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class NewsDetailActivity extends AppCompatActivity {
    private WebView wvNews;
    private WebSettings settings;

    private Toolbar toolbar;

    public NewsDetailActivity() {
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);

        // 设置标题栏回退按钮，及点击事件
        toolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NewsDetailActivity.this.finish();
            }
        });
        wvNews = findViewById(R.id.wv_news_detail);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            final News news = (News) bundle.get("news");
            wvNews.loadUrl(news.getUrl());
            settings = wvNews.getSettings();
            settings.setBuiltInZoomControls(true);
            settings.setJavaScriptEnabled(true);
            settings.setBlockNetworkImage(false);// 解决图片不能加载
            settings.setUseWideViewPort(true);  //将图片调整到适合webview的大小
            settings.setLoadWithOverviewMode(true); // 缩放至屏幕的大小
            settings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);  // 解决http和https混合问题

        }
    }
}
