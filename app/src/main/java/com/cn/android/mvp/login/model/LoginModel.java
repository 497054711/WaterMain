package com.cn.android.mvp.login.model;

import android.content.Context;

import com.cn.android.mvp.login.model.biz.LoginResult;
import com.cn.android.mvp.login.service_api.ILoginServiceApi;
import com.cn.android.mvp.regist.model.biz.RegistResult;
import com.cn.android.mvp.regist.service_api.IRegistServiceApi;
import com.cn.android.nethelp.ICallBackListener;
import com.cn.android.nethelp.Params;
import com.cn.android.nethelp.retrofit.HRetrofitNetHelper;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @name MVP
 * @class name：com.cn.android.mvp.demo.model
 * @class TODO
 * @anthor liaoshucai
 * @mail :liaoshucai@vjwealth.com
 * @time 2017/5/16 14:05
 */
public class LoginModel implements ILoginModel {

    private Context context;

    public LoginModel(Context context) {
        this.context=context;
    }

    @Override
    public void login(ICallBackListener mICallBackListener, Params params) {
        ILoginServiceApi iLoginServiceApi = HRetrofitNetHelper.getInstance(context).getAPIService(ILoginServiceApi.class);
        Flowable<LoginResult> flowable = iLoginServiceApi.login(params.getMapParams());
        flowable.subscribeOn(Schedulers.io())// Subscriber前面执行的代码都是在I/O线程中运行
                .onBackpressureBuffer()
                .observeOn(AndroidSchedulers.mainThread())// 操作observeOn之后操作主线程中运行.
                .subscribe(HRetrofitNetHelper.getInstance(context).createSubcribe(mICallBackListener));
    }
}
