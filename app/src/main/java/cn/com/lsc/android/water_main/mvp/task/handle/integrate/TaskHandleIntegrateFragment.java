package cn.com.lsc.android.water_main.mvp.task.handle.integrate;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import cn.com.lsc.android.water_main.R;
import cn.com.lsc.android.water_main.mvp.BaseFragment;
import cn.com.lsc.android.water_main.mvp.task.handle.integrate.present.TaskHandleIntegratePresent;
import cn.com.lsc.android.water_main.mvp.task.handle.integrate.view.ITaskHandleIntegrateView;
import cn.com.lsc.android.water_main.widget.MyAlertDialog;

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
