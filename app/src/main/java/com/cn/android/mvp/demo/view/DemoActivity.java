package com.cn.android.mvp.demo.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cn.android.R;
import com.cn.android.databinding.DemoBinding;
import com.cn.android.databinding.RegistBinding;
import com.cn.android.mvp.BaseFragment;
import com.cn.android.mvp.regist.present.RegistPresent;
import com.cn.android.mvp.regist.view.IRegistView;

/**
 * @name MVP
 * @class name：com.cn.android.mvp.demo.view
 * @class TODO
 * @anthor liaoshucai
 * @mail :liaoshucai@vjwealth.com
 * @time 2017/5/16 14:07
 */
public class DemoActivity extends BaseFragment implements IDemoView {
    private DemoBinding demoBinding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        demoBinding= DataBindingUtil.inflate(inflater, R.layout.demo, container, false);
        return demoBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
