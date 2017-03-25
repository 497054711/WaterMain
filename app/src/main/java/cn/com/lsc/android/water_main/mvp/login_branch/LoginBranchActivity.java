package cn.com.lsc.android.water_main.mvp.login_branch;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.com.lsc.android.water_main.R;
import cn.com.lsc.android.water_main.db.GuaidDb;
import cn.com.lsc.android.water_main.mvp.BaseBean;
import cn.com.lsc.android.water_main.mvp.BaseFragmentActivity;
import cn.com.lsc.android.water_main.mvp.GuaidActivity;
import cn.com.lsc.android.water_main.mvp.admin.MainAdminActivity;
import cn.com.lsc.android.water_main.mvp.login_branch.persent.ILoginBranchPresent;
import cn.com.lsc.android.water_main.mvp.login_branch.view.ILoginBranchView;
import cn.com.lsc.android.water_main.mvp.user.MainActivity;

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
