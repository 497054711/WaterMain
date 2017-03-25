package cn.com.lsc.android.water_main.mvp.report;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.com.lsc.android.water_main.R;
import cn.com.lsc.android.water_main.mvp.BaseFragment;
import cn.com.lsc.android.water_main.mvp.report.index.view.IReportIndexView;

/**
 * Created by Administrator on 2017/3/25.
 */

public class ReportIndexFragment extends BaseFragment implements IReportIndexView {
    @BindView(R.id.report_index_addPic)
    ImageView reportIndexAddPic;
    @BindView(R.id.report_index_record)
    TextView reportIndexRecord;
    @BindView(R.id.report_index_confirm)
    TextView reportIndexConfirm;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.report_index, null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        title.setText("报告");
        back.setVisibility(View.GONE);
    }
}
