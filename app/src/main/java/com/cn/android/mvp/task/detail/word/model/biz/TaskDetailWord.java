package com.cn.android.mvp.task.detail.word.model.biz;

import android.content.Intent;
import android.view.View;

import com.cn.android.mvp.BaseBean;
import com.cn.android.mvp.BaseDisplayActivity;
import com.cn.android.mvp.task.handle.integrate.TaskHandleIntegrateFragment;
import com.cn.android.mvp.task.handle.pipe.TaskHandlePipeFragment;
import com.cn.android.widget.MyAlertDialog;

/**
 * Created by Administrator on 2017/6/11.
 */

public class TaskDetailWord extends BaseBean {
    private String code;
    private String deadlineDate;
    private String description;
    private String endAddress;
    private int expectDuration;
    private float kilometers;
    private String name;
    private String startAddress;
    private String status;
    private String type;
    private int presetTime;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDeadlineDate() {
        return deadlineDate;
    }

    public void setDeadlineDate(String deadlineDate) {
        this.deadlineDate = deadlineDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEndAddress() {
        return endAddress;
    }

    public void setEndAddress(String endAddress) {
        this.endAddress = endAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartAddress() {
        return startAddress;
    }

    public void setStartAddress(String startAddress) {
        this.startAddress = startAddress;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getExpectDuration() {
        return expectDuration;
    }

    public void setExpectDuration(int expectDuration) {
        this.expectDuration = expectDuration;
    }

    public float getKilometers() {
        return kilometers;
    }

    public void setKilometers(float kilometers) {
        this.kilometers = kilometers;
    }

    public int getPresetTime() {
        return presetTime;
    }

    public void setPresetTime(int presetTime) {
        this.presetTime = presetTime;
    }

    //放弃任务
    public void onGiveUp(View view) {
        final MyAlertDialog myAlertDialog = new MyAlertDialog(view.getContext());
        myAlertDialog.setMsg("放弃任务有可能扣除积分，确认放弃？");
        myAlertDialog.setConfirmBtEnable(true);
        myAlertDialog.setNegativeBtEnable(true);
        myAlertDialog.setClickInterface(new MyAlertDialog.ClickInterface() {
            @Override
            public void clickSure() {
                myAlertDialog.dismiss();
            }

            @Override
            public void clickCancel() {
                myAlertDialog.dismiss();
            }
        });
        myAlertDialog.show();
    }

    //开始巡检
    public void onInspection(View view) {
        String type=getType();
        if (type.equals("1")) {
            Intent intent = new Intent(view.getContext(), BaseDisplayActivity.class);
            intent.putExtra("class", TaskHandlePipeFragment.class);
            view.getContext().startActivity(intent);
        } else if (type.equals("2")) {
            Intent intent = new Intent(view.getContext(), BaseDisplayActivity.class);
            intent.putExtra("class", TaskHandleIntegrateFragment.class);
            view.getContext().startActivity(intent);
        } else if (type.equals("3")) {
            Intent intent = new Intent(view.getContext(), BaseDisplayActivity.class);
            intent.putExtra("class", TaskHandlePipeFragment.class);
            view.getContext().startActivity(intent);
        }
    }
}
