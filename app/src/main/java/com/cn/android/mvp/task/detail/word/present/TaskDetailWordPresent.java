package com.cn.android.mvp.task.detail.word.present;

import android.content.Context;

import com.cn.android.mvp.task.detail.word.model.TaskDetailWordModel;
import com.cn.android.mvp.task.detail.word.view.ITaskDetailWordView;
import com.cn.android.nethelp.ICallBackListener;
import com.cn.android.nethelp.Params;
import com.cn.android.nethelp.retrofit.RetrofitBaseCallBack;

/**
 * Created by Administrator on 2017/3/20.
 */

public class TaskDetailWordPresent implements ITaskDetailWordPresent {
    private ITaskDetailWordView iTaskDetailWordView;
    private TaskDetailWordModel taskIndexUserModel;
    private Context context;
    public TaskDetailWordPresent(Context context, ITaskDetailWordView iTaskDetailWordView) {
        this.iTaskDetailWordView = iTaskDetailWordView;
        this.context=context;
        taskIndexUserModel=new TaskDetailWordModel(context);
    }

    @Override
    public void task(Params params) {
        taskIndexUserModel.task(new ICallBackListener() {
            @Override
            public void onSuccess(RetrofitBaseCallBack mRetrofitBaseCallBack) {
                iTaskDetailWordView.upDateTask(mRetrofitBaseCallBack);
            }

            @Override
            public void onFaild(RetrofitBaseCallBack mRetrofitBaseCallBack) {
                iTaskDetailWordView.upDateTask(mRetrofitBaseCallBack);
            }
        },params);
    }
}
