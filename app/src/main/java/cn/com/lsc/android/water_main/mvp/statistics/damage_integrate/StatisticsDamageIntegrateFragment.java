package cn.com.lsc.android.water_main.mvp.statistics.damage_integrate;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.com.lsc.android.water_main.R;
import cn.com.lsc.android.water_main.mvp.BaseFragment;
import cn.com.lsc.android.water_main.mvp.statistics.damage_integrate.view.IStatisticsDamageIntegrateView;

/**
 * Created by Administrator on 2017/4/4.
 */

public class StatisticsDamageIntegrateFragment extends BaseFragment implements IStatisticsDamageIntegrateView {
    
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.statistics_damage_integrate,null);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
}
