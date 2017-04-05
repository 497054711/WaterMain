package cn.com.lsc.android.water_main.mvp.admin;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import cn.com.lsc.android.water_main.R;
import cn.com.lsc.android.water_main.mvp.BaseFragmentActivity;
import cn.com.lsc.android.water_main.mvp.WaterMainApplication;
import cn.com.lsc.android.water_main.adapter.CommonFragmentPagerAdapter;
import cn.com.lsc.android.water_main.mvp.fault.index.FaultIndexFragment;
import cn.com.lsc.android.water_main.mvp.inspect.index.road.InspectIndexFragment;
import cn.com.lsc.android.water_main.mvp.message.index.MessageIndexFragment;
import cn.com.lsc.android.water_main.mvp.statistics.index.StatisticsIndexFragment;
import cn.com.lsc.android.water_main.widget.ForbiddenScrollViewPager;

public class MainAdminActivity extends BaseFragmentActivity {

    private ForbiddenScrollViewPager main_vp;
    private RadioGroup radiogGroup;
    private InspectIndexFragment main1;
    private FaultIndexFragment main2;
    private MessageIndexFragment main3;
    private StatisticsIndexFragment main4;
    private List<Fragment> listFragments;
    private CommonFragmentPagerAdapter commonFragmentPagerAdapter;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_admin);
        main_vp = (ForbiddenScrollViewPager) this.findViewById(R.id.main_vp);
        main_vp.setNoScroll(true);
        radiogGroup = (RadioGroup) this.findViewById(R.id.radiogGroup);

        main1 = new InspectIndexFragment();
        bundle = new Bundle();
        main1.setArguments(bundle);

        main2 = new FaultIndexFragment();
        bundle = new Bundle();
        main2.setArguments(bundle);

        main3 = new MessageIndexFragment();
        bundle = new Bundle();
        main3.setArguments(bundle);

        main4 = new StatisticsIndexFragment();
        bundle = new Bundle();
        main4.setArguments(bundle);

        listFragments = new ArrayList<Fragment>();
        listFragments.add(main1);
        listFragments.add(main2);
        listFragments.add(main3);
        listFragments.add(main4);
        commonFragmentPagerAdapter = new CommonFragmentPagerAdapter(getSupportFragmentManager(), listFragments);
        main_vp.setAdapter(commonFragmentPagerAdapter);
        main_vp.setOffscreenPageLimit(4);

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
                }
            }
        });
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
