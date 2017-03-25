package cn.com.lsc.android.water_main.mvp.task.detail.pipe;

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
import cn.com.lsc.android.water_main.mvp.task.detail.pipe.present.TaskDetailPipePresent;
import cn.com.lsc.android.water_main.mvp.task.detail.pipe.view.ITaskDetailPipeView;
import cn.com.lsc.android.water_main.widget.MyAlertDialog;

/**
 * Created by Administrator on 2017/3/25.
 */

public class TaskDetailPipeFragment extends BaseFragment implements ITaskDetailPipeView {
    @BindView(R.id.task_detail_grabSingle)
    TextView taskDetailGrabSingle;
    private TaskDetailPipePresent taskDetailPresent;
    private MyAlertDialog myAlertDialog;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.task_detail_pipe, null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        taskDetailPresent=new TaskDetailPipePresent(this);

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
        myAlertDialog = new MyAlertDialog(TaskDetailPipeFragment.this.getActivity());
        myAlertDialog.setMsg("抢单成功");
        myAlertDialog.setConfirmBtEnable(true);
        myAlertDialog.setNegativeBtEnable(false);
        myAlertDialog.setClickInterface(new MyAlertDialog.ClickInterface() {
            @Override
            public void clickSure() {
                myAlertDialog.dismiss();
                TaskDetailPipeFragment.this.getActivity().finish();
            }

            @Override
            public void clickCancel() {
                myAlertDialog.dismiss();
            }
        });
        myAlertDialog.show();
    }
}
