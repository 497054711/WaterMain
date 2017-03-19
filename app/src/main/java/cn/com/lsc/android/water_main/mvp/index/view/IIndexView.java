package cn.com.lsc.android.water_main.mvp.index.view;

import cn.com.lsc.android.water_main.mvp.BaseBean;

/**
 * Created by Administrator on 2017/3/19.
 * index接口
 */

public interface IIndexView {
    public void loginUser(BaseBean baseBean);//用户登录
    public void loginAdmin(BaseBean baseBean);//管理员登录
}
