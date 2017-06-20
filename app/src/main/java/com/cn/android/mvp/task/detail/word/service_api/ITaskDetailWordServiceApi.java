package com.cn.android.mvp.task.detail.word.service_api;

import com.cn.android.mvp.task.detail.word.model.biz.TaskDetailWordResult;

import java.util.Map;

import io.reactivex.Flowable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Administrator on 2017/5/13.
 */

public interface ITaskDetailWordServiceApi {

    //获取产品列表
    @FormUrlEncoded
    @POST(" user/task/123")
    Flowable<TaskDetailWordResult> getTaskDetail(@FieldMap Map<String, String> params);

}
