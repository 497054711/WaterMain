package cn.com.lsc.android.water_main.mvp.record.detail.traine;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.com.lsc.android.water_main.R;
import cn.com.lsc.android.water_main.mvp.BaseFragment;
import cn.com.lsc.android.water_main.mvp.record.detail.traine.view.ITraineView;

/**
 * @name WaterMain
 * @class name：cn.com.lsc.android.water_main.mvp.record.detail.traine
 * @class TODO
 * @anthor liaoshucai
 * @mail :liaoshucai@vjwealth.com
 * @time 2017/4/2 18:49
 */
public class RecordDetailTraineFragment extends BaseFragment implements ITraineView {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.record_detail_traine,null);
    }
}
