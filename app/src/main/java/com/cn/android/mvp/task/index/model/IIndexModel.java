package com.cn.android.mvp.task.index.model;

import com.cn.android.nethelp.ICallBackListener;
import com.cn.android.nethelp.Params;

/**
 * Created by Administrator on 2017/3/20.
 */

public interface IIndexModel {
    public void banner(ICallBackListener mICallBackListener, Params params);
    public void task(ICallBackListener mICallBackListener, Params params);
}
