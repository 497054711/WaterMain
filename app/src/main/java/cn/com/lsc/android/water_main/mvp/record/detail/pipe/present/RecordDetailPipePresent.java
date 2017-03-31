package cn.com.lsc.android.water_main.mvp.record.detail.pipe.present;

import cn.com.lsc.android.water_main.mvp.record.detail.pipe.view.IRecordDetailPipeView;

/**
 * Created by Administrator on 2017/3/31.
 */

public class RecordDetailPipePresent implements IRecordDetailPipePresent{
    private IRecordDetailPipeView iRecordDetailPipeView;
    public RecordDetailPipePresent(IRecordDetailPipeView iRecordDetailPipeView) {
        this.iRecordDetailPipeView=iRecordDetailPipeView;
    }
}
