package com.cn.android.mvp.user_task.index.model;

import android.content.Context;

import com.cn.android.mvp.login.model.biz.LoginResult;
import com.cn.android.mvp.login.service_api.ILoginServiceApi;
import com.cn.android.mvp.user_task.index.model.biz.UserTaskIndexBannerResult;
import com.cn.android.mvp.user_task.index.model.biz.UserTaskIndexTaskResult;
import com.cn.android.mvp.user_task.index.service_api.IUserIndexTaskServiceApi;
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
        IUserIndexTaskServiceApi iLoginServiceApi = HRetrofitNetHelper.getInstance(context).getAPIService(IUserIndexTaskServiceApi.class);
        Flowable<UserTaskIndexBannerResult> flowable = iLoginServiceApi.getBanner(params.getMapParams());
        flowable.subscribeOn(Schedulers.io())// Subscriber前面执行的代码都是在I/O线程中运行
                .onBackpressureBuffer()
                .observeOn(AndroidSchedulers.mainThread())// 操作observeOn之后操作主线程中运行.
                .subscribe(HRetrofitNetHelper.getInstance(context).createSubcribe(mICallBackListener));
    }

    @Override
    public void task(ICallBackListener mICallBackListener, Params params) {
        IUserIndexTaskServiceApi iLoginServiceApi = HRetrofitNetHelper.getInstance(context).getAPIService(IUserIndexTaskServiceApi.class);
        Flowable<UserTaskIndexTaskResult> flowable = iLoginServiceApi.getTask(params.getMapParams());
        flowable.subscribeOn(Schedulers.io())// Subscriber前面执行的代码都是在I/O线程中运行
                .onBackpressureBuffer()
                .observeOn(AndroidSchedulers.mainThread())// 操作observeOn之后操作主线程中运行.
                .subscribe(HRetrofitNetHelper.getInstance(context).createSubcribe(mICallBackListener));
    }
}
