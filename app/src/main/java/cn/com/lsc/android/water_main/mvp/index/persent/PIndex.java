package cn.com.lsc.android.water_main.mvp.index.persent;

import cn.com.lsc.android.water_main.mvp.BaseBean;
import cn.com.lsc.android.water_main.mvp.IOnDataListener;
import cn.com.lsc.android.water_main.mvp.index.model.IndexModel;
import cn.com.lsc.android.water_main.mvp.index.view.IIndexView;

/**
 * Created by Administrator on 2017/3/19.
 */

public class PIndex {
    private IIndexView iIndexView;
    private IndexModel indexModel;

    public PIndex(IIndexView iIndexView ) {
        this.iIndexView=iIndexView;
    }

    public void loginUser(){
        indexModel=new IndexModel(new IOnDataListener() {

            @Override
            public void onSuccess(BaseBean baseBean) {
                iIndexView.loginUser(baseBean);
            }

            @Override
            public void onFailed() {

            }
        });
        indexModel.loginUser();
    }
    public void loginAdmin(){
        indexModel=new IndexModel(new IOnDataListener() {

            @Override
            public void onSuccess(BaseBean baseBean) {
                iIndexView.loginAdmin(baseBean);
            }

            @Override
            public void onFailed() {

            }
        });
        indexModel.loginAdmin();
    }
}
