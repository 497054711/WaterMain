package com.cn.android.mvp.demo.present;

import android.content.Context;

import com.cn.android.mvp.demo.model.DemoModel;
import com.cn.android.mvp.demo.model.IDemoModel;
import com.cn.android.mvp.demo.view.IDemoView;
import com.cn.android.nethelp.ICallBackListener;

/**
 * @name MVP
 * @class name：com.cn.android.mvp.demo.present
 * @class TODO
 * @anthor liaoshucai
 * @mail :liaoshucai@vjwealth.com
 * @time 2017/5/16 14:08
 */
public class DemoPresent implements IDemoPresent {
    private IDemoView  iDemoView;
    private IDemoModel iDemoModel;
    public DemoPresent(Context context, IDemoView iDemoView) {
        this.iDemoView=iDemoView;
        iDemoModel=new DemoModel(context);
    }

    @Override
    public void getDemo(ICallBackListener mICallBackListener) {
        iDemoModel.getDeomo(mICallBackListener);
    }
}
