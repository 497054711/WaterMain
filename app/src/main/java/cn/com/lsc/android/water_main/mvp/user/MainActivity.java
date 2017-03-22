package cn.com.lsc.android.water_main.mvp.user;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import cn.com.lsc.android.water_main.R;

import java.util.ArrayList;
import java.util.List;

import cn.com.lsc.android.water_main.mvp.BaseFragmentActivity;
import cn.com.lsc.android.water_main.mvp.WebViewFragment;
import cn.com.lsc.android.water_main.adapter.CommonFragmentPagerAdapter;
import cn.com.lsc.android.water_main.animation.AnimationPushBotton;
import cn.com.lsc.android.water_main.mvp.index.IndexFragment;
import cn.com.lsc.android.water_main.widget.ForbiddenScrollViewPager;

public class MainActivity extends BaseFragmentActivity {

    private ForbiddenScrollViewPager main_vp;
    private RadioGroup radiogGroup;
    private List<Fragment> listFragments;
    private CommonFragmentPagerAdapter commonFragmentPagerAdapter;
    private Bundle bundle;
    private AnimationPushBotton animationPushBotton;
    private IndexFragment indexFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        animationPushBotton = new AnimationPushBotton(this);
        main_vp = (ForbiddenScrollViewPager) this.findViewById(R.id.main_vp);
        main_vp.setNoScroll(true);
        radiogGroup = (RadioGroup) this.findViewById(R.id.radiogGroup);

        indexFragment=new IndexFragment();

        listFragments = new ArrayList<Fragment>();
        listFragments.add(indexFragment);

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
        main_vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                switch (position) {
                    case 0:
                        ((RadioButton) (radiogGroup.getChildAt(0))).setChecked(true);
                        break;
                    case 1:
                        ((RadioButton) (radiogGroup.getChildAt(1))).setChecked(true);
                        break;
                    case 2:
                        ((RadioButton) (radiogGroup.getChildAt(2))).setChecked(true);
                        break;
                    case 3:
                        ((RadioButton) (radiogGroup.getChildAt(3))).setChecked(true);
                        break;
                    case 4:
                        ((RadioButton) (radiogGroup.getChildAt(4))).setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if (keyCode == KeyEvent.KEYCODE_BACK) {

            return false;
        }
        return super.onKeyDown(keyCode, event);
    }
}
