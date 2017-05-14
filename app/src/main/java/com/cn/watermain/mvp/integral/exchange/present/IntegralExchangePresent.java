package com.cn.watermain.mvp.integral.exchange.present;

import com.cn.watermain.mvp.integral.exchange.view.IIntegralExchangeView;

/**
 * Created by Administrator on 2017/3/24.
 */

public class IntegralExchangePresent implements IIntegralExchangePresent {
    private IIntegralExchangeView iIntegralExchangeView;

    public IntegralExchangePresent(IIntegralExchangeView iIntegralExchangeView) {
        this.iIntegralExchangeView=iIntegralExchangeView;
    }

    public void exchange(){
        iIntegralExchangeView.exchange();
    }
}
