package cn.com.lsc.android.water_main.mvp.index.persent;

import cn.com.lsc.android.water_main.mvp.index.model.IIndexListener;
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
        indexModel=new IndexModel(new IIndexListener() {
            @Override
            public void onSuccess() {
                iIndexView.loginUser();
            }

            @Override
            public void onFailed() {

            }
        });
        indexModel.loginUser();
    }
    public void loginAdmin(){
        indexModel=new IndexModel(new IIndexListener() {
            @Override
            public void onSuccess() {
                iIndexView.loginAdmin();
            }

            @Override
            public void onFailed() {

            }
        });
        indexModel.loginAdmin();
    }
}
