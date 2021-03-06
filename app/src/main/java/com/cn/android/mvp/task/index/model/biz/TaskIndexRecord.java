package com.cn.android.mvp.task.index.model.biz;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.cn.android.events.EventTask;
import com.cn.android.mvp.BaseBean;
import com.cn.android.mvp.BaseDisplayActivity;
import com.cn.android.mvp.task.detail.word.TaskDetailWordFragment;
import com.cn.android.mvp.task.index.model.IndexModel;
import com.cn.android.nethelp.ICallBackListener;
import com.cn.android.nethelp.Params;
import com.cn.android.nethelp.retrofit.RetrofitBaseCallBack;
import com.cn.android.widget.MyAlertDialog;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;
import java.util.Map;

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

    public void onDescription(View view) {//查看详情
        Toast.makeText(view.getContext(), getType(), Toast.LENGTH_SHORT).show();
        String type = getType();
        Intent intent = new Intent(view.getContext(), BaseDisplayActivity.class);
        intent.putExtra("class", TaskDetailWordFragment.class);
        view.getContext().startActivity(intent);
    }

    public void onGrabSingle(View view) {//抢单
        final MyAlertDialog myAlertDialog = new MyAlertDialog(view.getContext());
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

        Map<String, String> mParamsMap = new HashMap<>();
        mParamsMap.put("code",getCode());
        Params params = new Params();
        params.setMapParams(mParamsMap);

        IndexModel indexModel=new IndexModel(view.getContext());
        indexModel.taskDeal(new ICallBackListener() {
            @Override
            public void onSuccess(RetrofitBaseCallBack mRetrofitBaseCallBack) {
                myAlertDialog.setMsg(mRetrofitBaseCallBack.getMsg());
                myAlertDialog.show();
                EventBus.getDefault().post(new EventTask());
            }

            @Override
            public void onFaild(RetrofitBaseCallBack mRetrofitBaseCallBack) {
                myAlertDialog.setMsg(mRetrofitBaseCallBack.getMsg());
                myAlertDialog.show();
            }
        },params);


    }
}
