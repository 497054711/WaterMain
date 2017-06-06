package com.cn.android.mvp.login_regist.model;

import android.content.Context;

import com.cn.android.mvp.login_regist.service_api.ILoginRegistServiceApi;
import com.cn.android.nethelp.ICallBackListener;
import com.cn.android.nethelp.retrofit.HRetrofitNetHelper;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Flowable;

/**
 * Created by Administrator on 2017/3/19.
 */

public class LoginRegistModel implements ILoginRegistModel {
    private Context context;

    public LoginRegistModel(Context context) {
        this.context=context;
    }

    @Override
    public void login(ICallBackListener mICallBackListener) {

    }
}
