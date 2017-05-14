package com.cn.watermain.mvp.integral.index.present;

import com.cn.watermain.mvp.integral.index.biz.IntegralIndexBean;
import com.cn.watermain.mvp.integral.index.view.IIntegralIndexView;

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
