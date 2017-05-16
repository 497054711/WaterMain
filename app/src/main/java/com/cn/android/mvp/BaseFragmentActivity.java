package com.cn.android.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

/**
 * Created by Administrator on 2017/3/11.
 */

public class BaseFragmentActivity extends FragmentActivity implements IBaseView{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WaterMainApplication.getInstance().addActivityToStack(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        WaterMainApplication.getInstance().removeActivityFromStack(this);
    }

    @Override
    public void loadingShow() {

    }

    @Override
    public void loadingDismiss() {

    }
}
