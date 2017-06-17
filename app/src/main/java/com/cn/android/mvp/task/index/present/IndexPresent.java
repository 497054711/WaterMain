package com.cn.android.mvp.task.index.present;

import android.content.Context;

import com.cn.android.mvp.task.index.model.IndexModel;
import com.cn.android.mvp.task.index.view.IIndexView;
import com.cn.android.nethelp.ICallBackListener;
import com.cn.android.nethelp.Params;
import com.cn.android.nethelp.retrofit.RetrofitBaseCallBack;

/**
 * Created by Administrator on 2017/3/20.
 */

public class IndexPresent implements IIndexPresent{
    private IIndexView iIndexView;
    private IndexModel indexModel;
    private Context context;
    public IndexPresent(Context context, IIndexView iIndexView) {
        this.iIndexView=iIndexView;
        this.context=context;
        indexModel=new IndexModel(context);
    }

    @Override
    public void banner(Params params) {
        indexModel.banner(new ICallBackListener() {
            @Override
            public void onSuccess(RetrofitBaseCallBack mRetrofitBaseCallBack) {
                iIndexView.upDateBanner(mRetrofitBaseCallBack);
            }

            @Override
            public void onFaild(RetrofitBaseCallBack mRetrofitBaseCallBack) {
                iIndexView.upDateBanner(mRetrofitBaseCallBack);
            }
        },params);
    }

    @Override
    public void task(Params params) {
        indexModel.task(new ICallBackListener() {
            @Override
            public void onSuccess(RetrofitBaseCallBack mRetrofitBaseCallBack) {
                iIndexView.upDateTask(mRetrofitBaseCallBack);
            }

            @Override
            public void onFaild(RetrofitBaseCallBack mRetrofitBaseCallBack) {
                iIndexView.upDateTask(mRetrofitBaseCallBack);
            }
        },params);
    }
}
