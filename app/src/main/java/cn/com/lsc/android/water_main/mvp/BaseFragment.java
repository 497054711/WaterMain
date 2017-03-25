package cn.com.lsc.android.water_main.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import cn.com.lsc.android.water_main.R;

/**
 * Created by Administrator on 2017/3/11.
 */

public class BaseFragment extends Fragment {
    @BindView(R.id.title)
    public TextView title;
    @BindView(R.id.back)
    public ImageView back;
    private Unbinder unbinder;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        unbinder= ButterKnife.bind(this, this.getView());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.back)
    public void goBack() {
        this.getActivity().finish();
    }
}
