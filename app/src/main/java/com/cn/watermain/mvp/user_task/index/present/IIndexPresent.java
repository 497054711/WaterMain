package com.cn.watermain.mvp.user_task.index.present;

import com.cn.watermain.mvp.user_task.index.model.IndexModel;
import com.cn.watermain.mvp.user_task.index.view.IIndexView;

/**
 * Created by Administrator on 2017/3/20.
 */

public class IIndexPresent {
    private IIndexView iIndexView;
    private IndexModel indexModel;
    public IIndexPresent(IIndexView iIndexView) {
        this.iIndexView=iIndexView;
    }
    public void toIntegral(){
        iIndexView.toIntegral();
    }
    public void toSetting(){
        iIndexView.toSetting();
    }
}