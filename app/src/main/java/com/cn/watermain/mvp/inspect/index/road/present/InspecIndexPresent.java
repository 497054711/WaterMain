package com.cn.watermain.mvp.inspect.index.road.present;

import com.cn.watermain.mvp.inspect.index.road.model.InspectIndexModel;
import com.cn.watermain.mvp.inspect.index.road.view.IInspectIndexView;

/**
 * Created by Administrator on 2017/3/20.
 */

public class InspecIndexPresent implements IInspecIndexPresent{
    private IInspectIndexView iInspectIndexView;
    private InspectIndexModel indexModel;
    public InspecIndexPresent(IInspectIndexView iInspectIndexView) {
        this.iInspectIndexView = iInspectIndexView;
    }

    @Override
    public void changeMode() {
        iInspectIndexView.changeMode();
    }
}
