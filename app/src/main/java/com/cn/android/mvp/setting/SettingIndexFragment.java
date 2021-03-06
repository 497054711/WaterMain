package com.cn.android.mvp.setting;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.cn.android.R;
import com.cn.android.mvp.BaseFragment;
import com.cn.android.mvp.WaterMainApplication;
import com.cn.android.mvp.login_regist.LoginRegistActivity;
import com.cn.android.mvp.setting.index.present.SettingIndexPresent;
import com.cn.android.mvp.setting.index.view.ISettingIndexView;
import com.cn.android.widget.MyAlertDialog;

/**
 * Created by Administrator on 2017/3/25.
 */

public class SettingIndexFragment extends BaseFragment implements ISettingIndexView {

    @BindView(R.id.settingIndext_logout)
    TextView settingIndextLogout;
    Unbinder unbinder;

    private SettingIndexPresent settingIndexPresent;
    private MyAlertDialog myAlertDialog;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.setting_index, null);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        title.setText("设置");
        settingIndexPresent=new SettingIndexPresent(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.settingIndext_logout)
    public void toLogout() {
        settingIndexPresent.logout();
    }

    @Override
    public void logout() {
        myAlertDialog = new MyAlertDialog(SettingIndexFragment.this.getActivity());
        myAlertDialog.setMsg("您确定退出登录吗？");
        myAlertDialog.setConfirmBtEnable(true);
        myAlertDialog.setNegativeBtEnable(true);
        myAlertDialog.setClickInterface(new MyAlertDialog.ClickInterface() {
            @Override
            public void clickSure() {
                myAlertDialog.dismiss();
                Intent intent=new Intent(SettingIndexFragment.this.getActivity(), LoginRegistActivity.class);
                startActivity(intent);
                WaterMainApplication.getInstance().exitsApp();
            }

            @Override
            public void clickCancel() {
                myAlertDialog.dismiss();
            }
        });
        myAlertDialog.show();

    }
}
