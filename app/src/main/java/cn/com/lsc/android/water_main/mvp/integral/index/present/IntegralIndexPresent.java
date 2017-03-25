package cn.com.lsc.android.water_main.mvp.integral.index.present;

import cn.com.lsc.android.water_main.mvp.integral.index.biz.IntegralIndexBean;
import cn.com.lsc.android.water_main.mvp.integral.index.view.IIntegralIndexView;

/**
 * Created by Administrator on 2017/3/24.
 */

public class IntegralIndexPresent implements IIntegralIndexPresent {
    private IIntegralIndexView iIntegralIndexView;

    public IntegralIndexPresent(IIntegralIndexView iIntegralIndexView) {
        this.iIntegralIndexView = iIntegralIndexView;
    }

    @Override
    public void exchange(IntegralIndexBean integralIndexBean) {
        iIntegralIndexView.goToExchange(integralIndexBean);
    }
}
