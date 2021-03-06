package com.cn.android.mvp.task.detail.integrate.present;

import com.cn.android.mvp.task.detail.integrate.view.ITaskDetailIntegrateView;

/**
 * Created by Administrator on 2017/3/25.
 */

public class TaskDetailIntegratePresent implements ITaskDetailIntegratePresent {
    private ITaskDetailIntegrateView iTaskDetailView;
    public TaskDetailIntegratePresent(ITaskDetailIntegrateView iTaskDetailView) {
        this.iTaskDetailView=iTaskDetailView;
    }

    @Override
    public void toGrabSingle() {
        iTaskDetailView.grabSingle();
    }

    @Override
    public void changeMode() {
        iTaskDetailView.changeMode();
    }
}
