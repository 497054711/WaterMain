package com.cn.android.mvp.task.map.pipe.present;

import com.cn.android.mvp.task.map.pipe.view.ITaskMapPipeView;

/**
 * Created by Administrator on 2017/3/31.
 */

public class TaskMapPipePresent implements ITaskMapPipePresent {
    private ITaskMapPipeView iTaskMapPipeView;

    public TaskMapPipePresent(ITaskMapPipeView iTaskMapPipeView) {
        this.iTaskMapPipeView=iTaskMapPipeView;
    }

    @Override
    public void changeMode() {
        iTaskMapPipeView.changeMode();
    }
}
