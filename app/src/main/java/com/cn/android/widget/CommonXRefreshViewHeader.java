package com.cn.android.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.andview.refreshview.callback.IHeaderCallBack;
import com.cn.android.R;
import com.cn.android.databinding.CommonXrefreshHeaderBinding;

public class CommonXRefreshViewHeader extends LinearLayout implements IHeaderCallBack {
    private CommonXrefreshHeaderBinding commonXrefreshHeaderBinding;
    public CommonXRefreshViewHeader(Context context) {
        super(context);
        initView(context);
    }

    /**
     * @param context
     * @param attrs
     */
    public CommonXRefreshViewHeader(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    private void initView(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.common_xrefresh_header, this);
        commonXrefreshHeaderBinding=CommonXrefreshHeaderBinding.inflate(inflater);
    }

    public void setRefreshTime(long lastRefreshTime) {

    }

    /**
     * hide footer when disable pull refresh
     */
    public void hide() {
    }

    public void show() {
    }

    @Override
    public void onStateNormal() {

    }

    @Override
    public void onStateReady() {
        commonXrefreshHeaderBinding.tvCommonRefreshHeaderTipRefresh.setText("松开立即刷新");
    }

    @Override
    public void onStateRefreshing() {
        commonXrefreshHeaderBinding.tvCommonRefreshHeaderTipRefresh.setText("正在刷新数据中...");
    }

    @Override
    public void onStateFinish(boolean success) {
        commonXrefreshHeaderBinding.tvCommonRefreshHeaderTipRefresh.setText("刷新完成");
    }

    @Override
    public void onHeaderMove(double headerMovePercent, int offsetY, int deltaY) {

    }

    @Override
    public int getHeaderHeight() {
        return getMeasuredHeight();
    }
}
