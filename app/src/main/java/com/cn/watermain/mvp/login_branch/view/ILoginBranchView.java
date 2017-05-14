package com.cn.watermain.mvp.login_branch.view;

import com.cn.watermain.mvp.BaseBean;

/**
 * Created by Administrator on 2017/3/19.
 * index接口
 */

public interface ILoginBranchView {
    public void loginUser(BaseBean baseBean);//用户登录
    public void loginAdmin(BaseBean baseBean);//管理员登录
}
