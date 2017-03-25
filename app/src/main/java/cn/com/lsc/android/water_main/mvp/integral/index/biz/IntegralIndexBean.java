package cn.com.lsc.android.water_main.mvp.integral.index.biz;

import cn.com.lsc.android.water_main.mvp.BaseBean;

/**
 * Created by Administrator on 2017/3/24.
 */

public class IntegralIndexBean extends BaseBean {
    private String title;
    private String descrption;
    private int type;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescrption() {
        return descrption;
    }

    public void setDescrption(String descrption) {
        this.descrption = descrption;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
