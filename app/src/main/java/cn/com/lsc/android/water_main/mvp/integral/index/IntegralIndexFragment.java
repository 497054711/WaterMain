package cn.com.lsc.android.water_main.mvp.integral.index;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.com.lsc.android.water_main.R;
import cn.com.lsc.android.water_main.mvp.BaseDisplayActivity;
import cn.com.lsc.android.water_main.mvp.BaseFragment;
import cn.com.lsc.android.water_main.mvp.integral.exchange.IntegralExchangeFragment;
import cn.com.lsc.android.water_main.mvp.integral.index.biz.IntegralIndexBean;
import cn.com.lsc.android.water_main.mvp.integral.index.model.IntegralIndexModel;
import cn.com.lsc.android.water_main.mvp.integral.index.present.IntegralIndexPresent;
import cn.com.lsc.android.water_main.mvp.integral.index.view.IIntegralIndexView;

/**
 * Created by Administrator on 2017/3/24.
 * 积分
 */

public class IntegralIndexFragment extends BaseFragment implements IIntegralIndexView, View.OnClickListener {
    @BindView(R.id.right)
    ImageView right;
    @BindView(R.id.integralIndex_exchange300)
    TextView integralIndexExchange300;
    @BindView(R.id.integralIndex_exchange500)
    TextView integralIndexExchange500;
    Unbinder unbinder;
    private IntegralIndexModel integralIndexModel;
    private IntegralIndexPresent integralIndexPresent;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.integral_index, null);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        title.setText("积分");
        back.setVisibility(View.GONE);
        integralIndexExchange300.setOnClickListener(this);
        integralIndexExchange500.setOnClickListener(this);
        integralIndexModel = new IntegralIndexModel();
        integralIndexPresent = new IntegralIndexPresent(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.integralIndex_exchange300:
                IntegralIndexBean integralIndexBean = new IntegralIndexBean();
                integralIndexBean.setTitle("100元手机话费兑换");
                integralIndexBean.setDescrption("兑换将消耗300积分");
                integralIndexPresent.exchange(integralIndexBean);
                break;
            case R.id.integralIndex_exchange500:
                IntegralIndexBean integralIndexBean1 = new IntegralIndexBean();
                integralIndexBean1.setTitle("300元手机话费兑换");
                integralIndexBean1.setDescrption("兑换将消耗500积分");
                integralIndexPresent.exchange(integralIndexBean1);
                break;
        }
    }

    @Override
    public void goToExchange(IntegralIndexBean integralIndexBean) {
        Intent intent = new Intent(this.getActivity(), BaseDisplayActivity.class);
        intent.putExtra("integralIndexBean", (Serializable) integralIndexBean);
        intent.putExtra("class", IntegralExchangeFragment.class);
        startActivity(intent);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
