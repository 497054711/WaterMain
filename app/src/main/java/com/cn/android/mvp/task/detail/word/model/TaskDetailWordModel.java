package com.cn.android.mvp.task.detail.word.model;

import android.content.Context;

import com.cn.android.mvp.task.detail.word.model.biz.TaskDetailWordResult;
import com.cn.android.mvp.task.detail.word.service_api.ITaskDetailWordServiceApi;
import com.cn.android.nethelp.ICallBackListener;
import com.cn.android.nethelp.Params;
import com.cn.android.nethelp.retrofit.HRetrofitNetHelper;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/3/20.
 */

public class TaskDetailWordModel implements ITaskDetailWordModel {
    private Context context;

    public TaskDetailWordModel(Context context) {
        this.context=context;
    }

    @Override
    public void task(ICallBackListener mICallBackListener, Params params) {
        ITaskDetailWordServiceApi iLoginServiceApi = HRetrofitNetHelper.getInstance(context).getAPIService(ITaskDetailWordServiceApi.class);
        Flowable<TaskDetailWordResult> flowable = iLoginServiceApi.getTaskDetail(params.getMapParams());
        flowable.subscribeOn(Schedulers.io())// Subscriber前面执行的代码都是在I/O线程中运行
                .onBackpressureBuffer()
                .observeOn(AndroidSchedulers.mainThread())// 操作observeOn之后操作主线程中运行.
                .subscribe(HRetrofitNetHelper.getInstance(context).createSubcribe(mICallBackListener));
    }
}
