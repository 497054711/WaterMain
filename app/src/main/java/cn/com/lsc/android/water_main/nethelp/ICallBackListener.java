package cn.com.lsc.android.water_main.nethelp;


import com.cn.iflower.mvp.nethelp.retrofit.RetrofitBaseCallBack;

/**
 * Author:zcmain on 2016/5/13 13:39
 * E-Mail:zcmain@163.com
 * 说明：回调监听接口
 */
public interface ICallBackListener {

    public void onSuccess(RetrofitBaseCallBack mRetrofitBaseCallBack);
    public void onFaild(RetrofitBaseCallBack mRetrofitBaseCallBack);

}
