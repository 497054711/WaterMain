package com.cn.android.mvp.task.index.view;

import com.cn.android.nethelp.retrofit.RetrofitBaseCallBack;

/**
 * Created by Administrator on 2017/3/20.
 */

public interface IIndexView {
    public void banner();//banner
    public void task();//任务列表
    public void upDateTask(RetrofitBaseCallBack mRetrofitBaseCallBack);
    public void upDateBanner(RetrofitBaseCallBack mRetrofitBaseCallBack);
}
