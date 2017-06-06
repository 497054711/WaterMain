package com.cn.android.mvp.login.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cn.android.R;
import com.cn.android.mvp.BaseFragment;
import com.cn.android.mvp.BaseFragmentActivity;
import com.cn.android.mvp.login.present.LoginPresent;

/**
 * @name MVP
 * @class name：com.cn.android.mvp.demo.view
 * @class TODO
 * @anthor liaoshucai
 * @mail :liaoshucai@vjwealth.com
 * @time 2017/5/16 14:07
 */
public class LoginActivity extends BaseFragment implements ILoginView {
    private LoginPresent loginPresent;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.login, null);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        loginPresent=new LoginPresent(this.getActivity(),this);
    }

    @Override
    public void login(View view) {

    }
}
