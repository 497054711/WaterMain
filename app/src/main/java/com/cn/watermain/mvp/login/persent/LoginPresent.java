package com.cn.watermain.mvp.login.persent;

import android.content.Context;

import com.cn.watermain.db.LoginInfoDB;
import com.cn.watermain.mvp.BaseBean;
import com.cn.watermain.mvp.login.model.LoginModel;
import com.cn.watermain.mvp.login.view.ILoginView;
import com.cn.watermain.nethelp.BaseCallBack;
import com.cn.watermain.nethelp.ICallBackListener;

/**
 * Created by Administrator on 2017/3/19.
 */

public class LoginPresent implements ILoginPresent{
    private ILoginView iLoginView;
    private LoginModel loginModel;
    private Context context;

    public LoginPresent(Context context,ILoginView iLoginView) {
        this.iLoginView = iLoginView;
        this.context=context;
    }

    @Override
    public void toLogin() {
        iLoginView.loadingShow();
        loginModel=new LoginModel(context);
        loginModel.login(new ICallBackListener() {
            @Override
            public void onSuccess(BaseCallBack mBaseCallBack) {
                LoginInfoDB.writeLoginInfo(context,"123");
                iLoginView.toLogin(mBaseCallBack);
                iLoginView.loadingDismiss();
            }

            @Override
            public void onFaild(BaseCallBack mBaseCallBack) {
                iLoginView.loadingDismiss();
            }
        });
    }

    @Override
    public void toRegist() {
        iLoginView.toRegist();
    }
}
