package com.cn.android.mvp.task.index.model.biz;

import com.cn.android.mvp.BaseBean;

import java.util.List;

/**
 * Created by Administrator on 2017/6/11.
 */

public class TaskIndexTaskData extends BaseBean {
    private List<TaskIndexTaskRecord> records;
    private boolean isMore;

    public List<TaskIndexTaskRecord> getRecords() {
        return records;
    }

    public void setRecords(List<TaskIndexTaskRecord> records) {
        this.records = records;
    }

    public boolean isMore() {
        return isMore;
    }

    public void setMore(boolean more) {
        isMore = more;
    }
}
