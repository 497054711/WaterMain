package cn.com.lsc.android.water_main.mvp.setting.index.present;

import cn.com.lsc.android.water_main.mvp.setting.index.view.ISettingIndexView;

/**
 * Created by Administrator on 2017/3/25.
 */

public class SettingIndexPresent implements ISettingIndexPresent {

    private ISettingIndexView iSettingIndexView;

    public SettingIndexPresent(ISettingIndexView iSettingIndexView) {
        this.iSettingIndexView=iSettingIndexView;
    }

    @Override
    public void logout() {
        iSettingIndexView.logout();
    }
}
