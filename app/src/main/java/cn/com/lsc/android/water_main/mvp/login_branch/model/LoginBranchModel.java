package cn.com.lsc.android.water_main.mvp.login_branch.model;

import cn.com.lsc.android.water_main.mvp.BaseBean;
import cn.com.lsc.android.water_main.mvp.IOnDataListener;

/**
 * Created by Administrator on 2017/3/19.
 */

public class LoginBranchModel implements ILoginBranchModel {
    private IOnDataListener iOnDataListener;

    public LoginBranchModel(IOnDataListener iOnDataListener) {
        this.iOnDataListener = iOnDataListener;
    }

    @Override
    public void loginUser() {
        iOnDataListener.onSuccess(new BaseBean());
    }

    @Override
    public void loginAdmin() {
        iOnDataListener.onSuccess(new BaseBean());
    }
}
