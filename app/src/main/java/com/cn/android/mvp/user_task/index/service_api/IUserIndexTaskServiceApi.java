package com.cn.android.mvp.user_task.index.service_api;

import com.cn.android.mvp.login.model.biz.LoginResult;
import com.cn.android.mvp.user_task.index.model.biz.UserTaskIndexBannerResult;
import com.cn.android.mvp.user_task.index.model.biz.UserTaskIndexTaskResult;

import java.util.Map;

import io.reactivex.Flowable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Administrator on 2017/5/13.
 */

public interface IUserIndexTaskServiceApi {

    //获取产品列表
    @FormUrlEncoded
//    @POST("common/pic/banner/home")
    @POST("wallet-mobile/api/v3.8/app/index/queryIndex?uuid=&userId=&userChannelType=Android&")
    Flowable<UserTaskIndexBannerResult> getBanner(@FieldMap Map<String, String> params);

    //获取产品列表
    @FormUrlEncoded
    @POST("user/task/list")
    Flowable<UserTaskIndexTaskResult> getTask(@FieldMap Map<String, String> params);

}
