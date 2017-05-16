package com.cn.android.mvp.login_regist;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cn.android.R;
import com.cn.android.databinding.LoginBinding;
import com.cn.android.mvp.BaseFragment;
import com.cn.android.mvp.login_regist.persent.LoginRegistPresent;
import com.cn.android.mvp.login_regist.view.ILoginRegistView;

/**
 * Created by Administrator on 2017/3/11.
 */

public class LoginRegistActivity extends BaseFragment implements ILoginRegistView, View.OnClickListener {
    private LoginRegistPresent loginPresent;
    private Intent intent;
    private LoginBinding loginBinding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         loginBinding=DataBindingUtil.inflate(inflater, R.layout.login_regist, container, false);
        return loginBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        loginPresent = new LoginRegistPresent(this.getActivity(),this);
        loginBinding.btLogin.setOnClickListener(this);
        loginBinding.btRegist.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_login:
                loginPresent.toLogin();
                break;
            case R.id.bt_regist:
                loginPresent.toRegist();
                break;
        }
    }


    @Override
    public void toLogin() {
        this.getActivity().finish();
    }

    @Override
    public void toRegist() {

    }

    @Override
    public void loadingShow() {

    }

    @Override
    public void loadingDismiss() {

    }
}
