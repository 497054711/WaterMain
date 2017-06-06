package com.cn.android.mvp.regist.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cn.android.R;
import com.cn.android.databinding.RegistBinding;
import com.cn.android.mvp.BaseFragment;
import com.cn.android.mvp.BaseFragmentActivity;
import com.cn.android.mvp.regist.present.RegistPresent;
import com.cn.android.nethelp.BaseCallBack;
import com.cn.android.nethelp.ICallBackListener;
import com.cn.android.nethelp.Params;
import com.cn.android.nethelp.retrofit.RetrofitBaseCallBack;

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
public class RegistActivity extends BaseFragment implements IRegistView {
    private RegistPresent registPresent;
    private RegistBinding registBinding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        registBinding= DataBindingUtil.inflate(inflater, R.layout.regist, container, false);
        return registBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        registPresent=new RegistPresent(this.getActivity(),this);
        registBinding.setRegistView(this);
    }

    @Override
    public void regist(View view) {
        Params params=new Params();
        Map<String,String> map=new HashMap<>();
        map.put("code",registBinding.etRegistCode.getText().toString());
        map.put("password",registBinding.etRegistPwd.getText().toString());
        map.put("phone",registBinding.etRegistPhone.getText().toString());
        params.setMapParams(map);
        registPresent.regist(params);
    }

    @Override
    public void sendNotice(View view) {
        Params params=new Params();
        Map<String,String> map=new HashMap<>();
        map.put("password",registBinding.etRegistPwd.getText().toString());
        map.put("phone",registBinding.etRegistPhone.getText().toString());
        params.setMapParams(map);
        registPresent.sendNotice(params);
    }

    @Override
    public void updateSendNotice(RetrofitBaseCallBack mRetrofitBaseCallBack) {

    }

    @Override
    public void toMain(RetrofitBaseCallBack mRetrofitBaseCallBack) {

    }
}
