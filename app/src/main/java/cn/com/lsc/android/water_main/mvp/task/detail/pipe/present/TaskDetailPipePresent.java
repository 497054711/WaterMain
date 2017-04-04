package cn.com.lsc.android.water_main.mvp.task.detail.pipe.present;

import cn.com.lsc.android.water_main.mvp.task.detail.pipe.view.ITaskDetailPipeView;

/**
 * Created by Administrator on 2017/3/25.
 */

public class TaskDetailPipePresent implements ITaskDetailPipePresent {
    private ITaskDetailPipeView iTaskDetailView;
    public TaskDetailPipePresent(ITaskDetailPipeView iTaskDetailView) {
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
