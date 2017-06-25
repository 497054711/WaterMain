package com.cn.android.mvp;

import com.cn.android.nethelp.retrofit.RetrofitBaseCallBack;

/**
 * Created by Administrator on 2017/6/25.
 */

public interface IListViewListener {
    public void clearData();
    public void upDateList(RetrofitBaseCallBack mRetrofitBaseCallBack);
    public void getData(int page);
}
