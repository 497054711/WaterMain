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
import cn.com.lsc.android.water_main.widget.ForbiddenScrollViewPager;

public class MainActivity extends BaseFragmentActivity implements WebViewFragment.CallBackInterface, AnimationPushBotton.AnimationEndCallBack {

    private ForbiddenScrollViewPager main_vp;
    private RadioGroup radiogGroup;
    private WebViewFragment main1, main2, main3, main4, main5;
    private List<Fragment> listFragments;
    private CommonFragmentPagerAdapter commonFragmentPagerAdapter;
    private Bundle bundle;
    private AnimationPushBotton animationPushBotton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        animationPushBotton = new AnimationPushBotton(this);
        animationPushBotton.setAnimationEndCallBack(this);
        main_vp = (ForbiddenScrollViewPager) this.findViewById(R.id.main_vp);
        main_vp.setNoScroll(true);
        radiogGroup = (RadioGroup) this.findViewById(R.id.radiogGroup);

        main1 = new WebViewFragment();
        bundle = new Bundle();
        bundle.putString("url", "file:///android_asset/task/user-task-index.html");
        main1.setArguments(bundle);
        main1.setCallBackInterface(this);

        main2 = new WebViewFragment();
        bundle = new Bundle();
        bundle.putString("url", "file:///android_asset/task/task-index.html");
        main2.setArguments(bundle);
        main2.setCallBackInterface(this);

        main3 = new WebViewFragment();
        bundle = new Bundle();
        bundle.putString("url", "file:///android_asset/report/report-index.html");
        main3.setArguments(bundle);
        main3.setCallBackInterface(this);

        main4 = new WebViewFragment();
        bundle = new Bundle();
        bundle.putString("url", "file:///android_asset/record/record-index.html");
        main4.setArguments(bundle);
        main4.setCallBackInterface(this);

        main5 = new WebViewFragment();
        bundle = new Bundle();
        bundle.putString("url", "file:///android_asset/integral/integral-index.html");
        main5.setArguments(bundle);
        main5.setCallBackInterface(this);

        listFragments = new ArrayList<Fragment>();
        listFragments.add(main1);
        listFragments.add(main2);
        listFragments.add(main3);
        listFragments.add(main4);
        listFragments.add(main5);
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
            if (main_vp.getCurrentItem() == 0) {
                if ((!radiogGroup.isShown())&&main1.getMain_wb().canGoBack()) {
                    main1.getMain_wb().goBack();
                } else {
                    finish();
                    android.os.Process.killProcess(android.os.Process.myPid());
                }
            } else if (main_vp.getCurrentItem() == 1) {
                if ((!radiogGroup.isShown())&&main2.getMain_wb().canGoBack()) {
                    main2.getMain_wb().goBack();
                } else {
                    main_vp.setCurrentItem(0);
                }
            } else if (main_vp.getCurrentItem() == 2) {
                if ((!radiogGroup.isShown())&&main3.getMain_wb().canGoBack()) {
                    main3.getMain_wb().goBack();
                } else {
                    main_vp.setCurrentItem(0);
                }
            } else if (main_vp.getCurrentItem() == 3) {
                if ((!radiogGroup.isShown())&&main4.getMain_wb().canGoBack()) {
                    main4.getMain_wb().goBack();
                } else {
                    main_vp.setCurrentItem(0);
                }
            } else if (main_vp.getCurrentItem() == 4) {
                if ((!radiogGroup.isShown())&&main5.getMain_wb().canGoBack()) {
                    main5.getMain_wb().goBack();
                } else {
                    main_vp.setCurrentItem(0);
                }
            }
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void webStartCallBack(String url) {
        if (url.contains("/task/user-task-index.html") || url.contains("/task/task-index.html") || url.contains("/report/report-index.html")
                || url.contains("/record/record-index.html") || url.contains("/integral/integral-index.html")) {
            animationPushBotton.startAnimationIn(radiogGroup);
        } else {
            animationPushBotton.startAnimationOUT(radiogGroup);
        }
    }

    @Override
    public void animationInEndcallBack() {
        Log.i("animationInEndcallBack", "visible===");
        radiogGroup.setVisibility(View.VISIBLE);
    }

    @Override
    public void animationOutEndcallBack() {
        Log.i("animationInEndcallBack", "gone===");
        radiogGroup.setVisibility(View.GONE);
    }
}
