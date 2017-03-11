package cn.com.lsc.android.water_main.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.RelativeLayout;

import cn.com.lsc.android.water_main.R;
import cn.com.lsc.android.water_main.db.GuaidDb;

/**
 * Created by Administrator on 2017/3/11.
 */

public class IndexActivity extends BaseFragmentActivity {
    private RelativeLayout rv_index1,rv_index2,rv_index3;
    private Intent intent;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(GuaidDb.isShowGuaid(this)){
            Intent intent=new Intent(this,GuaidActivity.class);
            startActivity(intent);
        }
        this.setContentView(R.layout.index);
        rv_index1= (RelativeLayout) this.findViewById(R.id.rv_index1);
        rv_index2= (RelativeLayout) this.findViewById(R.id.rv_index2);
        rv_index3= (RelativeLayout) this.findViewById(R.id.rv_index3);
        rv_index1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//用户
                intent=new Intent(IndexActivity.this,MainActivity.class);
                intent.putExtra("type",0);
                startActivity(intent);
                finish();
            }
        });
        rv_index2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//管理员
                intent=new Intent(IndexActivity.this,MainAdminActivity.class);
                intent.putExtra("type",1);
                startActivity(intent);
                finish();
            }
        });
        rv_index3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//超管
                intent=new Intent(IndexActivity.this,MainSuperAdminActivity.class);
                intent.putExtra("type",2);
                startActivity(intent);
                finish();
            }
        });
    }
}
