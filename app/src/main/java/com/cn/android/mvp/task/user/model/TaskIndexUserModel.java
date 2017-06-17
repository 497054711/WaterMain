package com.cn.android.mvp.task.user.model;

import android.content.Context;

import com.cn.android.mvp.task.user.model.biz.TaskIndexUserResult;
import com.cn.android.mvp.task.user.service_api.IIndexTaskUserServiceApi;
import com.cn.android.nethelp.ICallBackListener;
import com.cn.android.nethelp.Params;
import com.cn.android.nethelp.retrofit.HRetrofitNetHelper;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/3/20.
 */

public class TaskIndexUserModel implements ITaskIndexUserModel {
    private Context context;

    public TaskIndexUserModel(Context context) {
        this.context=context;
    }

    @Override
    public void task(ICallBackListener mICallBackListener, Params params) {
        IIndexTaskUserServiceApi iLoginServiceApi = HRetrofitNetHelper.getInstance(context).getAPIService(IIndexTaskUserServiceApi.class);
        Flowable<TaskIndexUserResult> flowable = iLoginServiceApi.getTask(params.getMapParams());
        flowable.subscribeOn(Schedulers.io())// Subscriber前面执行的代码都是在I/O线程中运行
                .onBackpressureBuffer()
                .observeOn(AndroidSchedulers.mainThread())// 操作observeOn之后操作主线程中运行.
                .subscribe(HRetrofitNetHelper.getInstance(context).createSubcribe(mICallBackListener));
    }
}
