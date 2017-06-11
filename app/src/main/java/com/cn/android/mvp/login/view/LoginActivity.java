package com.cn.android.mvp.login.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cn.android.R;
import com.cn.android.databinding.LoginBinding;
import com.cn.android.mvp.BaseFragment;
import com.cn.android.mvp.BaseFragmentActivity;
import com.cn.android.mvp.WaterMainApplication;
import com.cn.android.mvp.login.present.LoginPresent;
import com.cn.android.nethelp.Params;
import com.cn.android.utils.RegexPatternUtil;
import com.cn.android.widget.ToastUtil;

import java.util.HashMap;
import java.util.Map;

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
        loginPresent=new LoginPresent(this.getActivity(),this);
        loginBinding.waterMainTitle.title.setText("登录");
        loginBinding.setILoginView(this);
        initView();
    }

    @Override
    public void initView() {
        loginBinding.etLoginPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(!loginBinding.etLoginPhone.getText().toString().trim().equals("")&&
                        !loginBinding.etLoginPassword.getText().toString().trim().equals("")){
                    loginBinding.btLogin.setEnabled(true);
                }else{
                    loginBinding.btLogin.setEnabled(false);
                }
            }
        });

        loginBinding.etLoginPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(!loginBinding.etLoginPhone.getText().toString().trim().equals("")&&
                        !loginBinding.etLoginPassword.getText().toString().trim().equals("")){
                    loginBinding.btLogin.setEnabled(true);
                }else{
                    loginBinding.btLogin.setEnabled(false);
                }
            }
        });
        loginBinding.waterMainTitle.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WaterMainApplication.getInstance().exitsApp();
            }
        });
    }

    @Override
    public void login(View view) {
        if(!RegexPatternUtil.isPhone(loginBinding.etLoginPhone.getText().toString().trim())){
            ToastUtil.showToast(this.getActivity(),"请输入正确的手机号!");
            return;
        }
        Params params=new Params();
        Map<String,String> map=new HashMap<>();
        map.put("password",loginBinding.etLoginPassword.getText().toString().trim());
        map.put("phone",loginBinding.etLoginPhone.getText().toString().trim());
        params.setMapParams(map);
        loginPresent.login(params);
    }

    @Override
    public void baseLoadingShow() {
        loadingShow();
    }

    @Override
    public void baseLoadingDismiss() {
        loadingDismiss();
    }
}
