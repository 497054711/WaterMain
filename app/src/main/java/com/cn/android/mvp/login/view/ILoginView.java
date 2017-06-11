package com.cn.android.mvp.login.view;


import android.view.View;

import com.cn.android.mvp.IBaseLoadingView;

/**
 * @name MVP
 * @class name：com.cn.android.mvp.demo.view
 * @class TODO
 * @anthor liaoshucai
 * @mail :liaoshucai@vjwealth.com
 * @time 2017/5/16 14:06
 */
public interface ILoginView extends IBaseLoadingView {
    public void initView();
    public void login(View view);

}
