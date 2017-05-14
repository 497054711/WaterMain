package com.cn.watermain.mvp.record.detail.integrate;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cn.watermain.R;
import com.cn.watermain.mvp.BaseFragment;
import com.cn.watermain.mvp.record.detail.integrate.present.RecordDetailIntegratePresent;
import com.cn.watermain.mvp.record.detail.integrate.view.IRecordDetailIntegrateView;
import com.cn.watermain.widget.MyAlertDialog;

/**
 * Created by Administrator on 2017/3/25.
 */

public class RecordDetailIntegrateFragment extends BaseFragment implements IRecordDetailIntegrateView {

    private RecordDetailIntegratePresent taskDetailPresent;
    private MyAlertDialog myAlertDialog;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.record_detail_integrate, null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        taskDetailPresent=new RecordDetailIntegratePresent(this);
        title.setText("报告详情");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void grabSingle() {
        myAlertDialog = new MyAlertDialog(RecordDetailIntegrateFragment.this.getActivity());
        myAlertDialog.setMsg("抢单成功");
        myAlertDialog.setConfirmBtEnable(true);
        myAlertDialog.setNegativeBtEnable(false);
        myAlertDialog.setClickInterface(new MyAlertDialog.ClickInterface() {
            @Override
            public void clickSure() {
                myAlertDialog.dismiss();
                RecordDetailIntegrateFragment.this.getActivity().finish();
            }

            @Override
            public void clickCancel() {
                myAlertDialog.dismiss();
            }
        });
        myAlertDialog.show();
    }
}
