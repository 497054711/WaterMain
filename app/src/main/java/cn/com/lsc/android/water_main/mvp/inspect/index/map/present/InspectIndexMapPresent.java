package cn.com.lsc.android.water_main.mvp.inspect.index.map.present;

import cn.com.lsc.android.water_main.mvp.inspect.index.map.view.IInspectIndexMapView;

/**
 * Created by Administrator on 2017/3/31.
 */

public class InspectIndexMapPresent implements IInspectIndexMapPresent {
    private IInspectIndexMapView iInspectIndexMapView;

    public InspectIndexMapPresent(IInspectIndexMapView iInspectIndexMapView) {
        this.iInspectIndexMapView = iInspectIndexMapView;
    }

    @Override
    public void changeMode() {
        iInspectIndexMapView.changeMode();
    }
}
