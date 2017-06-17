package com.cn.android.mvp.task.user.present;

import android.content.Context;

import com.cn.android.mvp.task.user.model.TaskIndexUserModel;
import com.cn.android.mvp.task.user.view.ITaskIndexUserView;
import com.cn.android.nethelp.ICallBackListener;
import com.cn.android.nethelp.Params;
import com.cn.android.nethelp.retrofit.RetrofitBaseCallBack;

/**
 * Created by Administrator on 2017/3/20.
 */

public class TaskIndexUserPresent implements ITaskIndexUserPresent{
    private ITaskIndexUserView iTaskIndexUserView;
    private TaskIndexUserModel taskIndexUserModel;
    private Context context;
    public TaskIndexUserPresent(Context context, ITaskIndexUserView iTaskIndexUserView) {
        this.iTaskIndexUserView=iTaskIndexUserView;
        this.context=context;
        taskIndexUserModel=new TaskIndexUserModel(context);
    }

    @Override
    public void task(Params params) {
        taskIndexUserModel.task(new ICallBackListener() {
            @Override
            public void onSuccess(RetrofitBaseCallBack mRetrofitBaseCallBack) {
                iTaskIndexUserView.upDateTask(mRetrofitBaseCallBack);
            }

            @Override
            public void onFaild(RetrofitBaseCallBack mRetrofitBaseCallBack) {
                iTaskIndexUserView.upDateTask(mRetrofitBaseCallBack);
            }
        },params);
    }
}
