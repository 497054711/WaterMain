package com.cn.android.mvp.login_regist.persent;

import android.content.Context;

import com.cn.android.mvp.login_regist.model.LoginRegistModel;
import com.cn.android.mvp.login_regist.view.ILoginRegistView;

/**
 * Created by Administrator on 2017/3/19.
 */

public class LoginRegistPresent implements ILoginRegistPresent {
    private ILoginRegistView iLoginRegistView;
    private LoginRegistModel loginRegistModel;
    private Context context;

    public LoginRegistPresent(Context context, ILoginRegistView iLoginRegistView) {
        this.iLoginRegistView = iLoginRegistView;
        this.context=context;
    }

    @Override
    public void toLogin() {
        iLoginRegistView.toLogin();
    }

    @Override
    public void toRegist() {
        iLoginRegistView.toRegist();
    }
}
