package com.cn.watermain.mvp.task.map.integrate.present;

import com.cn.watermain.mvp.task.map.integrate.view.ITaskMapIntegrateView;

/**
 * Created by Administrator on 2017/3/31.
 */

public class TaskMapIntegratePresent implements ITaskMapIntegratePresent {
    private ITaskMapIntegrateView iTaskMapIntegrateView;

    public TaskMapIntegratePresent(ITaskMapIntegrateView iTaskMapIntegrateView) {
        this.iTaskMapIntegrateView = iTaskMapIntegrateView;
    }

    @Override
    public void changeMode() {
        iTaskMapIntegrateView.changeMode();
    }
}
