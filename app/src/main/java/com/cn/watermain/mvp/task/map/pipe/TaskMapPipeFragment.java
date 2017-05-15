package com.cn.watermain.mvp.task.map.pipe;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import butterknife.BindView;
import com.cn.watermain.R;
import com.cn.watermain.mvp.BaseFragment;
import com.cn.watermain.mvp.task.map.pipe.present.TaskMapPipePresent;
import com.cn.watermain.mvp.task.map.pipe.view.ITaskMapPipeView;
import com.cn.watermain.utils.LoadLocalImageUtil;

/**
 * Created by Administrator on 2017/4/4.
 */

public class TaskMapPipeFragment extends BaseFragment implements ITaskMapPipeView, View.OnClickListener {

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
        LoadLocalImageUtil.getInstance(this.getActivity()).displayFromDrawable(R.drawable.map01,ivMap);
        title.setText("G161213012");
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