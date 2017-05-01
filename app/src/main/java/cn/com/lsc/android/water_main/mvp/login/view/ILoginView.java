package cn.com.lsc.android.water_main.mvp.login.view;

import cn.com.lsc.android.water_main.mvp.BaseBean;

/**
 * Created by Administrator on 2017/3/19.
 * index接口
 */

public interface ILoginView {
    public void toLogin(BaseBean baseBean);//用户登录
    public void toRegist();//用户注册
}
