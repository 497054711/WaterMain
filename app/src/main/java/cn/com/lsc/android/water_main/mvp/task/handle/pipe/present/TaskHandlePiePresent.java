package cn.com.lsc.android.water_main.mvp.task.handle.pipe.present;

import cn.com.lsc.android.water_main.mvp.task.handle.pipe.view.ITaskHandlePipeView;

/**
 * Created by Administrator on 2017/3/25.
 */

public class TaskHandlePiePresent implements ITaskHandlePiePresent {
    private ITaskHandlePipeView iTaskDetailView;
    public TaskHandlePiePresent(ITaskHandlePipeView iTaskDetailView) {
        this.iTaskDetailView=iTaskDetailView;
    }

}
