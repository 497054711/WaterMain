package com.cn.android.mvp.task.detail.word;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andview.refreshview.XRefreshView;
import com.cn.android.BR;
import com.cn.android.R;
import com.cn.android.adapter.BaseRecycleAdapter;
import com.cn.android.databinding.TaskDetailWordBinding;
import com.cn.android.databinding.TaskIndexUserItemBinding;
import com.cn.android.mvp.BaseFragment;
import com.cn.android.mvp.task.detail.word.model.biz.TaskDetailWord;
import com.cn.android.mvp.task.detail.word.model.biz.TaskDetailWordResult;
import com.cn.android.mvp.task.detail.word.present.TaskDetailWordPresent;
import com.cn.android.mvp.task.detail.word.view.ITaskDetailWordView;
import com.cn.android.nethelp.Params;
import com.cn.android.nethelp.retrofit.HRetrofitNetHelper;
import com.cn.android.nethelp.retrofit.RetrofitBaseCallBack;
import com.cn.android.utils.PixelTransform;
import com.cn.android.widget.CommonXRefreshViewFooter;
import com.cn.android.widget.CommonXRefreshViewHeader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/22.
 */

public class TaskDetailWordFragment extends BaseFragment implements ITaskDetailWordView {

    private TaskDetailWordBinding taskDetailWordBinding;
    private TaskAdapter taskAdapter;
    private List<TaskDetailWord> records;
    private TaskDetailWordPresent taskIndexUserPresent;
    private boolean optionPullRefresh = false;//执行下拉刷新操作
    private int page = 1;
    private int pageTemp;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        taskDetailWordBinding = DataBindingUtil.inflate(inflater, R.layout.task_detail_word, container, false);
        return taskDetailWordBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        title.setText("任务");
        taskDetailWordBinding.includeWaterMainTitle.back.setVisibility(View.GONE);
        taskDetailWordBinding.setTaskDetailWordView(this);
        taskIndexUserPresent = new TaskDetailWordPresent(this.getActivity(), this);
        records = new ArrayList<>();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
        taskDetailWordBinding.rvTaskIndex.setLayoutManager(layoutManager);
        taskAdapter = new TaskAdapter(records, R.layout.task_detail_wrod_item, BR.taskIndexUserRecord);
        taskDetailWordBinding.rvTaskIndex.setAdapter(taskAdapter);
        initXrvMessageEmpty();
        initXrvMessage();
        task();
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
        taskIndexUserPresent.task(paramsTask);
    }

    @Override
    public void onLoadMore() {
        Map<String, String> mParamsMap = new HashMap<>();
        pageTemp = page;
        page++;
        mParamsMap.put("page", String.valueOf(page));
        Params paramsTask = new Params();
        paramsTask.setMapParams(mParamsMap);
        taskIndexUserPresent.task(paramsTask);
    }

    @Override
    public void initXrvMessageEmpty() {
        //初始化xrvLatestDynamicEmpty
        taskDetailWordBinding.xrvIndexEmpty.setPullLoadEnable(false);
        taskDetailWordBinding.xrvIndexEmpty.setPullRefreshEnable(true);
        taskDetailWordBinding.xrvIndexEmpty.setMoveFootWhenDisablePullLoadMore(true);

        //设置headler
        CommonXRefreshViewHeader commonXRefreshViewHeaderEmpty = new CommonXRefreshViewHeader(this.getActivity());
        taskDetailWordBinding.xrvIndexEmpty.setCustomHeaderView(commonXRefreshViewHeaderEmpty);
        taskDetailWordBinding.xrvIndexEmpty.setXRefreshViewListener(new XRefreshView.SimpleXRefreshListener() {
            @Override
            public void onRefresh(boolean isPullDown) {
                super.onRefresh(isPullDown);
                TaskDetailWordFragment.this.onRefresh();
            }
        });
    }

    @Override
    public void initXrvMessage() {
        taskDetailWordBinding.xrvIndex.setPullLoadEnable(true);
        taskDetailWordBinding.xrvIndex.setPullRefreshEnable(true);
        taskDetailWordBinding.xrvIndex.setMoveFootWhenDisablePullLoadMore(true);

        //设置headler
        CommonXRefreshViewHeader commonXRefreshViewHeader = new CommonXRefreshViewHeader(this.getActivity());
        taskDetailWordBinding.xrvIndex.setCustomHeaderView(commonXRefreshViewHeader);

        CommonXRefreshViewFooter commonXRefreshViewFooter = new CommonXRefreshViewFooter(this.getActivity());
        taskDetailWordBinding.xrvIndex.setCustomFooterView(commonXRefreshViewFooter);
        taskDetailWordBinding.xrvIndex.setHeadMoveLargestDistence(PixelTransform.dip2px(this.getActivity(), 10));
        taskDetailWordBinding.xrvIndex.setXRefreshViewListener(new XRefreshView.SimpleXRefreshListener() {
            @Override
            public void onRefresh(boolean isPullDown) {
                super.onRefresh(isPullDown);
                optionPullRefresh = true;
                TaskDetailWordFragment.this.onRefresh();
            }

            @Override
            public void onLoadMore(boolean isSilence) {
                super.onLoadMore(isSilence);
                TaskDetailWordFragment.this.onLoadMore();
            }
        });
    }

    @Override
    public void upDateTask(RetrofitBaseCallBack mRetrofitBaseCallBack) {

        taskDetailWordBinding.xrvIndex.stopRefresh();
        taskDetailWordBinding.xrvIndex.stopLoadMore();

        taskDetailWordBinding.xrvIndexEmpty.stopRefresh();

        if (HRetrofitNetHelper.STATUS_SUCCESS == mRetrofitBaseCallBack.getRet()) {
            if (optionPullRefresh) {
                records.clear();
                optionPullRefresh = false;
            }
            pageTemp = page;
            TaskDetailWordResult taskDetailWordResult = (TaskDetailWordResult) mRetrofitBaseCallBack;
//            records.addAll(taskDetailWordResult.getData().getRecords());
//            taskAdapter.notifyDataSetChanged();
//            if (!taskDetailWordResult.getData().isMore()) {
//                taskDetailWordBinding.xrvIndex.setPullLoadEnable(false);
//            }
        } else {
            page = pageTemp;
        }
        if (records.size() == 0) {
            taskDetailWordBinding.xrvIndex.setVisibility(View.GONE);
            taskDetailWordBinding.xrvIndexEmpty.setVisibility(View.VISIBLE);
        } else {
            taskDetailWordBinding.xrvIndex.setVisibility(View.VISIBLE);
            taskDetailWordBinding.xrvIndexEmpty.setVisibility(View.GONE);
        }
    }

    public class TaskAdapter extends BaseRecycleAdapter {
        private List<TaskDetailWord> records;
        private String type;
        private TaskIndexUserItemBinding taskIndexUserItemBinding;

        public TaskAdapter(List<?> mDatas, int layoutId, int brId) {
            super(mDatas, layoutId, brId);
            records = (List<TaskDetailWord>) mDatas;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            super.onBindViewHolder(holder, position);
            type = records.get(position).getType();
            taskIndexUserItemBinding = (TaskIndexUserItemBinding) holder.getBinding();
            if (type.equals("1")) {
                taskIndexUserItemBinding.tvIndexTaskItemName.setBackgroundColor(ContextCompat.getColor(TaskDetailWordFragment.this.getActivity(), R.color.office_inspection_bg));
                taskIndexUserItemBinding.tvIndexTaskItemCode.setTextColor(ContextCompat.getColor(TaskDetailWordFragment.this.getActivity(), R.color.office_inspection_code_txt));
                taskIndexUserItemBinding.tvIndexTaskItemCode.setBackgroundResource(R.drawable.office_inspection_code_bg);
            } else if (type.equals("2")) {
                taskIndexUserItemBinding.tvIndexTaskItemName.setBackgroundColor(ContextCompat.getColor(TaskDetailWordFragment.this.getActivity(), R.color.integration_inspection_bg));
                taskIndexUserItemBinding.tvIndexTaskItemCode.setTextColor(ContextCompat.getColor(TaskDetailWordFragment.this.getActivity(), R.color.integration_inspection_code_txt));
                taskIndexUserItemBinding.tvIndexTaskItemCode.setBackgroundResource(R.drawable.integreation_inspection_code_bg);
            } else if (type.equals("3")) {
                taskIndexUserItemBinding.tvIndexTaskItemName.setBackgroundColor(ContextCompat.getColor(TaskDetailWordFragment.this.getActivity(), R.color.office_inspection_bg));
                taskIndexUserItemBinding.tvIndexTaskItemCode.setTextColor(ContextCompat.getColor(TaskDetailWordFragment.this.getActivity(), R.color.office_inspection_code_txt));
                taskIndexUserItemBinding.tvIndexTaskItemCode.setBackgroundResource(R.drawable.office_inspection_code_bg);
            }
        }
    }
}
