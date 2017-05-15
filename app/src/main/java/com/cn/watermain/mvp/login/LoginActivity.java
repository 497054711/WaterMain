package com.cn.watermain.mvp.login;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cn.watermain.R;
import com.cn.watermain.databinding.LoginBinding;
import com.cn.watermain.db.GuaidDb;
import com.cn.watermain.mvp.BaseBean;
import com.cn.watermain.mvp.BaseFragment;
import com.cn.watermain.mvp.BaseFragmentActivity;
import com.cn.watermain.mvp.GuaidActivity;
import com.cn.watermain.mvp.login.persent.LoginPresent;
import com.cn.watermain.mvp.login.view.ILoginView;
import com.cn.watermain.mvp.user.MainActivity;
import com.cn.watermain.nethelp.BaseCallBack;

/**
 * Created by Administrator on 2017/3/11.
 */

public class LoginActivity extends BaseFragment implements ILoginView, View.OnClickListener {
    private LoginPresent loginPresent;
    private Intent intent;
    private LoginBinding loginBinding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         loginBinding=DataBindingUtil.inflate(inflater, R.layout.login, container, false);
        return loginBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        loginPresent = new LoginPresent(this.getActivity(),this);
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
    public void toLogin(BaseCallBack baseCallBack) {
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
