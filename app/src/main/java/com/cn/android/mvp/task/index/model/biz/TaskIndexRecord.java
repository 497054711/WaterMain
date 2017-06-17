package com.cn.android.mvp.task.index.model.biz;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.cn.android.mvp.BaseBean;
import com.cn.android.mvp.BaseDisplayActivity;
import com.cn.android.mvp.task.detail.integrate.TaskDetailIntegrateFragment;
import com.cn.android.mvp.task.detail.pipe.TaskDetailPipeFragment;
import com.cn.android.widget.MyAlertDialog;

/**
 * Created by Administrator on 2017/6/11.
 */

public class TaskIndexRecord extends BaseBean {
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

    public void onDescription(View view) {
        Toast.makeText(view.getContext(), getType(), Toast.LENGTH_SHORT).show();
        String type = getType();
        //1:管道巡检,2:一体化巡检,3:其他；
        if (type.equals("1")) {
            Intent intent = new Intent(view.getContext(), BaseDisplayActivity.class);
            intent.putExtra("class", TaskDetailPipeFragment.class);
            view.getContext().startActivity(intent);
        } else if (type.equals("2")) {
            Intent intent = new Intent(view.getContext(), BaseDisplayActivity.class);
            intent.putExtra("class", TaskDetailIntegrateFragment.class);
            view.getContext().startActivity(intent);
        } else if (type.equals("3")) {
            Intent intent = new Intent(view.getContext(), BaseDisplayActivity.class);
            intent.putExtra("class", TaskDetailPipeFragment.class);
            view.getContext().startActivity(intent);
        }
    }

    public void onGrabSingle(View view) {
        final MyAlertDialog myAlertDialog = new MyAlertDialog(view.getContext());
        myAlertDialog.setMsg("已抢单，请在今日14：00前完成巡检");
        myAlertDialog.setConfirmBtEnable(true);
        myAlertDialog.setNegativeBtEnable(false);
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
}
