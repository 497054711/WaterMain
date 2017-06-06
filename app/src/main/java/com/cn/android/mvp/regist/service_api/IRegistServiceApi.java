package com.cn.android.mvp.regist.service_api;

import com.cn.android.mvp.regist.model.biz.RegistResult;
import com.cn.android.mvp.regist.model.biz.SendNoticeResult;

import java.util.Map;

import io.reactivex.Flowable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Administrator on 2017/5/13.
 */

public interface IRegistServiceApi {

    //获取产品列表
    @FormUrlEncoded
    @POST("/user/register")
    Flowable<RegistResult> regist(@FieldMap Map<String, String> params);

    //获取产品列表
    @FormUrlEncoded
    @POST("user/sendRegisterSMSNotice")
    Flowable<SendNoticeResult> sendNotice(@FieldMap Map<String, String> params);
}
