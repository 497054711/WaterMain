package com.cn.watermain.mvp.inspect.detail.pipe.present;

import com.cn.watermain.mvp.inspect.detail.pipe.view.IInspectDetailPipeView;

/**
 * Created by Administrator on 2017/3/25.
 */

public class InspectDetailPipePresent implements IInspectDetailPipePresent {
    private IInspectDetailPipeView iTaskDetailView;
    public InspectDetailPipePresent(IInspectDetailPipeView iTaskDetailView) {
        this.iTaskDetailView=iTaskDetailView;
    }

}
