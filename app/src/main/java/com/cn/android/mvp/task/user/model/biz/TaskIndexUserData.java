package com.cn.android.mvp.task.user.model.biz;

import com.cn.android.mvp.BaseBean;

import java.util.List;

/**
 * Created by Administrator on 2017/6/11.
 */

public class TaskIndexUserData extends BaseBean {
    private List<TaskIndexUserRecord> records;
    private boolean isMore;

    public List<TaskIndexUserRecord> getRecords() {
        return records;
    }

    public void setRecords(List<TaskIndexUserRecord> records) {
        this.records = records;
    }

    public boolean isMore() {
        return isMore;
    }

    public void setMore(boolean more) {
        isMore = more;
    }
}
