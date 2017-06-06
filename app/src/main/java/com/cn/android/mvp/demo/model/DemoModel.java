package com.cn.android.mvp.demo.model;

import android.content.Context;

import com.cn.android.mvp.demo.service_api.IDemoServiceApi;
import com.cn.android.nethelp.ICallBackListener;
import com.cn.android.nethelp.retrofit.HRetrofitNetHelper;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Flowable;

/**
 * @name MVP
 * @class name：com.cn.android.mvp.demo.model
 * @class TODO
 * @anthor liaoshucai
 * @mail :liaoshucai@vjwealth.com
 * @time 2017/5/16 14:05
 */
public class DemoModel implements IDemoModel{

    private Context context;

    public DemoModel(Context context) {
        this.context=context;
    }

    @Override
    public void getDeomo(ICallBackListener mICallBackListener) {
        IDemoServiceApi iDemoServiceApi = HRetrofitNetHelper.getInstance(context).getAPIService(IDemoServiceApi.class);
        Map<String, String> mParamsMap = new HashMap<>();
        mParamsMap.put("name", "ssdf");
        mParamsMap.put("password", "asdfaaaaaaaaa");
        Flowable<String> flowable = iDemoServiceApi.getDemo(mParamsMap);
//        HRetrofitNetHelper.getInstance(context).flowableSubscribe(flowable,mICallBackListener);
    }
}
