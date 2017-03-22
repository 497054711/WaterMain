package cn.com.lsc.android.water_main.mvp.index.present;

import cn.com.lsc.android.water_main.mvp.index.model.IndexModel;
import cn.com.lsc.android.water_main.mvp.index.view.IIndexView;

/**
 * Created by Administrator on 2017/3/20.
 */

public class PIndex {
    private IIndexView iIndexView;
    private IndexModel indexModel;
    public PIndex(IIndexView iIndexView) {
        this.iIndexView=iIndexView;
    }
    public void toIntegral(){
        iIndexView.toIntegral();
    }
    public void toSetting(){
        iIndexView.toSetting();
    }
}
