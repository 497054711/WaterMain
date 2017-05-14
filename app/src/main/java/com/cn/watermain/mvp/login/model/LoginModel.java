package com.cn.watermain.mvp.login.model;

import com.cn.watermain.mvp.BaseBean;
import com.cn.watermain.mvp.IOnDataListener;

/**
 * Created by Administrator on 2017/3/19.
 */

public class LoginModel implements ILoginModel {
    private IOnDataListener iOnDataListener;

    public LoginModel(IOnDataListener iOnDataListener) {
        this.iOnDataListener = iOnDataListener;
    }

    @Override
    public void login() {
        iOnDataListener.onSuccess(new BaseBean());
    }
}
