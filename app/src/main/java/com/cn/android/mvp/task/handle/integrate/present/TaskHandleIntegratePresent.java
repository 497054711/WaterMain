package com.cn.android.mvp.task.handle.integrate.present;

import com.cn.android.mvp.task.handle.integrate.view.ITaskHandleIntegrateView;

/**
 * Created by Administrator on 2017/3/25.
 */

public class TaskHandleIntegratePresent implements ITaskHandleIntegratePresent {
    private ITaskHandleIntegrateView iTaskDetailView;
    public TaskHandleIntegratePresent(ITaskHandleIntegrateView iTaskDetailView) {
        this.iTaskDetailView=iTaskDetailView;
    }

}
