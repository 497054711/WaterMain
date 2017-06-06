package com.cn.android.mvp.regist.present;

import android.content.Context;

import com.cn.android.mvp.regist.model.RegistModel;
import com.cn.android.mvp.regist.model.IRegistModel;
import com.cn.android.mvp.regist.view.IRegistView;
import com.cn.android.nethelp.ICallBackListener;
import com.cn.android.nethelp.Params;
import com.cn.android.nethelp.retrofit.RetrofitBaseCallBack;

/**
 * @name MVP
 * @class name：com.cn.android.mvp.demo.present
 * @class TODO
 * @anthor liaoshucai
 * @mail :liaoshucai@vjwealth.com
 * @time 2017/5/16 14:08
 */
public class RegistPresent implements IRegistPresent {
    private IRegistView iRegistView;
    private IRegistModel iRegistModel;
    public RegistPresent(Context context, IRegistView iRegistView) {
        this.iRegistView = iRegistView;
        iRegistModel =new RegistModel(context);
    }

    @Override
    public void regist(Params params) {
        iRegistModel.regist(new ICallBackListener() {
            @Override
            public void onSuccess(RetrofitBaseCallBack mRetrofitBaseCallBack) {
                iRegistView.toMain(mRetrofitBaseCallBack);
            }

            @Override
            public void onFaild(RetrofitBaseCallBack mRetrofitBaseCallBack) {
                iRegistView.toMain(mRetrofitBaseCallBack);
            }
        },params);
    }

    @Override
    public void sendNotice(Params params) {
        iRegistModel.sendNotice(new ICallBackListener() {
            @Override
            public void onSuccess(RetrofitBaseCallBack mRetrofitBaseCallBack) {
                iRegistView.updateSendNotice(mRetrofitBaseCallBack);
            }

            @Override
            public void onFaild(RetrofitBaseCallBack mRetrofitBaseCallBack) {
                iRegistView.updateSendNotice(mRetrofitBaseCallBack);
            }
        },params);
    }
}
