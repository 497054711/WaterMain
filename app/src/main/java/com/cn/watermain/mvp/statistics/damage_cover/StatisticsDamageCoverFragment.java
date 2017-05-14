package com.cn.watermain.mvp.statistics.damage_cover;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cn.watermain.R;
import com.cn.watermain.mvp.BaseFragment;
import com.cn.watermain.mvp.statistics.damage_cover.view.IStatisticsDamageCoverView;

/**
 * Created by Administrator on 2017/4/4.
 */

public class StatisticsDamageCoverFragment extends BaseFragment implements IStatisticsDamageCoverView {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.statistics_damage_cover,null);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        title.setText("窨井盖损坏率");
    }
}
