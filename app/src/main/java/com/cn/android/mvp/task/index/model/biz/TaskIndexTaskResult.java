package com.cn.android.mvp.task.index.model.biz;

import com.cn.android.nethelp.retrofit.RetrofitBaseCallBack;

/**
 * Created by Administrator on 2017/6/10.
 */

public class TaskIndexTaskResult extends RetrofitBaseCallBack {
    private TaskIndexTaskData data;

    public TaskIndexTaskData getData() {
        return data;
    }

    public void setData(TaskIndexTaskData data) {
        this.data = data;
    }
}
