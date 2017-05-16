package com.cn.android.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.cn.android.R;

/**
 * @name WaterMain
 * @class name：com.cn.watermain.mvp
 * @class TODO
 * @anthor liaoshucai
 * @mail :liaoshucai@vjwealth.com
 * @time 2017/3/20 17:17
 */
public class BaseDisplayActivity extends BaseFragmentActivity {
    private Fragment mFragment;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.base_dispaly);
        init();
    }
    private void init() {
        Class aClass = (Class) getIntent().getSerializableExtra("class");//获取Fragment类对象
        try {
            mFragment = (Fragment) aClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        Bundle bundle = getIntent().getExtras();//获取Bundle对象，并传递给Fragment
        if (bundle != null) {
            mFragment.setArguments(bundle);
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.dispaly_content, mFragment).commit();//替换Activity布局

    }
}
