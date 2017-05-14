package cn.com.lsc.android.water_main.nethelp.retrofit;

/**
 * Author:zcmain on 2016/5/13 13:38
 * E-Mail:zcmain@163.com
 * 说明：统一回调实体
 * ｛"resCode":"200","resMsg":"请求成功","resObj":obj｝
 */
public class RetrofitBaseCallBack {
    String resCode;
    String resMsg;
    Object resObj;

    public String getResCode() {
        return resCode;
    }

    public void setResCode(String resCode) {
        this.resCode = resCode;
    }

    public String getResMsg() {
        return resMsg;
    }

    public void setResMsg(String resMsg) {
        this.resMsg = resMsg;
    }

    public Object getResObj() {
        return resObj;
    }

    public void setResObj(Object resObj) {
        this.resObj = resObj;
    }
}
