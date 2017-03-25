package cn.com.lsc.android.water_main.mvp.task.handle.integrate.present;

import cn.com.lsc.android.water_main.mvp.task.handle.integrate.view.ITaskHandleIntegrateView;

/**
 * Created by Administrator on 2017/3/25.
 */

public class TaskHandleIntegratePresent implements ITaskHandleIntegratePresent {
    private ITaskHandleIntegrateView iTaskDetailView;
    public TaskHandleIntegratePresent(ITaskHandleIntegrateView iTaskDetailView) {
        this.iTaskDetailView=iTaskDetailView;
    }

}
