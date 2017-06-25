package com.cn.android.mvp;

import com.cn.android.nethelp.retrofit.RetrofitBaseCallBack;

/**
 * Created by Administrator on 2017/6/25.
 */

public interface IRecycleViewListener {
    public void getData(int page);
    public void clearData();
}
