package cn.com.lsc.android.water_main.mvp.login_branch.persent;

import cn.com.lsc.android.water_main.mvp.BaseBean;
import cn.com.lsc.android.water_main.mvp.IOnDataListener;
import cn.com.lsc.android.water_main.mvp.login_branch.model.LoginBranchModel;
import cn.com.lsc.android.water_main.mvp.login_branch.view.ILoginBranchView;

/**
 * Created by Administrator on 2017/3/19.
 */

public class PLoginBranch {
    private ILoginBranchView iLoginBranchView;
    private LoginBranchModel loginBranchModel;

    public PLoginBranch(ILoginBranchView iLoginBranchView) {
        this.iLoginBranchView = iLoginBranchView;
    }

    public void loginUser(){
        loginBranchModel =new LoginBranchModel(new IOnDataListener() {

            @Override
            public void onSuccess(BaseBean baseBean) {
                iLoginBranchView.loginUser(baseBean);
            }

            @Override
            public void onFailed() {

            }
        });
        loginBranchModel.loginUser();
    }
    public void loginAdmin(){
        loginBranchModel =new LoginBranchModel(new IOnDataListener() {

            @Override
            public void onSuccess(BaseBean baseBean) {
                iLoginBranchView.loginAdmin(baseBean);
            }

            @Override
            public void onFailed() {

            }
        });
        loginBranchModel.loginAdmin();
    }
}
