package com.cn.android.adapter;

import java.util.List;

import android.support.v4.view.PagerAdapter;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;

public class MyViewPagerAdapter extends PagerAdapter {

    private List<View> mListViews;
    private PagerOnItemClickListener pagerOnItemClickListener;

    public MyViewPagerAdapter(List<View> mListViews) {
        this.mListViews = mListViews;//构造方法，参数是我们的页卡，这样比较方便。
    }

    public PagerOnItemClickListener getPagerOnItemClickListener() {
        return pagerOnItemClickListener;
    }

    public void setPagerOnItemClickListener(
            PagerOnItemClickListener pagerOnItemClickListener) {
        this.pagerOnItemClickListener = pagerOnItemClickListener;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(mListViews.get(position));//删除页卡
    }


    @Override
    public Object instantiateItem(ViewGroup container, final int position) {    //这个方法用来实例化页卡
        container.addView(mListViews.get(position), 0);//添加页卡

        mListViews.get(position).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (pagerOnItemClickListener != null) {
                    pagerOnItemClickListener.onClick(position);
                }
            }
        });
        mListViews.get(position).setOnTouchListener(new OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub

                return false;
            }
        });

        return mListViews.get(position);
    }

    @Override
    public int getCount() {
        return mListViews.size();//返回页卡的数量
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == arg1;//官方提示这样写
    }

    /**
     * 条目点击接口.
     *
     * @see AbOnItemClickEvent
     */
    public interface PagerOnItemClickListener {

        /**
         * 描述：点击事件.
         *
         * @param position 索引
         */
        public void onClick(int position);
    }

}
