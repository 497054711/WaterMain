package cn.com.lsc.android.water_main.mvp.inspect.index.present;

import cn.com.lsc.android.water_main.mvp.inspect.index.model.InspectIndexModel;
import cn.com.lsc.android.water_main.mvp.inspect.index.view.IInspectIndexView;

/**
 * Created by Administrator on 2017/3/20.
 */

public class IInspecIndexPresent {
    private IInspectIndexView iInspectIndexView;
    private InspectIndexModel indexModel;
    public IInspecIndexPresent(IInspectIndexView iInspectIndexView) {
        this.iInspectIndexView = iInspectIndexView;
    }
    public void toIntegral(){
        iInspectIndexView.toIntegral();
    }
    public void toSetting(){
        iInspectIndexView.toSetting();
    }
}
