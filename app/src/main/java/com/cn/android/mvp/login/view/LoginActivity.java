package com.cn.android.mvp.login.view;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.cn.android.mvp.BaseFragmentActivity;
import com.cn.android.mvp.login.present.LoginPresent;

/**
 * @name MVP
 * @class name：com.cn.android.mvp.demo.view
 * @class TODO
 * @anthor liaoshucai
 * @mail :liaoshucai@vjwealth.com
 * @time 2017/5/16 14:07
 */
public class LoginActivity extends BaseFragmentActivity implements ILoginView {
    private LoginPresent loginPresent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginPresent=new LoginPresent(this,this);
    }
}
