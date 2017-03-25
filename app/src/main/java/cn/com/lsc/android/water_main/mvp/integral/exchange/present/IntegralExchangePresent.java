package cn.com.lsc.android.water_main.mvp.integral.exchange.present;

import cn.com.lsc.android.water_main.mvp.integral.exchange.view.IIntegralExchangeView;
import cn.com.lsc.android.water_main.mvp.integral.index.present.IIntegralIndexPresent;

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
