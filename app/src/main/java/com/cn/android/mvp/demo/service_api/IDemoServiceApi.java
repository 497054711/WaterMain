package com.cn.android.mvp.demo.service_api;

import java.util.Map;

import io.reactivex.Flowable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Administrator on 2017/5/13.
 */

public interface IDemoServiceApi {

    //获取产品列表
    @FormUrlEncoded
    @POST("/Android/requestKeyValue.action")
    Flowable<String> getDemo(@FieldMap Map<String, String> params);
}
