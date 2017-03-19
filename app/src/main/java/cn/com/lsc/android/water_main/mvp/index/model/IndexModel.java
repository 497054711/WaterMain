package cn.com.lsc.android.water_main.mvp.index.model;

/**
 * Created by Administrator on 2017/3/19.
 */

public class IndexModel implements IIndexModel {
    private IIndexListener iIndexListener;

    public IndexModel(IIndexListener iIndexListener) {
        this.iIndexListener=iIndexListener;
    }

    @Override
    public void loginUser() {
        iIndexListener.onSuccess();
    }

    @Override
    public void loginAdmin() {
        iIndexListener.onSuccess();
    }
}
