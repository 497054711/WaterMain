package com.cn.android.mvp;

/**
 * Created by Administrator on 2017/6/25.
 */

public interface IRecycleViewContainer {
    public void initXrvMessage();
    
    public void onRefresh();//刷新
    public void onLoadMore();//下一页

}
