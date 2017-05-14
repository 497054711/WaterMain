package com.cn.watermain.mvp.integral.exchange;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import com.cn.watermain.R;
import com.cn.watermain.mvp.BaseFragment;
import com.cn.watermain.mvp.integral.exchange.present.IntegralExchangePresent;
import com.cn.watermain.mvp.integral.exchange.view.IIntegralExchangeView;
import com.cn.watermain.mvp.integral.index.biz.IntegralIndexBean;
import com.cn.watermain.widget.MyAlertDialog;
import com.cn.watermain.widget.ToastUtil;

/**
 * Created by Administrator on 2017/3/24.
 */

public class IntegralExchangeFragment extends BaseFragment implements IIntegralExchangeView{

    @BindView(R.id.tv_integral_exchange_title)
    public TextView tv_integral_exchange_title;
    @BindView(R.id.tv_integral_exchange_description)
    public TextView tv_integral_exchange_description;
    @BindView(R.id.tv_integral_exchange_phone)
    public EditText tv_integral_exchange_phone;

    private IntegralExchangePresent integralExchangePresent;
    private IntegralIndexBean integralIndexBean;
    private MyAlertDialog myAlertDialog;

    private Bundle arguments;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.integral_exchange,null);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        arguments=this.getArguments();
        title.setText("积分兑换");
        integralIndexBean= (IntegralIndexBean) arguments.getSerializable("integralIndexBean");
        tv_integral_exchange_title.setText(integralIndexBean.getTitle());
        tv_integral_exchange_description.setText(integralIndexBean.getDescrption());
        integralExchangePresent=new IntegralExchangePresent(this);
    }

    @OnClick(R.id.tv_integralIndex_exchange)
    public void goToExchange(){
        integralExchangePresent.exchange();
    }
    @Override
    public void exchange() {
        if(tv_integral_exchange_phone.getEditableText().toString().equals("")){
            ToastUtil.showToast(this.getActivity(),"请输入手机号");
            return;
        }
        myAlertDialog=new MyAlertDialog(IntegralExchangeFragment.this.getActivity());
        myAlertDialog.setMsg("兑换成功");
        myAlertDialog.setConfirmBtEnable(true);
        myAlertDialog.setNegativeBtEnable(false);
        myAlertDialog.setClickInterface(new MyAlertDialog.ClickInterface() {
            @Override
            public void clickSure() {
                myAlertDialog.dismiss();
                IntegralExchangeFragment.this.getActivity().finish();
            }

            @Override
            public void clickCancel() {
            }
        });
        myAlertDialog.show();
    }
}
