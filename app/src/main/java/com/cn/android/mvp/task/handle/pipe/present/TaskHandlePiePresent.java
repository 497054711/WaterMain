package com.cn.android.mvp.task.handle.pipe.present;

import com.cn.android.mvp.task.handle.pipe.view.ITaskHandlePipeView;

/**
 * Created by Administrator on 2017/3/25.
 */

public class TaskHandlePiePresent implements ITaskHandlePiePresent {
    private ITaskHandlePipeView iTaskDetailView;
    public TaskHandlePiePresent(ITaskHandlePipeView iTaskDetailView) {
        this.iTaskDetailView=iTaskDetailView;
    }

}
