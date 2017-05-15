package com.cn.watermain.mvp.login.model;

import com.cn.watermain.nethelp.ICallBackListener;

/**
 * Created by Administrator on 2017/3/19.
 */

public interface ILoginModel {
    public void login(ICallBackListener mICallBackListener);//获取登录网络数据
}
