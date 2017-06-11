package com.cn.android.mvp.login.present;

import android.content.Context;

import com.cn.android.mvp.login.model.LoginModel;
import com.cn.android.mvp.login.model.ILoginModel;
import com.cn.android.mvp.login.view.ILoginView;
import com.cn.android.nethelp.ICallBackListener;
import com.cn.android.nethelp.Params;
import com.cn.android.nethelp.retrofit.RetrofitBaseCallBack;

/**
 * @name MVP
 * @class name：com.cn.android.mvp.demo.present
 * @class TODO
 * @anthor liaoshucai
 * @mail :liaoshucai@vjwealth.com
 * @time 2017/5/16 14:08
 */
public class LoginPresent implements ILoginPresent {
    private ILoginView iLoginView;
    private ILoginModel iLoginModel;
    public LoginPresent(Context context, ILoginView iLoginView) {
        this.iLoginView = iLoginView;
        iLoginModel =new LoginModel(context);
    }

    @Override
    public void login(Params params) {
        iLoginView.baseLoadingShow();
        iLoginModel.login(new ICallBackListener() {
            @Override
            public void onSuccess(RetrofitBaseCallBack mRetrofitBaseCallBack) {
                iLoginView.baseLoadingDismiss();
            }

            @Override
            public void onFaild(RetrofitBaseCallBack mRetrofitBaseCallBack) {
                iLoginView.baseLoadingDismiss();
            }
        },params);
    }
}
