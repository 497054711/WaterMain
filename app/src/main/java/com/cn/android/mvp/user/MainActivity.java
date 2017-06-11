package com.cn.android.mvp.user;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.cn.android.R;
import com.cn.android.adapter.CommonFragmentPagerAdapter;
import com.cn.android.db.GuaidDb;
import com.cn.android.db.LoginInfoDB;
import com.cn.android.mvp.BaseDisplayActivity;
import com.cn.android.mvp.BaseFragmentActivity;
import com.cn.android.mvp.GuaidActivity;
import com.cn.android.mvp.WaterMainApplication;
import com.cn.android.mvp.integral.index.IntegralIndexFragment;
import com.cn.android.mvp.login_regist.LoginRegistActivity;
import com.cn.android.mvp.record.index.RecordIndexFragment;
import com.cn.android.mvp.report.ReportIndexFragment;
import com.cn.android.mvp.task.index.TaskIndexFragment;
import com.cn.android.mvp.user_task.index.IndexFragment;
import com.cn.android.widget.ForbiddenScrollViewPager;

public class MainActivity extends BaseFragmentActivity {

    @BindView(R.id.main_vp)
    ForbiddenScrollViewPager main_vp;
    @BindView(R.id.radiogGroup)
    RadioGroup radiogGroup;

    private List<Fragment> listFragments;
    private CommonFragmentPagerAdapter commonFragmentPagerAdapter;
    private IndexFragment indexFragment;
    private TaskIndexFragment taskIndexFragment;
    private IntegralIndexFragment integralIndexFragment;
    private RecordIndexFragment recordIndexFragment;
    private ReportIndexFragment reportIndexFragment;
    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (GuaidDb.isShowGuaid(this)) {
//            Intent intent = new Intent(this, GuaidActivity.class);
//            startActivity(intent);
//        }else{
//            if(!LoginInfoDB.isLogin(this)){
//                Intent intent = new Intent(this, BaseDisplayActivity.class);
//                intent.putExtra("class", LoginRegistActivity.class);
//                startActivity(intent);
//            }
//        }

        setContentView(R.layout.main);
        unbinder= ButterKnife.bind(this);
        main_vp.setNoScroll(true);
        indexFragment = new IndexFragment();
        taskIndexFragment = new TaskIndexFragment();
        integralIndexFragment = new IntegralIndexFragment();
        recordIndexFragment = new RecordIndexFragment();
        reportIndexFragment = new ReportIndexFragment();

        listFragments = new ArrayList<Fragment>();
        listFragments.add(indexFragment);
        listFragments.add(taskIndexFragment);
        listFragments.add(recordIndexFragment);
        listFragments.add(integralIndexFragment);
        listFragments.add(reportIndexFragment);

        commonFragmentPagerAdapter = new CommonFragmentPagerAdapter(getSupportFragmentManager(), listFragments);
        main_vp.setAdapter(commonFragmentPagerAdapter);
        main_vp.setOffscreenPageLimit(5);

        radiogGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rb_main1:
                        main_vp.setCurrentItem(0);
                        break;
                    case R.id.rb_main2:
                        main_vp.setCurrentItem(1);
                        break;
                    case R.id.rb_main3:
                        main_vp.setCurrentItem(2);
                        break;
                    case R.id.rb_main4:
                        main_vp.setCurrentItem(3);
                        break;
                    case R.id.rb_main5:
                        main_vp.setCurrentItem(4);
                        break;

                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if(main_vp.getCurrentItem()==0){
                WaterMainApplication.getInstance().exitsApp();
                android.os.Process.killProcess(android.os.Process.myPid());
            }else{
                ((RadioButton)radiogGroup.getChildAt(0)).setChecked(true);
            }
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }
}
