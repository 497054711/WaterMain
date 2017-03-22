package cn.com.lsc.android.water_main.mvp.login_branch;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.RelativeLayout;

import cn.com.lsc.android.water_main.R;
import cn.com.lsc.android.water_main.mvp.BaseBean;
import cn.com.lsc.android.water_main.mvp.BaseFragmentActivity;
import cn.com.lsc.android.water_main.mvp.GuaidActivity;
import cn.com.lsc.android.water_main.mvp.admin.MainAdminActivity;
import cn.com.lsc.android.water_main.mvp.login_branch.view.ILoginBranchView;
import cn.com.lsc.android.water_main.mvp.login_branch.persent.PLoginBranch;
import cn.com.lsc.android.water_main.mvp.user.MainActivity;
import cn.com.lsc.android.water_main.db.GuaidDb;

/**
 * Created by Administrator on 2017/3/11.
 */

public class LoginBranchActivity extends BaseFragmentActivity implements ILoginBranchView {
    private RelativeLayout rv_index1,rv_index2,rv_index3;
    private PLoginBranch pLoginBranch;
    private Intent intent;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(GuaidDb.isShowGuaid(this)){
            Intent intent=new Intent(this,GuaidActivity.class);
            startActivity(intent);
        }
        pLoginBranch =new PLoginBranch(this);
        this.setContentView(R.layout.index);
        rv_index1= (RelativeLayout) this.findViewById(R.id.rv_index1);
        rv_index2= (RelativeLayout) this.findViewById(R.id.rv_index2);
        rv_index1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//用户
                pLoginBranch.loginUser();
            }
        });
        rv_index2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//管理员
                pLoginBranch.loginAdmin();
            }
        });
    }

    @Override
    public void loginUser(BaseBean baseBean) {
        intent=new Intent(LoginBranchActivity.this,MainActivity.class);
        intent.putExtra("type",0);
        startActivity(intent);
        finish();
    }

    @Override
    public void loginAdmin(BaseBean baseBean) {
        intent=new Intent(LoginBranchActivity.this,MainAdminActivity.class);
        intent.putExtra("type",1);
        startActivity(intent);
        finish();
    }
}