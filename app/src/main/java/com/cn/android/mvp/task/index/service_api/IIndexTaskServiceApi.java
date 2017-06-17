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

    //获取产品列表
    @FormUrlEncoded
    @POST("common/pic/banner/home")
    Flowable<TaskIndexBannerResult> getBanner(@FieldMap Map<String, String> params);

    //获取产品列表
    @FormUrlEncoded
    @POST("task/page")
    Flowable<TaskIndexResult> getTask(@FieldMap Map<String, String> params);

}
