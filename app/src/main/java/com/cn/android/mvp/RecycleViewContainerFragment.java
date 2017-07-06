package com.cn.android.mvp;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andview.refreshview.XRefreshView;
import com.cn.android.R;
import com.cn.android.adapter.BaseRecycleAdapter;
import com.cn.android.databinding.RecycleviewContainerBinding;
import com.cn.android.nethelp.retrofit.HRetrofitNetHelper;
import com.cn.android.nethelp.retrofit.RetrofitBaseCallBack;
import com.cn.android.utils.PixelTransform;
import com.cn.android.widget.CommonXRefreshViewFooter;
import com.cn.android.widget.CommonXRefreshViewHeader;

/**
 * Created by Administrator on 2017/6/25.
 */

public class RecycleViewContainerFragment extends Fragment implements IRecycleViewContainer {
    private RecycleviewContainerBinding recycleviewContainerBinding;
    private boolean optionPullRefresh = false;//执行下拉刷新操作
    private int page = 1;
    private int pageTemp;
    private BaseRecycleAdapter baseRecycleAdapter;
    private IRecycleViewListener iRecycleViewListener;

    public void setBaseRecycleAdapter(BaseRecycleAdapter baseRecycleAdapter) {
        this.baseRecycleAdapter = baseRecycleAdapter;
    }

    public void setiRecycleViewListener(IRecycleViewListener iRecycleViewListener) {
        this.iRecycleViewListener = iRecycleViewListener;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        recycleviewContainerBinding = DataBindingUtil.inflate(inflater, R.layout.recycleview_container, container, false);
        return recycleviewContainerBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
        recycleviewContainerBinding.rv.setLayoutManager(layoutManager);
        recycleviewContainerBinding.rv.setAdapter(baseRecycleAdapter);
        initXrvMessageEmpty();
        initXrvMessage();
    }

    @Override
    public void initXrvMessageEmpty() {//初始化xrvLatestDynamicEmpty
        recycleviewContainerBinding.xrvEmpty.setPullLoadEnable(false);
        recycleviewContainerBinding.xrvEmpty.setPullRefreshEnable(true);
        recycleviewContainerBinding.xrvEmpty.setMoveFootWhenDisablePullLoadMore(true);

        //设置headler
        CommonXRefreshViewHeader commonXRefreshViewHeaderEmpty = new CommonXRefreshViewHeader(this.getActivity());
        recycleviewContainerBinding.xrvEmpty.setCustomHeaderView(commonXRefreshViewHeaderEmpty);
        recycleviewContainerBinding.xrvEmpty.setXRefreshViewListener(new XRefreshView.SimpleXRefreshListener() {
            @Override
            public void onRefresh(boolean isPullDown) {
                super.onRefresh(isPullDown);
                RecycleViewContainerFragment.this.onRefresh();
            }
        });
    }

    @Override
    public void initXrvMessage() {

        recycleviewContainerBinding.xrv.setPullLoadEnable(true);
        recycleviewContainerBinding.xrv.setPullRefreshEnable(true);
        recycleviewContainerBinding.xrv.setMoveFootWhenDisablePullLoadMore(true);

        //设置headler
        CommonXRefreshViewHeader commonXRefreshViewHeader = new CommonXRefreshViewHeader(this.getActivity());
        recycleviewContainerBinding.xrv.setCustomHeaderView(commonXRefreshViewHeader);

        //设置footer
        CommonXRefreshViewFooter commonXRefreshViewFooter = new CommonXRefreshViewFooter(this.getActivity());
        recycleviewContainerBinding.xrv.setCustomFooterView(commonXRefreshViewFooter);
        recycleviewContainerBinding.xrv.setHeadMoveLargestDistence(PixelTransform.dip2px(this.getActivity(), 10));
        recycleviewContainerBinding.xrv.setXRefreshViewListener(new XRefreshView.SimpleXRefreshListener() {
            @Override
            public void onRefresh(boolean isPullDown) {
                super.onRefresh(isPullDown);
                optionPullRefresh = true;
                RecycleViewContainerFragment.this.onRefresh();
            }

            @Override
            public void onLoadMore(boolean isSilence) {
                super.onLoadMore(isSilence);
                RecycleViewContainerFragment.this.onLoadMore();
            }
        });
    }

    @Override
    public void onRefresh() {
        pageTemp = page;
        page = 1;
        if (iRecycleViewListener != null) {
            iRecycleViewListener.getData(page);
        }
    }

    @Override
    public void onLoadMore() {
        pageTemp = page;
        page++;
        if (iRecycleViewListener != null) {
            iRecycleViewListener.getData(page);
        }
    }

    public void updateContainer(RetrofitBaseCallBack mRetrofitBaseCallBack) {
        recycleviewContainerBinding.xrv.stopRefresh();
        recycleviewContainerBinding.xrv.stopLoadMore();

        recycleviewContainerBinding.xrvEmpty.stopRefresh();

        if (HRetrofitNetHelper.STATUS_SUCCESS == mRetrofitBaseCallBack.getRet()) {
            pageTemp = page;
            if (optionPullRefresh) {
                optionPullRefresh = false;
                if (iRecycleViewListener != null) {
                    iRecycleViewListener.clearData();
                }
            }
        } else {
            page = pageTemp;
        }
    }

    public void setRecycleViewEmpty(boolean isEmpty) {//更新 xrefresh
        if (isEmpty) {//判断listview 数据是否为空
            recycleviewContainerBinding.xrv.setVisibility(View.GONE);
            recycleviewContainerBinding.xrvEmpty.setVisibility(View.VISIBLE);
        } else {
            recycleviewContainerBinding.xrv.setVisibility(View.VISIBLE);
            recycleviewContainerBinding.xrvEmpty.setVisibility(View.GONE);
        }
    }

    public void setPullLoadEnable(boolean enable) {//设置xrefresh是否可以上拉加载下一页
        recycleviewContainerBinding.xrv.setPullLoadEnable(enable);
    }
}
