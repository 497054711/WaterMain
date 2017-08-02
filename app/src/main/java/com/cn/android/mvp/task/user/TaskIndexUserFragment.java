package com.cn.android.mvp.task.user;

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
import com.cn.android.R;
import com.cn.android.adapter.BaseRecycleAdapter;
import com.cn.android.databinding.TaskIndexUserBinding;
import com.cn.android.databinding.TaskIndexUserItemBinding;
import com.cn.android.mvp.BaseFragment;
import com.cn.android.mvp.task.user.model.biz.TaskIndexUserRecord;
import com.cn.android.mvp.task.user.model.biz.TaskIndexUserResult;
import com.cn.android.mvp.task.user.present.TaskIndexUserPresent;
import com.cn.android.mvp.task.user.view.ITaskIndexUserView;
import com.cn.android.nethelp.Params;
import com.cn.android.nethelp.retrofit.HRetrofitNetHelper;
import com.cn.android.nethelp.retrofit.RetrofitBaseCallBack;
import com.cn.android.utils.PixelTransform;
import com.cn.android.widget.CommonXRefreshViewFooter;
import com.cn.android.widget.CommonXRefreshViewHeader;
import com.cn.android.BR;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/22.
 */

public class TaskIndexUserFragment extends BaseFragment implements ITaskIndexUserView {

    private TaskIndexUserBinding taskIndexUserBinding;
    private TaskAdapter taskAdapter;
    private List<TaskIndexUserRecord> records;
    private TaskIndexUserPresent taskIndexUserPresent;
    private boolean optionPullRefresh = false;//执行下拉刷新操作
    private int page = 1;
    private int pageTemp;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        taskIndexUserBinding = DataBindingUtil.inflate(inflater, R.layout.task_index_user, container, false);
        return taskIndexUserBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        title.setText("任务");
        taskIndexUserBinding.includeWaterMainTitle.back.setVisibility(View.GONE);
        taskIndexUserBinding.setTaskIndexUserView(this);
        taskIndexUserPresent = new TaskIndexUserPresent(this.getActivity(), this);
        records = new ArrayList<>();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
        taskIndexUserBinding.rvTaskIndex.setLayoutManager(layoutManager);
        taskAdapter = new TaskAdapter(records, R.layout.task_index_user_item, BR.taskIndexUserRecord);
        taskIndexUserBinding.rvTaskIndex.setAdapter(taskAdapter);
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
    public void initXrvMessage() {
        taskIndexUserBinding.xrvIndex.setPullLoadEnable(true);
        taskIndexUserBinding.xrvIndex.setPullRefreshEnable(true);
        taskIndexUserBinding.xrvIndex.setMoveFootWhenDisablePullLoadMore(true);

        //设置headler
        CommonXRefreshViewHeader commonXRefreshViewHeader = new CommonXRefreshViewHeader(this.getActivity());
        taskIndexUserBinding.xrvIndex.setCustomHeaderView(commonXRefreshViewHeader);

        CommonXRefreshViewFooter commonXRefreshViewFooter = new CommonXRefreshViewFooter(this.getActivity());
        taskIndexUserBinding.xrvIndex.setCustomFooterView(commonXRefreshViewFooter);
        taskIndexUserBinding.xrvIndex.setHeadMoveLargestDistence(PixelTransform.dip2px(this.getActivity(), 10));
        taskIndexUserBinding.xrvIndex.setXRefreshViewListener(new XRefreshView.SimpleXRefreshListener() {
            @Override
            public void onRefresh(boolean isPullDown) {
                super.onRefresh(isPullDown);
                optionPullRefresh = true;
                TaskIndexUserFragment.this.onRefresh();
            }

            @Override
            public void onLoadMore(boolean isSilence) {
                super.onLoadMore(isSilence);
                TaskIndexUserFragment.this.onLoadMore();
            }
        });
    }

    @Override
    public void upDateTask(RetrofitBaseCallBack mRetrofitBaseCallBack) {

        taskIndexUserBinding.xrvIndex.stopRefresh();
        taskIndexUserBinding.xrvIndex.stopLoadMore();

        if (HRetrofitNetHelper.STATUS_SUCCESS == mRetrofitBaseCallBack.getRet()) {
            if (optionPullRefresh) {
                records.clear();
                optionPullRefresh = false;
            }
            pageTemp = page;
            TaskIndexUserResult taskIndexUserResult = (TaskIndexUserResult) mRetrofitBaseCallBack;
            records.addAll(taskIndexUserResult.getData().getRecords());
            taskAdapter.notifyDataSetChanged();
            if (!taskIndexUserResult.getData().isMore()) {
                taskIndexUserBinding.xrvIndex.setPullLoadEnable(false);
            }
        } else {
            page = pageTemp;
        }
        if (records.size() == 0) {
            taskIndexUserBinding.rvTaskIndex.setVisibility(View.GONE);
            taskIndexUserBinding.includeEmptyView.lvBaseEmpty.setVisibility(View.VISIBLE);
        } else {
            taskIndexUserBinding.rvTaskIndex.setVisibility(View.VISIBLE);
            taskIndexUserBinding.includeEmptyView.lvBaseEmpty.setVisibility(View.GONE);
        }
    }

    public class TaskAdapter extends BaseRecycleAdapter {
        private List<TaskIndexUserRecord> records;
        private String type;
        private TaskIndexUserItemBinding taskIndexUserItemBinding;

        public TaskAdapter(List<?> mDatas, int layoutId, int brId) {
            super(mDatas, layoutId, brId);
            records = (List<TaskIndexUserRecord>) mDatas;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            super.onBindViewHolder(holder, position);
            type = records.get(position).getType();
            taskIndexUserItemBinding = (TaskIndexUserItemBinding) holder.getBinding();
            if (type.equals("1")) {
                taskIndexUserItemBinding.tvIndexTaskItemName.setBackgroundColor(ContextCompat.getColor(TaskIndexUserFragment.this.getActivity(), R.color.office_inspection_bg));
                taskIndexUserItemBinding.tvIndexTaskItemCode.setTextColor(ContextCompat.getColor(TaskIndexUserFragment.this.getActivity(), R.color.office_inspection_code_txt));
                taskIndexUserItemBinding.tvIndexTaskItemCode.setBackgroundResource(R.drawable.office_inspection_code_bg);
            } else if (type.equals("2")) {
                taskIndexUserItemBinding.tvIndexTaskItemName.setBackgroundColor(ContextCompat.getColor(TaskIndexUserFragment.this.getActivity(), R.color.integration_inspection_bg));
                taskIndexUserItemBinding.tvIndexTaskItemCode.setTextColor(ContextCompat.getColor(TaskIndexUserFragment.this.getActivity(), R.color.integration_inspection_code_txt));
                taskIndexUserItemBinding.tvIndexTaskItemCode.setBackgroundResource(R.drawable.integreation_inspection_code_bg);
            } else if (type.equals("3")) {
                taskIndexUserItemBinding.tvIndexTaskItemName.setBackgroundColor(ContextCompat.getColor(TaskIndexUserFragment.this.getActivity(), R.color.office_inspection_bg));
                taskIndexUserItemBinding.tvIndexTaskItemCode.setTextColor(ContextCompat.getColor(TaskIndexUserFragment.this.getActivity(), R.color.office_inspection_code_txt));
                taskIndexUserItemBinding.tvIndexTaskItemCode.setBackgroundResource(R.drawable.office_inspection_code_bg);
            }
        }
    }
}
