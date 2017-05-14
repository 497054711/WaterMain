package com.cn.watermain.mvp;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.webkit.JsResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.cn.watermain.R;

/**
 * Created by Administrator on 2017/3/11.
 */

public class WebViewActivity extends BaseFragmentActivity {
    private WebView main_wb;
    private WebSettings wv_setttig;
    private WebViewClient webViewClient;
    private String url;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.webview);
        url=this.getIntent().getStringExtra("url");
        main_wb= (WebView) this.findViewById(R.id.main_wb);
        wv_setttig = main_wb.getSettings();
        wv_setttig.setJavaScriptEnabled(true);
        wv_setttig.setJavaScriptCanOpenWindowsAutomatically(true);
        wv_setttig.setCacheMode(WebSettings.LOAD_NO_CACHE);
        wv_setttig.setDomStorageEnabled(true);

        webViewClient = new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                super.onReceivedSslError(view, handler, error);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return super.shouldOverrideUrlLoading(view, request);
            }
        };
        main_wb.setWebViewClient(webViewClient);
        main_wb.setWebChromeClient(new WebChromeClient() {

            @Override
            public boolean onJsAlert(WebView view, String url, String message,
                                     JsResult result) {
                // TODO Auto-generated method stub

                return super.onJsAlert(view, url, message, result);
            }

        });
//        main_wb.loadUrl("file:///android_asset/report/report-login_branch.html");
        main_wb.loadUrl(url);
    }
}
