package com.cn.android.mvp.task.detail.word.model.biz;

import com.cn.android.nethelp.retrofit.RetrofitBaseCallBack;

/**
 * Created by Administrator on 2017/6/10.
 */

public class TaskDetailWordResult extends RetrofitBaseCallBack {
    private TaskDetailWordData data;

    public TaskDetailWordData getData() {
        return data;
    }

    public void setData(TaskDetailWordData data) {
        this.data = data;
    }
}
