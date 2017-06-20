package com.cn.android.mvp.task.index.service_api;

import com.cn.android.mvp.task.index.model.biz.TaskIndexBannerResult;
import com.cn.android.mvp.task.index.model.biz.TaskIndexResult;

import java.util.Map;

import io.reactivex.Flowable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Administrator on 2017/5/13.
 */

public interface IIndexTaskServiceApi {

    //获取banner
    @FormUrlEncoded
    @POST("common/pic/banner/home")
    Flowable<TaskIndexBannerResult> getBanner(@FieldMap Map<String, String> params);

    //获取首页任务
    @FormUrlEncoded
    @POST("task/page")
    Flowable<TaskIndexResult> getTask(@FieldMap Map<String, String> params);

    //处理任务
    @FormUrlEncoded
    @POST("user/task/process/deal")
    Flowable<TaskIndexResult> taskDeal(@FieldMap Map<String, String> params);

}
