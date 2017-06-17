package com.cn.android.mvp.task.index.model.biz;

import com.cn.android.mvp.BaseBean;

import java.util.List;

/**
 * Created by Administrator on 2017/6/11.
 */

public class TaskIndexData extends BaseBean {
    private List<TaskIndexRecord> records;
    private boolean isMore;

    public List<TaskIndexRecord> getRecords() {
        return records;
    }

    public void setRecords(List<TaskIndexRecord> records) {
        this.records = records;
    }

    public boolean isMore() {
        return isMore;
    }

    public void setMore(boolean more) {
        isMore = more;
    }
}
