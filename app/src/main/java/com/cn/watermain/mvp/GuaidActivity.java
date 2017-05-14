package com.cn.watermain.mvp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;
import java.util.List;

import com.cn.watermain.R;
import com.cn.watermain.adapter.MyViewPagerAdapter;
import com.cn.watermain.db.GuaidDb;
import com.cn.watermain.utils.PixelTransform;

/**
 * Created by Administrator on 2017/3/11.
 */

public class GuaidActivity extends BaseFragmentActivity {

    //引导页相关
    private ViewPager guaid_vp;
    private LinearLayout lv_guaid;

    private View guaid_vp_item;
    private int[] guaid_item_icon = {R.mipmap.guaid1, R.mipmap.guaid2, R.mipmap.guaid3};
    private int[] guaid_item_bg = {Color.parseColor("#67c4ff"), Color.parseColor("#ea80fc"), Color.parseColor("#8f67fe")};
    private RelativeLayout lv_guaid_vp_item_bg;
    private MyViewPagerAdapter pagerAdapter;
    private List<View> pages;
    private ImageView image;
    private TextView tv_guaid_vp_item;
    private ImageView iv_guaid_vp_item_use;
    private int prevIndex=0;
    private Intent intent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.guaid);

        guaid_vp= (ViewPager) this.findViewById(R.id.guaid_vp);
        lv_guaid= (LinearLayout) this.findViewById(R.id.lv_guaid);

        pages = new ArrayList<View>();
        for (int i = 0; i < guaid_item_icon.length; i++) {
            ImageView iv_page_select=new ImageView(this);
            iv_page_select.setImageResource(R.mipmap.dot_normal);
            iv_page_select.setPadding(PixelTransform.dip2px(this,5),PixelTransform.dip2px(this,5),PixelTransform.dip2px(this,5),PixelTransform.dip2px(this,5));
            if(i==0){
                iv_page_select.setImageResource(R.mipmap.dot_selected);
            }
            lv_guaid.addView(iv_page_select);

            guaid_vp_item = LayoutInflater.from(this).inflate(R.layout.guaid_vp_item, null);
            image = (ImageView) guaid_vp_item.findViewById(R.id.iv_guaid_vp_item);
            tv_guaid_vp_item= (TextView) guaid_vp_item.findViewById(R.id.tv_guaid_vp_item);
            lv_guaid_vp_item_bg=(RelativeLayout) guaid_vp_item.findViewById(R.id.lv_guaid_vp_item_bg);
            Glide.with(this).load(guaid_item_icon[i]).diskCacheStrategy(DiskCacheStrategy.ALL).into(image);
            lv_guaid_vp_item_bg.setBackgroundColor(guaid_item_bg[i]);
            if(i==0){
                tv_guaid_vp_item.setText("全民查水管\n人人做环卫");
            }else if(i==1){
                tv_guaid_vp_item.setText("攒积分 得奖励");
            }if(i==2){
                tv_guaid_vp_item.setText("");
                iv_guaid_vp_item_use= (ImageView) guaid_vp_item.findViewById(R.id.iv_guaid_vp_item_use);
                iv_guaid_vp_item_use.setVisibility(View.VISIBLE);
                iv_guaid_vp_item_use.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        GuaidDb.setShowGuaid(GuaidActivity.this,false);
                        GuaidActivity.this.finish();
                    }
                });
            }
            pages.add(guaid_vp_item);
        }
        pagerAdapter = new MyViewPagerAdapter(pages);
        guaid_vp.setAdapter(pagerAdapter);
        guaid_vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int arg0) {
                // TODO Auto-generated method stub
                ((ImageView)(lv_guaid.getChildAt(arg0))).setImageResource(R.mipmap.dot_selected);
                ((ImageView)(lv_guaid.getChildAt(prevIndex))).setImageResource(R.mipmap.dot_normal);
                prevIndex=arg0;
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
                // TODO Auto-generated method stub

            }
        });

    }
}
