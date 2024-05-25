package com.example.softwareproject3_1;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class websiteManager extends AppCompatActivity {
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_website_manager);

        webView=findViewById(R.id.webViewId);

        WebSettings webSettings=webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        //webSettings.setUserAgentString("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.140 Safari/537.36");

        //enable desktop mode
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);

        webView.setWebViewClient(new WebViewClient());
        //webView.loadUrl("https://www.youtube.com");

        String url="www.google.com";
        //-----bundle is  for which website button is pressed
        //data receive from another activity
        Bundle bundle = getIntent().getExtras();
        if (bundle != null)
        {
            String text=bundle.getString("website");
            if (text != null) {
                url=text;
            }
        }

        webView.loadUrl(url);
    }
    @Override
    public void onBackPressed()
    {
        if(webView.canGoBack()) webView.goBack();
        else super.onBackPressed();
    }



}