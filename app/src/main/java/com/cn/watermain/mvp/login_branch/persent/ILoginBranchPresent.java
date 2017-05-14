package com.cn.watermain.mvp.login_branch.persent;

import com.cn.watermain.mvp.BaseBean;
import com.cn.watermain.mvp.IOnDataListener;
import com.cn.watermain.mvp.login_branch.model.LoginBranchModel;
import com.cn.watermain.mvp.login_branch.view.ILoginBranchView;

/**
 * Created by Administrator on 2017/3/19.
 */

public class ILoginBranchPresent {
    private ILoginBranchView iLoginBranchView;
    private LoginBranchModel loginBranchModel;

    public ILoginBranchPresent(ILoginBranchView iLoginBranchView) {
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
