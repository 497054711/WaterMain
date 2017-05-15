package com.cn.watermain.mvp.login.view;

import com.cn.watermain.mvp.IBaseView;
import com.cn.watermain.nethelp.BaseCallBack;

/**
 * Created by Administrator on 2017/3/19.
 * index接口
 */

public interface ILoginView extends IBaseView{
    public void toLogin(BaseCallBack mBaseCallBack);//用户登录
    public void toRegist();//用户注册
}
