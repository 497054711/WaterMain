package com.cn.android.mvp.task.user.model.biz;

import com.cn.android.nethelp.retrofit.RetrofitBaseCallBack;

/**
 * Created by Administrator on 2017/6/10.
 */

public class TaskIndexUserResult extends RetrofitBaseCallBack {
    private TaskIndexUserData data;

    public TaskIndexUserData getData() {
        return data;
    }

    public void setData(TaskIndexUserData data) {
        this.data = data;
    }
}
