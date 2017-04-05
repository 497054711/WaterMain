package cn.com.lsc.android.water_main.mvp.fault.detail.cover;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.com.lsc.android.water_main.R;
import cn.com.lsc.android.water_main.mvp.BaseFragment;
import cn.com.lsc.android.water_main.mvp.fault.detail.cover.view.IFaultDetailCoverView;

/**
 * @name WaterMain
 * @class name：cn.com.lsc.android.water_main.mvp.fault.detail.cover
 * @class TODO
 * @anthor liaoshucai
 * @mail :liaoshucai@vjwealth.com
 * @time 2017/4/5 15:11
 */
public class FaultDetailCoverFragment extends BaseFragment implements IFaultDetailCoverView {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fault_detail_cover,null);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        title.setText("故障 82991");
    }
}
