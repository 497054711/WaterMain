package com.cn.watermain.mvp.login_branch;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.cn.watermain.R;
import com.cn.watermain.db.GuaidDb;
import com.cn.watermain.mvp.BaseBean;
import com.cn.watermain.mvp.BaseFragmentActivity;
import com.cn.watermain.mvp.GuaidActivity;
import com.cn.watermain.mvp.admin.MainAdminActivity;
import com.cn.watermain.mvp.login_branch.persent.ILoginBranchPresent;
import com.cn.watermain.mvp.login_branch.view.ILoginBranchView;
import com.cn.watermain.mvp.user.MainActivity;

/**
 * Created by Administrator on 2017/3/11.
 */

public class LoginBranchActivity extends BaseFragmentActivity implements ILoginBranchView, View.OnClickListener {
    @BindView(R.id.rv_index1)
    RelativeLayout rvIndex1;
    @BindView(R.id.rv_index2)
    RelativeLayout rvIndex2;
    private ILoginBranchPresent iLoginBranchPresent;
    private Intent intent;
    private Unbinder unbinder;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (GuaidDb.isShowGuaid(this)) {
            Intent intent = new Intent(this, GuaidActivity.class);
            startActivity(intent);
        }
        iLoginBranchPresent = new ILoginBranchPresent(this);
        this.setContentView(R.layout.login_branch);
        unbinder=ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @Override
    public void loginUser(BaseBean baseBean) {
        intent = new Intent(LoginBranchActivity.this, MainActivity.class);
        intent.putExtra("type", 0);
        startActivity(intent);
        finish();
    }

    @Override
    public void loginAdmin(BaseBean baseBean) {
        intent = new Intent(LoginBranchActivity.this, MainAdminActivity.class);
        intent.putExtra("type", 1);
        startActivity(intent);
        finish();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rv_index1:
                iLoginBranchPresent.loginUser();
                break;
            case R.id.rv_index2:
                iLoginBranchPresent.loginAdmin();
                break;
        }
    }
}
