package cn.com.lsc.android.water_main.mvp.statistics.index;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import butterknife.BindView;
import cn.com.lsc.android.water_main.R;
import cn.com.lsc.android.water_main.mvp.BaseDisplayActivity;
import cn.com.lsc.android.water_main.mvp.BaseFragment;
import cn.com.lsc.android.water_main.mvp.statistics.damage_cover.StatisticsDamageCoverFragment;
import cn.com.lsc.android.water_main.mvp.statistics.damage_integrate.StatisticsDamageIntegrateFragment;
import cn.com.lsc.android.water_main.mvp.statistics.index.present.StatisticsIndexPresent;
import cn.com.lsc.android.water_main.mvp.statistics.index.view.IStatisticsIndexView;

/**
 * Created by Administrator on 2017/4/4.
 * 统计
 */

public class StatisticsIndexFragment extends BaseFragment implements IStatisticsIndexView, View.OnClickListener {
    @BindView(R.id.lv_damage_cover)
    LinearLayout lvDamageCover;
    @BindView(R.id.lv_damage_integrate)
    LinearLayout lvDamageIntegrate;
    private StatisticsIndexPresent statisticsIndexPresent;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.statistics_index, null);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        lvDamageCover.setOnClickListener(this);
        lvDamageIntegrate.setOnClickListener(this);
        statisticsIndexPresent=new StatisticsIndexPresent(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.lv_damage_cover:
                statisticsIndexPresent.damageCover();
                break;
            case R.id.lv_damage_integrate:
                statisticsIndexPresent.damageIntegrate();
                break;
        }
    }

    @Override
    public void damageCover() {
        Intent intent = new Intent(StatisticsIndexFragment.this.getActivity(), BaseDisplayActivity.class);
        intent.putExtra("class", StatisticsDamageCoverFragment.class);
        startActivity(intent);
    }

    @Override
    public void damageIntegrate() {
        Intent intent = new Intent(StatisticsIndexFragment.this.getActivity(), BaseDisplayActivity.class);
        intent.putExtra("class", StatisticsDamageIntegrateFragment.class);
        startActivity(intent);
    }
}
