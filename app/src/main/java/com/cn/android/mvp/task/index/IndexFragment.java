package com.cn.android.mvp.task.index;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andview.refreshview.XRefreshView;
import com.cn.android.BR;
import com.cn.android.R;
import com.cn.android.adapter.BaseRecycleAdapter;
import com.cn.android.adapter.MyViewPagerAdapter;
import com.cn.android.databinding.BannerItemBinding;
import com.cn.android.databinding.TaskIndexBinding;
import com.cn.android.databinding.TaskIndexItemBinding;
import com.cn.android.databinding.WaterMainTitleBinding;
import com.cn.android.events.EventTask;
import com.cn.android.mvp.BaseDisplayActivity;
import com.cn.android.mvp.BaseFragment;
import com.cn.android.mvp.IBaseTitleView;
import com.cn.android.mvp.setting.SettingIndexFragment;
import com.cn.android.mvp.task.index.model.biz.TaskIndexRecord;
import com.cn.android.mvp.task.index.model.biz.TaskIndexResult;
import com.cn.android.mvp.task.index.present.IIndexPresent;
import com.cn.android.mvp.task.index.present.IndexPresent;
import com.cn.android.mvp.task.index.view.IIndexView;
import com.cn.android.nethelp.Params;
import com.cn.android.nethelp.retrofit.HRetrofitNetHelper;
import com.cn.android.nethelp.retrofit.RetrofitBaseCallBack;
import com.cn.android.utils.LoadImageUtil;
import com.cn.android.utils.PixelTransform;
import com.cn.android.widget.CommonXRefreshViewFooter;
import com.cn.android.widget.CommonXRefreshViewHeader;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/20.
 */

public class IndexFragment extends BaseFragment implements IIndexView, IBaseTitleView {

    private TaskAdapter taskAdapter;
    private TaskIndexBinding taskIndexBinding;
    private WaterMainTitleBinding waterMainTitleBinding;
    private IIndexPresent iIndexPresent;
    private List<TaskIndexRecord> records;
    private boolean optionPullRefresh = false;//执行下拉刷新操作
    private int page = 1;
    private int pageTemp;
    private List<View> bannerPagers;
    private MyViewPagerAdapter myViewPagerAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        taskIndexBinding = DataBindingUtil.inflate(inflater, R.layout.task_index, container, false);
        return taskIndexBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        EventBus.getDefault().register(this);
        title.setText("首页");
        taskIndexBinding.includeWaterMainTitle.back.setVisibility(View.GONE);
        taskIndexBinding.includeWaterMainTitle.right.setImageResource(R.drawable.index_setting);
        taskIndexBinding.setIndexView(this);
        waterMainTitleBinding = taskIndexBinding.includeWaterMainTitle;
        waterMainTitleBinding.setBaseTitleView(this);

        iIndexPresent = new IndexPresent(this.getActivity(), this);
        records = new ArrayList<>();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
        taskIndexBinding.rvIndex.setLayoutManager(layoutManager);
        taskAdapter = new TaskAdapter(records, R.layout.task_index_item, BR.taskIndexRecord);
        taskIndexBinding.rvIndex.setAdapter(taskAdapter);
        initXrvMessageEmpty();
        initXrvMessage();
        banner();
        task();
    }

    @Override
    public void banner() {
        Params paramsBanner = new Params();
        Map map = new HashMap();
        paramsBanner.setMapParams(map);
        iIndexPresent.banner(paramsBanner);
    }

    @Override
    public void task() {
        onRefresh();
    }

    @Override
    public void onRefresh() {
        Map<String, String> mParamsMap = new HashMap<>();
        pageTemp = page;
        page = 1;
        mParamsMap.put("page", String.valueOf(page));
        Params paramsTask = new Params();
        paramsTask.setMapParams(mParamsMap);
        iIndexPresent.task(paramsTask);
    }

    @Override
    public void onLoadMore() {
        Map<String, String> mParamsMap = new HashMap<>();
        pageTemp = page;
        page++;
        mParamsMap.put("page", String.valueOf(page));
        Params paramsTask = new Params();
        paramsTask.setMapParams(mParamsMap);
        iIndexPresent.task(paramsTask);
    }

    @Override
    public void initXrvMessageEmpty() {
        //初始化xrvLatestDynamicEmpty
        taskIndexBinding.xrvIndexEmpty.setPullLoadEnable(false);
        taskIndexBinding.xrvIndexEmpty.setPullRefreshEnable(true);
        taskIndexBinding.xrvIndexEmpty.setMoveFootWhenDisablePullLoadMore(true);

        //设置headler
        CommonXRefreshViewHeader commonXRefreshViewHeaderEmpty = new CommonXRefreshViewHeader(this.getActivity());
        taskIndexBinding.xrvIndexEmpty.setCustomHeaderView(commonXRefreshViewHeaderEmpty);
        taskIndexBinding.xrvIndexEmpty.setXRefreshViewListener(new XRefreshView.SimpleXRefreshListener() {
            @Override
            public void onRefresh(boolean isPullDown) {
                super.onRefresh(isPullDown);
                IndexFragment.this.onRefresh();
            }
        });
    }

    @Override
    public void initXrvMessage() {
        taskIndexBinding.xrvIndex.setPullLoadEnable(true);
        taskIndexBinding.xrvIndex.setPullRefreshEnable(true);
        taskIndexBinding.xrvIndex.setMoveFootWhenDisablePullLoadMore(true);

        //设置headler
        CommonXRefreshViewHeader commonXRefreshViewHeader = new CommonXRefreshViewHeader(this.getActivity());
        taskIndexBinding.xrvIndex.setCustomHeaderView(commonXRefreshViewHeader);

        CommonXRefreshViewFooter commonXRefreshViewFooter = new CommonXRefreshViewFooter(this.getActivity());
        taskIndexBinding.xrvIndex.setCustomFooterView(commonXRefreshViewFooter);
        taskIndexBinding.xrvIndex.setHeadMoveLargestDistence(PixelTransform.dip2px(this.getActivity(), 10));
        taskIndexBinding.xrvIndex.setXRefreshViewListener(new XRefreshView.SimpleXRefreshListener() {
            @Override
            public void onRefresh(boolean isPullDown) {
                super.onRefresh(isPullDown);
                optionPullRefresh = true;
                IndexFragment.this.onRefresh();
            }

            @Override
            public void onLoadMore(boolean isSilence) {
                super.onLoadMore(isSilence);
                IndexFragment.this.onLoadMore();
            }
        });
    }

    @Override
    public void upDateTask(RetrofitBaseCallBack mRetrofitBaseCallBack) {

        taskIndexBinding.xrvIndex.stopRefresh();
        taskIndexBinding.xrvIndex.stopLoadMore();

        taskIndexBinding.xrvIndexEmpty.stopRefresh();

        if (HRetrofitNetHelper.STATUS_SUCCESS == mRetrofitBaseCallBack.getRet()) {
            if (optionPullRefresh) {
                records.clear();
                optionPullRefresh = false;
            }
            pageTemp = page;
            TaskIndexResult taskIndexResult = (TaskIndexResult) mRetrofitBaseCallBack;
            records.addAll(taskIndexResult.getData().getRecords());
            taskAdapter.notifyDataSetChanged();
            if (!taskIndexResult.getData().isMore()) {
                taskIndexBinding.xrvIndex.setPullLoadEnable(false);
            }
        } else {
            page = pageTemp;
        }
        if (records.size() == 0) {
            taskIndexBinding.xrvIndex.setVisibility(View.GONE);
            taskIndexBinding.xrvIndexEmpty.setVisibility(View.VISIBLE);
        } else {
            taskIndexBinding.xrvIndex.setVisibility(View.VISIBLE);
            taskIndexBinding.xrvIndexEmpty.setVisibility(View.GONE);
        }
    }

    @Override
    public void upDateBanner(RetrofitBaseCallBack mRetrofitBaseCallBack) {
        LayoutInflater inflater=this.getActivity().getLayoutInflater();
        bannerPagers=new ArrayList<>();
        for (int i = 0; i < 0; i++) {
            View bannerItem = inflater.inflate(R.layout.banner_item, null);
            bannerPagers.add(bannerItem);
            BannerItemBinding bannerItemBinding=BannerItemBinding.inflate(inflater);
            LoadImageUtil.getInstance(this.getActivity()).displayFromNet("",bannerItemBinding.ivBannerItem);
        }
        myViewPagerAdapter = new MyViewPagerAdapter(bannerPagers);
        taskIndexBinding.asvpIndexBanner.setAdapter(myViewPagerAdapter);
        taskIndexBinding.asvpIndexBanner.startAutoScroll();
        myViewPagerAdapter.setPagerOnItemClickListener(new MyViewPagerAdapter.PagerOnItemClickListener() {
            @Override
            public void onClick(int position) {

            }
        });
    }

    @Override
    public void back(View view) {

    }

    @Override
    public void right(View view) {
        Intent intent = new Intent(this.getActivity(), BaseDisplayActivity.class);
        intent.putExtra("class", SettingIndexFragment.class);
        startActivity(intent);
    }

    /**
     * TODO登录完成执行的事件
     *
     * @param event
     * @return void
     * @throw
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventTaskRefresh(EventTask event) {
        onRefresh();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);//反注册EventBus
    }

    public class TaskAdapter extends BaseRecycleAdapter {
        private List<TaskIndexRecord> records;
        private String type;
        private TaskIndexItemBinding taskIndexItemBinding;

        public TaskAdapter(List<?> mDatas, int layoutId, int brId) {
            super(mDatas, layoutId, brId);
            records = (List<TaskIndexRecord>) mDatas;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            super.onBindViewHolder(holder, position);
            type = records.get(position).getType();
            taskIndexItemBinding = (TaskIndexItemBinding) holder.getBinding();
            if (type.equals("1")) {
                taskIndexItemBinding.tvIndexTaskItemName.setBackgroundColor(ContextCompat.getColor(IndexFragment.this.getActivity(), R.color.office_inspection_bg));
                taskIndexItemBinding.tvIndexTaskItemCode.setTextColor(ContextCompat.getColor(IndexFragment.this.getActivity(), R.color.office_inspection_code_txt));
                taskIndexItemBinding.tvIndexTaskItemCode.setBackgroundResource(R.drawable.office_inspection_code_bg);
            } else if (type.equals("2")) {
                taskIndexItemBinding.tvIndexTaskItemName.setBackgroundColor(ContextCompat.getColor(IndexFragment.this.getActivity(), R.color.integration_inspection_bg));
                taskIndexItemBinding.tvIndexTaskItemCode.setTextColor(ContextCompat.getColor(IndexFragment.this.getActivity(), R.color.integration_inspection_code_txt));
                taskIndexItemBinding.tvIndexTaskItemCode.setBackgroundResource(R.drawable.integreation_inspection_code_bg);
            } else if (type.equals("3")) {
                taskIndexItemBinding.tvIndexTaskItemName.setBackgroundColor(ContextCompat.getColor(IndexFragment.this.getActivity(), R.color.office_inspection_bg));
                taskIndexItemBinding.tvIndexTaskItemCode.setTextColor(ContextCompat.getColor(IndexFragment.this.getActivity(), R.color.office_inspection_code_txt));
                taskIndexItemBinding.tvIndexTaskItemCode.setBackgroundResource(R.drawable.office_inspection_code_bg);
            }
        }
    }
}
