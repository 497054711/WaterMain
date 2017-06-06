package com.cn.android.nethelp.retrofit;

/**
 * Author:zcmain on 2016/5/13 13:38
 * E-Mail:zcmain@163.com
 * 说明：统一回调实体
 * ｛"resCode":"200","resMsg":"请求成功","resObj":obj｝
 */
public class RetrofitBaseCallBack {
    private String msg;
    private int ret;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }
}
