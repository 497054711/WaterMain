package com.cn.android.mvp.login_regist;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cn.android.R;
import com.cn.android.databinding.LoginRegistBinding;
import com.cn.android.mvp.BaseDisplayActivity;
import com.cn.android.mvp.BaseFragment;
import com.cn.android.mvp.login.view.LoginActivity;
import com.cn.android.mvp.login_regist.persent.LoginRegistPresent;
import com.cn.android.mvp.login_regist.view.ILoginRegistView;
import com.cn.android.mvp.regist.view.RegistActivity;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/3/11.
 */

public class LoginRegistActivity extends BaseFragment implements ILoginRegistView {
    private LoginRegistPresent loginPresent;
    private Intent intent;
    private LoginRegistBinding loginRegistBinding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        loginRegistBinding=DataBindingUtil.inflate(inflater, R.layout.login_regist, container, false);
        return loginRegistBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        loginPresent = new LoginRegistPresent(this.getActivity(),this);
        loginRegistBinding.setLoginRegistView(this);
    }

    @Override
    public void toLogin(View view) {
        Intent intent = new Intent(this.getActivity(), BaseDisplayActivity.class);
        intent.putExtra("class", LoginActivity.class);
        startActivity(intent);
        this.getActivity().finish();
    }

    @Override
    public void toRegist(View view) {
        Intent intent = new Intent(this.getActivity(), BaseDisplayActivity.class);
        intent.putExtra("class", RegistActivity.class);
        startActivity(intent);
        this.getActivity().finish();
    }
}
