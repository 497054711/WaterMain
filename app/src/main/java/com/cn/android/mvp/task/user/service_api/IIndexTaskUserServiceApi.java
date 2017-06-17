package com.cn.android.mvp.task.user.service_api;

import com.cn.android.mvp.task.user.model.biz.TaskIndexUserResult;

import java.util.Map;

import io.reactivex.Flowable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Administrator on 2017/5/13.
 */

public interface IIndexTaskUserServiceApi {

    //获取产品列表
    @FormUrlEncoded
    @POST("user/task/page")
    Flowable<TaskIndexUserResult> getTask(@FieldMap Map<String, String> params);

}
