package com.cn.watermain.mvp.login.model;

import android.content.Context;

import com.cn.watermain.mvp.BaseBean;
import com.cn.watermain.mvp.login.service_api.ILoginServiceApi;
import com.cn.watermain.nethelp.ICallBackListener;
import com.cn.watermain.nethelp.retrofit.HRetrofitNetHelper;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Flowable;

/**
 * Created by Administrator on 2017/3/19.
 */

public class LoginModel implements ILoginModel {
    private Context context;

    public LoginModel(Context context) {
        this.context=context;
    }

    @Override
    public void login(ICallBackListener mICallBackListener) {
        ILoginServiceApi iLoginServiceApi = HRetrofitNetHelper.getInstance(context).getAPIService(ILoginServiceApi.class);
        Map<String, String> mParamsMap = new HashMap<>();
        mParamsMap.put("name", "ssdf");
        mParamsMap.put("password", "asdfaaaaaaaaa");
        Flowable<String> flowable = iLoginServiceApi.login(mParamsMap);
        HRetrofitNetHelper.getInstance(context).flowableSubscribe(flowable,mICallBackListener);
    }
}
