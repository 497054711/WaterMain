package cn.com.lsc.android.water_main.mvp.statistics.damage_cover;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.com.lsc.android.water_main.R;
import cn.com.lsc.android.water_main.mvp.BaseFragment;
import cn.com.lsc.android.water_main.mvp.statistics.damage_cover.view.IStatisticsDamageCoverView;

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
