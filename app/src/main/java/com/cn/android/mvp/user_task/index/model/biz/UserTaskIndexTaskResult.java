package com.cn.android.mvp.user_task.index.model.biz;

import com.cn.android.nethelp.retrofit.RetrofitBaseCallBack;

/**
 * Created by Administrator on 2017/6/10.
 */

public class UserTaskIndexTaskResult extends RetrofitBaseCallBack {
    private UserTaskIndexTaskData data;

    public UserTaskIndexTaskData getData() {
        return data;
    }

    public void setData(UserTaskIndexTaskData data) {
        this.data = data;
    }
}
