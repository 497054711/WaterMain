package cn.com.lsc.android.water_main.mvp.statistics.index.present;

import cn.com.lsc.android.water_main.mvp.statistics.index.view.IStatisticsIndexView;

/**
 * Created by Administrator on 2017/3/31.
 */

public class StatisticsIndexPresent implements IStatisticsIndexPresent {

    private IStatisticsIndexView iStatisticsIndexView;
    public StatisticsIndexPresent(IStatisticsIndexView iStatisticsIndexView) {
        this.iStatisticsIndexView=iStatisticsIndexView;
    }

    @Override
    public void damageCover() {
        iStatisticsIndexView.damageCover();
    }

    @Override
    public void damageIntegrate() {
        iStatisticsIndexView.damageIntegrate();
    }
}
