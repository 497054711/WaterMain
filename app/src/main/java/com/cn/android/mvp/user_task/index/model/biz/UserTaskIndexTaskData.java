package com.cn.android.mvp.user_task.index.model.biz;

import com.cn.android.mvp.BaseBean;

import java.util.List;

/**
 * Created by Administrator on 2017/6/11.
 */

public class UserTaskIndexTaskData extends BaseBean {
    private List<UserTaskIndexTaskRecord> records;
    private boolean isMore;

    public List<UserTaskIndexTaskRecord> getRecords() {
        return records;
    }

    public void setRecords(List<UserTaskIndexTaskRecord> records) {
        this.records = records;
    }

    public boolean isMore() {
        return isMore;
    }

    public void setMore(boolean more) {
        isMore = more;
    }
}
