package com.cn.watermain.mvp.login.persent;

import com.cn.watermain.mvp.BaseBean;
import com.cn.watermain.mvp.IOnDataListener;
import com.cn.watermain.mvp.login.model.LoginModel;
import com.cn.watermain.mvp.login.view.ILoginView;

/**
 * Created by Administrator on 2017/3/19.
 */

public class LoginPresent implements ILoginPresent{
    private ILoginView iLoginView;
    private LoginModel loginModel;

    public LoginPresent(ILoginView iLoginView) {
        this.iLoginView = iLoginView;
    }

    @Override
    public void toLogin() {
        loginModel =new LoginModel(new IOnDataListener() {

            @Override
            public void onSuccess(BaseBean baseBean) {
                iLoginView.toLogin(baseBean);
            }

            @Override
            public void onFailed() {

            }
        });
        loginModel.login();
    }

    @Override
    public void toRegist() {
        iLoginView.toRegist();
    }
}
