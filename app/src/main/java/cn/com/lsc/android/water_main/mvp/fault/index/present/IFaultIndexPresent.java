package cn.com.lsc.android.water_main.mvp.fault.index.present;

import cn.com.lsc.android.water_main.mvp.fault.index.model.FaultIndexModel;
import cn.com.lsc.android.water_main.mvp.fault.index.view.IFaultIndexView;

/**
 * Created by Administrator on 2017/3/20.
 */

public class IFaultIndexPresent {
    private IFaultIndexView iFaultIndexView;
    private FaultIndexModel indexModel;
    public IFaultIndexPresent(IFaultIndexView iFaultIndexView) {
        this.iFaultIndexView = iFaultIndexView;
    }
    public void toIntegral(){
        iFaultIndexView.toIntegral();
    }
    public void toSetting(){
        iFaultIndexView.toSetting();
    }
}
