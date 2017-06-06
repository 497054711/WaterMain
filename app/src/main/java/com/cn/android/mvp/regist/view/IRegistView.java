package com.cn.android.mvp.regist.view;


import android.view.View;

import com.cn.android.nethelp.retrofit.RetrofitBaseCallBack;

/**
 * @name MVP
 * @class name：com.cn.android.mvp.demo.view
 * @class TODO
 * @anthor liaoshucai
 * @mail :liaoshucai@vjwealth.com
 * @time 2017/5/16 14:06
 */
public interface IRegistView {
    public void regist(View view);
    public void sendNotice(View view);
    public void updateSendNotice(RetrofitBaseCallBack mRetrofitBaseCallBack);
    public void toMain(RetrofitBaseCallBack mRetrofitBaseCallBack);

}
