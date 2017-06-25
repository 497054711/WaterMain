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
import com.cn.android.databinding.ListviewContainerBinding;
import com.cn.android.nethelp.retrofit.HRetrofitNetHelper;
import com.cn.android.nethelp.retrofit.RetrofitBaseCallBack;
import com.cn.android.utils.PixelTransform;
import com.cn.android.widget.CommonXRefreshViewFooter;
import com.cn.android.widget.CommonXRefreshViewHeader;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/25.
 */

public class ListViewContainerFragment extends Fragment implements IListViewContainer {
    private ListviewContainerBinding listviewContainerBinding;
    private boolean optionPullRefresh = false;//执行下拉刷新操作
    private int page = 1;
    private int pageTemp;
    private BaseRecycleAdapter baseRecycleAdapter;
    private IListViewListener iListViewListener;

    public void setBaseRecycleAdapter(BaseRecycleAdapter baseRecycleAdapter) {
        this.baseRecycleAdapter = baseRecycleAdapter;
    }

    public void setiListViewListener(IListViewListener iListViewListener) {
        this.iListViewListener = iListViewListener;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        listviewContainerBinding = DataBindingUtil.inflate(inflater, R.layout.listview_container, container, false);
        return listviewContainerBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
        listviewContainerBinding.rv.setLayoutManager(layoutManager);
        listviewContainerBinding.rv.setAdapter(baseRecycleAdapter);
        initXrvMessageEmpty();
        initXrvMessage();
    }

    @Override
    public void initXrvMessageEmpty() {//初始化xrvLatestDynamicEmpty
        listviewContainerBinding.xrvEmpty.setPullLoadEnable(false);
        listviewContainerBinding.xrvEmpty.setPullRefreshEnable(true);
        listviewContainerBinding.xrvEmpty.setMoveFootWhenDisablePullLoadMore(true);

        //设置headler
        CommonXRefreshViewHeader commonXRefreshViewHeaderEmpty = new CommonXRefreshViewHeader(this.getActivity());
        listviewContainerBinding.xrvEmpty.setCustomHeaderView(commonXRefreshViewHeaderEmpty);
        listviewContainerBinding.xrvEmpty.setXRefreshViewListener(new XRefreshView.SimpleXRefreshListener() {
            @Override
            public void onRefresh(boolean isPullDown) {
                super.onRefresh(isPullDown);
                ListViewContainerFragment.this.onRefresh();
            }
        });
    }

    @Override
    public void initXrvMessage() {
        listviewContainerBinding.xrv.setPullLoadEnable(true);
        listviewContainerBinding.xrv.setPullRefreshEnable(true);
        listviewContainerBinding.xrv.setMoveFootWhenDisablePullLoadMore(true);

        //设置headler
        CommonXRefreshViewHeader commonXRefreshViewHeader = new CommonXRefreshViewHeader(this.getActivity());
        listviewContainerBinding.xrv.setCustomHeaderView(commonXRefreshViewHeader);

        //设置footer
        CommonXRefreshViewFooter commonXRefreshViewFooter = new CommonXRefreshViewFooter(this.getActivity());
        listviewContainerBinding.xrv.setCustomFooterView(commonXRefreshViewFooter);
        listviewContainerBinding.xrv.setHeadMoveLargestDistence(PixelTransform.dip2px(this.getActivity(), 10));
        listviewContainerBinding.xrv.setXRefreshViewListener(new XRefreshView.SimpleXRefreshListener() {
            @Override
            public void onRefresh(boolean isPullDown) {
                super.onRefresh(isPullDown);
                optionPullRefresh = true;
                ListViewContainerFragment.this.onRefresh();
            }

            @Override
            public void onLoadMore(boolean isSilence) {
                super.onLoadMore(isSilence);
                ListViewContainerFragment.this.onLoadMore();
            }
        });
    }

    @Override
    public void onRefresh() {
        pageTemp = page;
        page = 1;
        if(iListViewListener!=null){
            iListViewListener.getData(page);
        }
    }

    @Override
    public void onLoadMore() {
        pageTemp = page;
        page++;
        if(iListViewListener!=null){
            iListViewListener.getData(page);
        }
    }

    public void updateList(RetrofitBaseCallBack mRetrofitBaseCallBack){
        listviewContainerBinding.xrv.stopRefresh();
        listviewContainerBinding.xrv.stopLoadMore();

        listviewContainerBinding.xrvEmpty.stopRefresh();

        if (HRetrofitNetHelper.STATUS_SUCCESS == mRetrofitBaseCallBack.getRet()) {
            pageTemp = page;
            if (optionPullRefresh) {
                optionPullRefresh = false;
                if(iListViewListener!=null){
                    iListViewListener.clearData();
                }
            }
        } else {
            page = pageTemp;
        }
        if(iListViewListener!=null){
            iListViewListener.upDateList(mRetrofitBaseCallBack);
        }
    }

    public void upDateXrv(boolean isEmpty){//更新 xrefresh
        if (isEmpty) {//判断listview 数据是否为空
            listviewContainerBinding.xrv.setVisibility(View.GONE);
            listviewContainerBinding.xrvEmpty.setVisibility(View.VISIBLE);
        } else {
            listviewContainerBinding.xrv.setVisibility(View.VISIBLE);
            listviewContainerBinding.xrvEmpty.setVisibility(View.GONE);
        }
    }

    public void setPullLoadEnable(boolean enable){//设置xrefresh是否可以上拉加载下一页
        listviewContainerBinding.xrv.setPullLoadEnable(enable);
    }
}
