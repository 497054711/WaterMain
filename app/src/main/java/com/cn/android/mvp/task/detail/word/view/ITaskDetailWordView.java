package com.cn.android.mvp.task.detail.word.view;

import com.cn.android.nethelp.retrofit.RetrofitBaseCallBack;

/**
 * Created by Administrator on 2017/3/22.
 */

public interface ITaskDetailWordView {
    public void task();//任务列表
    public void onRefresh();//刷新
    public void onLoadMore();//下一页
    public void initXrvMessageEmpty();
    public void initXrvMessage();
    public void upDateTask(RetrofitBaseCallBack mRetrofitBaseCallBack);
}
