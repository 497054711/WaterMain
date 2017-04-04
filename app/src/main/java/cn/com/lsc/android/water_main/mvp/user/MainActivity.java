package cn.com.lsc.android.water_main.mvp.user;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.com.lsc.android.water_main.R;
import cn.com.lsc.android.water_main.adapter.CommonFragmentPagerAdapter;
import cn.com.lsc.android.water_main.mvp.BaseFragmentActivity;
import cn.com.lsc.android.water_main.mvp.WaterMainApplication;
import cn.com.lsc.android.water_main.mvp.integral.index.IntegralIndexFragment;
import cn.com.lsc.android.water_main.mvp.record.index.RecordIndexFragment;
import cn.com.lsc.android.water_main.mvp.report.ReportIndexFragment;
import cn.com.lsc.android.water_main.mvp.task.index.TaskIndexFragment;
import cn.com.lsc.android.water_main.mvp.user_task.index.IndexFragment;
import cn.com.lsc.android.water_main.widget.ForbiddenScrollViewPager;

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
        listFragments.add(reportIndexFragment);
        listFragments.add(recordIndexFragment);
        listFragments.add(integralIndexFragment);

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
