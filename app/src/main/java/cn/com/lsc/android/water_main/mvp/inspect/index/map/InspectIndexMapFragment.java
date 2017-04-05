package cn.com.lsc.android.water_main.mvp.inspect.index.map;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import butterknife.BindView;
import cn.com.lsc.android.water_main.R;
import cn.com.lsc.android.water_main.mvp.BaseFragment;
import cn.com.lsc.android.water_main.mvp.inspect.index.map.present.InspectIndexMapPresent;
import cn.com.lsc.android.water_main.mvp.inspect.index.map.view.IInspectIndexMapView;
import cn.com.lsc.android.water_main.utils.LoadLocalImageUtil;

/**
 * Created by Administrator on 2017/4/4.
 */

public class InspectIndexMapFragment extends BaseFragment implements IInspectIndexMapView, View.OnClickListener {

    @BindView(R.id.right)
    public ImageView right;
    @BindView(R.id.iv_map)
    ImageView ivMap;

    private InspectIndexMapPresent taskMapPipePresent;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.task_map_pipe, null);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        taskMapPipePresent = new InspectIndexMapPresent(this);
        right.setOnClickListener(this);
        right.setImageResource(R.drawable.icon_list);
        LoadLocalImageUtil.getInstance(this.getActivity()).displayFromDrawable(R.drawable.map03,ivMap);
        title.setText("G161213012");
    }

    @Override
    public void changeMode() {
        this.getActivity().finish();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.right:
                taskMapPipePresent.changeMode();
                break;
        }
    }
}
