package com.cn.android.mvp.task.index.model;

import android.content.Context;

import com.cn.android.mvp.task.index.model.biz.TaskIndexBannerResult;
import com.cn.android.mvp.task.index.model.biz.TaskIndexTaskResult;
import com.cn.android.mvp.task.index.service_api.IIndexTaskServiceApi;
import com.cn.android.nethelp.ICallBackListener;
import com.cn.android.nethelp.Params;
import com.cn.android.nethelp.retrofit.HRetrofitNetHelper;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/3/20.
 */

public class IndexModel implements IIndexModel {
    private Context context;

    public IndexModel(Context context) {
        this.context=context;
    }
    @Override
    public void banner(ICallBackListener mICallBackListener, Params params) {
        IIndexTaskServiceApi iLoginServiceApi = HRetrofitNetHelper.getInstance(context).getAPIService(IIndexTaskServiceApi.class);
        Flowable<TaskIndexBannerResult> flowable = iLoginServiceApi.getBanner(params.getMapParams());
        flowable.subscribeOn(Schedulers.io())// Subscriber前面执行的代码都是在I/O线程中运行
                .onBackpressureBuffer()
                .observeOn(AndroidSchedulers.mainThread())// 操作observeOn之后操作主线程中运行.
                .subscribe(HRetrofitNetHelper.getInstance(context).createSubcribe(mICallBackListener));
    }

    @Override
    public void task(ICallBackListener mICallBackListener, Params params) {
        IIndexTaskServiceApi iLoginServiceApi = HRetrofitNetHelper.getInstance(context).getAPIService(IIndexTaskServiceApi.class);
        Flowable<TaskIndexTaskResult> flowable = iLoginServiceApi.getTask(params.getMapParams());
        flowable.subscribeOn(Schedulers.io())// Subscriber前面执行的代码都是在I/O线程中运行
                .onBackpressureBuffer()
                .observeOn(AndroidSchedulers.mainThread())// 操作observeOn之后操作主线程中运行.
                .subscribe(HRetrofitNetHelper.getInstance(context).createSubcribe(mICallBackListener));
    }
}
