package com.cn.android.mvp.task.detail.integrate;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import com.cn.android.R;
import com.cn.android.mvp.BaseDisplayActivity;
import com.cn.android.mvp.BaseFragment;
import com.cn.android.mvp.task.detail.integrate.present.TaskDetailIntegratePresent;
import com.cn.android.mvp.task.detail.integrate.view.ITaskDetailIntegrateView;
import com.cn.android.mvp.task.map.integrate.TaskMapIntegrateFragment;
import com.cn.android.widget.MyAlertDialog;

/**
 * Created by Administrator on 2017/3/25.
 */

public class TaskDetailIntegrateFragment extends BaseFragment implements ITaskDetailIntegrateView,View.OnClickListener {
    @BindView(R.id.task_detail_grabSingle)
    TextView taskDetailGrabSingle;
    @BindView(R.id.right)
    public ImageView right;

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
        right.setImageResource(R.drawable.icon_gps);
        right.setOnClickListener(this);
        taskDetailGrabSingle.setOnClickListener(this);
        title.setText("Y161213514");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
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

    @Override
    public void changeMode() {
        Intent intent = new Intent(TaskDetailIntegrateFragment.this.getActivity(), BaseDisplayActivity.class);
        intent.putExtra("class", TaskMapIntegrateFragment.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.task_detail_grabSingle:
                taskDetailPresent.toGrabSingle();
                break;
            case R.id.right:
                taskDetailPresent.changeMode();
                break;
        }
    }
}
