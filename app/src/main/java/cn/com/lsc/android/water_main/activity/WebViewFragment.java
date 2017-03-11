package cn.com.lsc.android.water_main.activity;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.JsResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import cn.com.lsc.android.water_main.R;

/**
 * Created by Administrator on 2017/3/11.
 */

public class WebViewFragment extends BaseFragment {

    public WebView main_wb;
    private WebSettings wv_setttig;
    private WebViewClient webViewClient;
    private String url;
    private Bundle bundle;
    private Dialog dialog;

    private CallBackInterface callBackInterface;

    public WebView getMain_wb() {
        return main_wb;
    }

    public void setCallBackInterface(CallBackInterface callBackInterface) {
        this.callBackInterface = callBackInterface;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.webview, null);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        bundle = this.getArguments();
        if (bundle != null) {
            url = this.getArguments().getString("url");
        }
        dialog=loadingProgressDialog();
        main_wb = (WebView) this.getView().findViewById(R.id.main_wb);
        wv_setttig = main_wb.getSettings();
        wv_setttig.setJavaScriptEnabled(true);
        wv_setttig.setJavaScriptCanOpenWindowsAutomatically(true);
        wv_setttig.setCacheMode(WebSettings.LOAD_NO_CACHE);
        wv_setttig.setDomStorageEnabled(true);

        webViewClient = new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                Log.i("onPageStarted==", url);
                dialog.show();
                if(callBackInterface!=null){
                    callBackInterface.webStartCallBack(url);
                }
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                Log.i("onPageFinished==", url);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        dialog.dismiss();
                    }
                },500);
            }

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                super.onReceivedSslError(view, handler, error);
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
        main_wb.loadUrl(url);
    }

    public interface CallBackInterface{
        public void webStartCallBack(String url);
    }
    public Dialog loadingProgressDialog(){
        LayoutInflater inflater = LayoutInflater.from(this.getActivity());
        View loadingView = inflater.inflate(R.layout.dialog_loading, null);// 得到加载view
        Dialog loadingDialog = new Dialog(this.getActivity(),R.style.TransparentCenter);// 创建自定义样式dialog
        loadingDialog.setCancelable(false);//
        loadingDialog.setContentView(loadingView);// 设置布局
        return loadingDialog;
    }
}
