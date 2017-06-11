package com.cn.android.mvp.login.model;

import com.cn.android.nethelp.ICallBackListener;
import com.cn.android.nethelp.Params;

/**
 * @name MVP
 * @class name：com.cn.android.mvp.demo.model
 * @class TODO
 * @anthor liaoshucai
 * @mail :liaoshucai@vjwealth.com
 * @time 2017/5/16 14:05
 */
public interface ILoginModel {
    public void login(ICallBackListener mICallBackListener,Params params);
}
