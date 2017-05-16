package com.cn.android.mvp.inspect.detail.pipe_grab_single.present;

import com.cn.android.mvp.inspect.detail.pipe_grab_single.view.IInspectDetailPipeGrabSingleView;

/**
 * Created by Administrator on 2017/3/25.
 */

public class InspectDetailPipeGrabSinglePresent implements IInspectDetailPipeGrabSinglePresent {
    private IInspectDetailPipeGrabSingleView iTaskDetailView;
    public InspectDetailPipeGrabSinglePresent(IInspectDetailPipeGrabSingleView iTaskDetailView) {
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
