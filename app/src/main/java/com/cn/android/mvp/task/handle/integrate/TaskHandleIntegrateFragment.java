package com.cn.android.mvp.task.handle.integrate;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cn.android.R;
import com.cn.android.mvp.BaseFragment;
import com.cn.android.mvp.task.handle.integrate.present.TaskHandleIntegratePresent;
import com.cn.android.mvp.task.handle.integrate.view.ITaskHandleIntegrateView;
import com.cn.android.widget.MyAlertDialog;

/**
 * Created by Administrator on 2017/3/25.
 */

public class TaskHandleIntegrateFragment extends BaseFragment implements ITaskHandleIntegrateView {
    private TaskHandleIntegratePresent taskDetailPresent;
    private MyAlertDialog myAlertDialog;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.task_handle_integrate, null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        taskDetailPresent=new TaskHandleIntegratePresent(this);
        title.setText("Y161213514");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

}
