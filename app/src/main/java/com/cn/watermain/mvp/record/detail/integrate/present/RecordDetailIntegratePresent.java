package com.cn.watermain.mvp.record.detail.integrate.present;

import com.cn.watermain.mvp.record.detail.integrate.view.IRecordDetailIntegrateView;

/**
 * Created by Administrator on 2017/3/25.
 */

public class RecordDetailIntegratePresent implements IRecordDetailIntegratePresent {
    private IRecordDetailIntegrateView iTaskDetailView;
    public RecordDetailIntegratePresent(IRecordDetailIntegrateView iTaskDetailView) {
        this.iTaskDetailView=iTaskDetailView;
    }

    @Override
    public void toGrabSingle() {
        iTaskDetailView.grabSingle();
    }
}
