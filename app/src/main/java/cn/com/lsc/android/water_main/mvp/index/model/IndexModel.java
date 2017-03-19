package cn.com.lsc.android.water_main.mvp.index.model;

import cn.com.lsc.android.water_main.mvp.BaseBean;
import cn.com.lsc.android.water_main.mvp.IOnDataListener;

/**
 * Created by Administrator on 2017/3/19.
 */

public class IndexModel implements IIndexModel {
    private IOnDataListener iOnDataListener;

    public IndexModel(IOnDataListener iOnDataListener) {
        this.iOnDataListener = iOnDataListener;
    }

    @Override
    public void loginUser() {
        iOnDataListener.onSuccess(new BaseBean());
    }

    @Override
    public void loginAdmin() {
        iOnDataListener.onSuccess(new BaseBean());
    }
}
