package com.cn.android.mvp.user_task.index;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

import com.cn.android.BR;
import com.cn.android.R;
import com.cn.android.adapter.BaseRecycleAdapter;
import com.cn.android.databinding.UserTaskIndexBinding;
import com.cn.android.databinding.WaterMainTitleBinding;
import com.cn.android.mvp.BaseDisplayActivity;
import com.cn.android.mvp.BaseFragment;
import com.cn.android.mvp.IBaseTitleView;
import com.cn.android.mvp.setting.SettingIndexFragment;
import com.cn.android.mvp.task.detail.integrate.TaskDetailIntegrateFragment;
import com.cn.android.mvp.task.detail.pipe.TaskDetailPipeFragment;
import com.cn.android.mvp.user_task.index.model.biz.UserTaskIndexTaskRecord;
import com.cn.android.mvp.user_task.index.present.IIndexPresent;
import com.cn.android.mvp.user_task.index.present.IndexPresent;
import com.cn.android.mvp.user_task.index.view.IIndexView;
import com.cn.android.nethelp.Params;
import com.cn.android.nethelp.retrofit.RetrofitBaseCallBack;
import com.cn.android.widget.MyAlertDialog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/20.
 */

public class IndexFragment extends BaseFragment implements IIndexView, IBaseTitleView {

    private BaseRecycleAdapter baseRecycleAdapter;
    private UserTaskIndexBinding userTaskIndexBinding;
    private WaterMainTitleBinding waterMainTitleBinding;
    private IIndexPresent iIndexPresent;
    private List<UserTaskIndexTaskRecord> records;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        userTaskIndexBinding = DataBindingUtil.inflate(inflater, R.layout.user_task_index, container, false);
        return userTaskIndexBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        title.setText("首页");
        userTaskIndexBinding.includeWaterMainTitle.back.setVisibility(View.GONE);
        userTaskIndexBinding.includeWaterMainTitle.right.setImageResource(R.drawable.index_setting);
        userTaskIndexBinding.setIndexView(this);
        waterMainTitleBinding = userTaskIndexBinding.includeWaterMainTitle;
        waterMainTitleBinding.setBaseTitleView(this);

        iIndexPresent = new IndexPresent(this.getActivity(), this);
        records=new ArrayList<>();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
        userTaskIndexBinding.rvIndex.setLayoutManager(layoutManager);
        baseRecycleAdapter = new BaseRecycleAdapter(records, R.layout.user_task_index_task_item, BR.userTaskIndexTaskRecord);
        userTaskIndexBinding.rvIndex.setAdapter(baseRecycleAdapter);
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
        Map map = new HashMap();
        Params paramsTask = new Params();
        paramsTask.setMapParams(map);
        iIndexPresent.task(paramsTask);
    }

    @Override
    public void upDateTask(RetrofitBaseCallBack mRetrofitBaseCallBack) {

    }

    @Override
    public void upDateBanner(RetrofitBaseCallBack mRetrofitBaseCallBack) {

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
}
