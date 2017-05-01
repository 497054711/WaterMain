package cn.com.lsc.android.water_main.mvp.login;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.RelativeLayout;

import cn.com.lsc.android.water_main.R;
import cn.com.lsc.android.water_main.db.GuaidDb;
import cn.com.lsc.android.water_main.mvp.BaseBean;
import cn.com.lsc.android.water_main.mvp.BaseFragmentActivity;
import cn.com.lsc.android.water_main.mvp.GuaidActivity;
import cn.com.lsc.android.water_main.mvp.login.persent.LoginPresent;
import cn.com.lsc.android.water_main.mvp.login.view.ILoginView;
import cn.com.lsc.android.water_main.mvp.user.MainActivity;

/**
 * Created by Administrator on 2017/3/11.
 */

public class LoginActivity extends BaseFragmentActivity implements ILoginView, View.OnClickListener {
    private LoginPresent loginPresent;
    private Intent intent;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (GuaidDb.isShowGuaid(this)) {
            Intent intent = new Intent(this, GuaidActivity.class);
            startActivity(intent);
        }
        DataBindingUtil.setContentView(this, R.layout.login);
        loginPresent = new LoginPresent(this);
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
    public void toLogin(BaseBean baseBean) {
        intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void toRegist() {

    }
}
