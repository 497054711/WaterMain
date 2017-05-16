package com.cn.android.mvp.demo.view;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.cn.android.mvp.BaseFragmentActivity;
import com.cn.android.mvp.demo.present.DemoPresent;
import com.cn.android.nethelp.BaseCallBack;
import com.cn.android.nethelp.ICallBackListener;

/**
 * @name MVP
 * @class name：com.cn.android.mvp.demo.view
 * @class TODO
 * @anthor liaoshucai
 * @mail :liaoshucai@vjwealth.com
 * @time 2017/5/16 14:07
 */
public class DemoActivity extends BaseFragmentActivity implements IDemoView  {
    private DemoPresent demoPresent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        demoPresent=new DemoPresent(this,this);
        demoPresent.getDemo(new ICallBackListener() {
            @Override
            public void onSuccess(BaseCallBack mBaseCallBack) {

            }

            @Override
            public void onFaild(BaseCallBack mBaseCallBack) {

            }
        });
    }
}
