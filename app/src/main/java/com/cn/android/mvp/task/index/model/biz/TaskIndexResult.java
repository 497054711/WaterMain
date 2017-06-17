package com.cn.android.mvp.task.index.model.biz;

import com.cn.android.nethelp.retrofit.RetrofitBaseCallBack;

/**
 * Created by Administrator on 2017/6/10.
 */

public class TaskIndexResult extends RetrofitBaseCallBack {
    private TaskIndexData data;

    public TaskIndexData getData() {
        return data;
    }

    public void setData(TaskIndexData data) {
        this.data = data;
    }
}
