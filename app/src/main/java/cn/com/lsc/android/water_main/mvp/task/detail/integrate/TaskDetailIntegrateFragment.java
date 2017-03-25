package cn.com.lsc.android.water_main.mvp.task.detail.integrate;

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
import cn.com.lsc.android.water_main.mvp.task.detail.integrate.present.TaskDetailIntegratePresent;
import cn.com.lsc.android.water_main.mvp.task.detail.integrate.view.ITaskDetailIntegrateView;
import cn.com.lsc.android.water_main.widget.MyAlertDialog;

/**
 * Created by Administrator on 2017/3/25.
 */

public class TaskDetailIntegrateFragment extends BaseFragment implements ITaskDetailIntegrateView {
    @BindView(R.id.task_detail_grabSingle)
    TextView taskDetailGrabSingle;
    private TaskDetailIntegratePresent taskDetailPresent;
    private MyAlertDialog myAlertDialog;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.task_detail_integrate, null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        taskDetailPresent=new TaskDetailIntegratePresent(this);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @OnClick(R.id.task_detail_grabSingle)
    public void toGrabSingle() {
        taskDetailPresent.toGrabSingle();
    }

    @Override
    public void grabSingle() {
        myAlertDialog = new MyAlertDialog(TaskDetailIntegrateFragment.this.getActivity());
        myAlertDialog.setMsg("抢单成功");
        myAlertDialog.setConfirmBtEnable(true);
        myAlertDialog.setNegativeBtEnable(false);
        myAlertDialog.setClickInterface(new MyAlertDialog.ClickInterface() {
            @Override
            public void clickSure() {
                myAlertDialog.dismiss();
                TaskDetailIntegrateFragment.this.getActivity().finish();
            }

            @Override
            public void clickCancel() {
                myAlertDialog.dismiss();
            }
        });
        myAlertDialog.show();
    }
}