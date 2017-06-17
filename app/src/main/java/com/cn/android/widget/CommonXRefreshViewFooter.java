package com.cn.android.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.andview.refreshview.XRefreshView;
import com.andview.refreshview.callback.IFooterCallBack;
import com.cn.android.R;
import com.cn.android.databinding.CommonXrefreshviewFooterBinding;

public class CommonXRefreshViewFooter extends LinearLayout implements IFooterCallBack {
    private boolean showing = true;
    private CommonXrefreshviewFooterBinding commonXrefreshviewFooterBinding;;

    public CommonXRefreshViewFooter(Context context) {
        super(context);
        initView(context);
    }

    public CommonXRefreshViewFooter(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    @Override
    public void callWhenNotAutoLoadMore(final XRefreshView xRefreshView) {
        commonXrefreshviewFooterBinding.tvCommonRefreshviewFooterTipRefresh.setText("松开加载更多");
    }

    @Override
    public void onStateReady() {
        commonXrefreshviewFooterBinding.pbCommonRefreshviewFooter.setVisibility(View.GONE);
        commonXrefreshviewFooterBinding.tvCommonRefreshviewFooterTipRefresh.setText("松开加载更多");
        commonXrefreshviewFooterBinding.tvCommonRefreshviewFooterTipRefresh.setVisibility(View.VISIBLE);
    }

    @Override
    public void onStateRefreshing() {
        commonXrefreshviewFooterBinding.pbCommonRefreshviewFooter.setVisibility(View.VISIBLE);
        commonXrefreshviewFooterBinding.tvCommonRefreshviewFooterTipRefresh.setVisibility(View.GONE);
//        show(true);
    }

    @Override
    public void onReleaseToLoadMore() {
        commonXrefreshviewFooterBinding.pbCommonRefreshviewFooter.setVisibility(View.GONE);
        commonXrefreshviewFooterBinding.tvCommonRefreshviewFooterTipRefresh.setText("松开加载更多");
        commonXrefreshviewFooterBinding.tvCommonRefreshviewFooterTipRefresh.setVisibility(View.VISIBLE);
    }

    @Override
    public void onStateFinish(boolean hideFooter) {
        commonXrefreshviewFooterBinding.pbCommonRefreshviewFooter.setVisibility(View.GONE);
        commonXrefreshviewFooterBinding.tvCommonRefreshviewFooterTipRefresh.setVisibility(View.GONE);
    }

    @Override
    public void onStateComplete() {
    }

    @Override
    public void show(final boolean show) {
        if (show == showing) {
            return;
        }
        showing = show;
        LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
        lp.height = show ? LayoutParams.WRAP_CONTENT : 0;
        commonXrefreshviewFooterBinding.lvCommonRefreshviewFooter.setLayoutParams(lp);

    }

    @Override
    public boolean isShowing() {
        return showing;
    }

    private void initView(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.common_xrefreshview_footer, this);
        commonXrefreshviewFooterBinding=CommonXrefreshviewFooterBinding.inflate(inflater);
    }

    @Override
    public int getFooterHeight() {
        return getMeasuredHeight();
    }
}
