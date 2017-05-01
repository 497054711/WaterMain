package cn.com.lsc.android.water_main.mvp.login.persent;

import cn.com.lsc.android.water_main.mvp.BaseBean;
import cn.com.lsc.android.water_main.mvp.IOnDataListener;
import cn.com.lsc.android.water_main.mvp.login.model.LoginModel;
import cn.com.lsc.android.water_main.mvp.login.view.ILoginView;

/**
 * Created by Administrator on 2017/3/19.
 */

public class LoginPresent implements ILoginPresent{
    private ILoginView iLoginView;
    private LoginModel loginModel;

    public LoginPresent(ILoginView iLoginView) {
        this.iLoginView = iLoginView;
    }

    @Override
    public void toLogin() {
        loginModel =new LoginModel(new IOnDataListener() {

            @Override
            public void onSuccess(BaseBean baseBean) {
                iLoginView.toLogin(baseBean);
            }

            @Override
            public void onFailed() {

            }
        });
        loginModel.login();
    }

    @Override
    public void toRegist() {
        iLoginView.toRegist();
    }
}
