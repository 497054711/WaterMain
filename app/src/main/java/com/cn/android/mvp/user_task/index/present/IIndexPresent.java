package com.cn.android.mvp.user_task.index.present;

import com.cn.android.mvp.user_task.index.model.IndexModel;
import com.cn.android.mvp.user_task.index.view.IIndexView;
import com.cn.android.nethelp.Params;

/**
 * Created by Administrator on 2017/3/20.
 */

public interface IIndexPresent {
    public void banner(Params params);
    public void task(Params params);
}
