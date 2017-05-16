package com.cn.android.mvp.task.map.integrate;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import butterknife.BindView;
import com.cn.android.R;
import com.cn.android.mvp.BaseFragment;
import com.cn.android.mvp.task.map.pipe.present.TaskMapPipePresent;
import com.cn.android.mvp.task.map.pipe.view.ITaskMapPipeView;
import com.cn.android.utils.LoadLocalImageUtil;

/**
 * Created by Administrator on 2017/4/4.
 */

public class TaskMapIntegrateFragment extends BaseFragment implements ITaskMapPipeView, View.OnClickListener {

    @BindView(R.id.right)
    public ImageView right;
    @BindView(R.id.iv_map)
    ImageView ivMap;

    private TaskMapPipePresent taskMapPipePresent;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.task_map_pipe, null);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        taskMapPipePresent = new TaskMapPipePresent(this);
        right.setOnClickListener(this);
        right.setImageResource(R.drawable.icon_list);
        LoadLocalImageUtil.getInstance(this.getActivity()).displayFromDrawable(R.drawable.map02,ivMap);
        title.setText("Y161213514");
    }

    @Override
    public void changeMode() {
        this.getActivity().finish();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.right:
                taskMapPipePresent.changeMode();
                break;
        }
    }
}
