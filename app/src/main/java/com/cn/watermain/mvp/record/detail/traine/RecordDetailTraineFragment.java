package com.cn.watermain.mvp.record.detail.traine;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cn.watermain.R;
import com.cn.watermain.mvp.BaseFragment;
import com.cn.watermain.mvp.record.detail.traine.view.ITraineView;

/**
 * @name WaterMain
 * @class name：com.cn.watermain.mvp.record.detail.traine
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

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        title.setText("报告详情");
    }
}
