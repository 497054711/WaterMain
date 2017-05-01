package cn.com.lsc.android.water_main.mvp.login.model;

import cn.com.lsc.android.water_main.mvp.BaseBean;
import cn.com.lsc.android.water_main.mvp.IOnDataListener;

/**
 * Created by Administrator on 2017/3/19.
 */

public class LoginModel implements ILoginModel {
    private IOnDataListener iOnDataListener;

    public LoginModel(IOnDataListener iOnDataListener) {
        this.iOnDataListener = iOnDataListener;
    }

    @Override
    public void login() {
        iOnDataListener.onSuccess(new BaseBean());
    }
}
