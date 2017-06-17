package com.cn.android.mvp.fault.index;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import com.cn.android.R;
import com.cn.android.mvp.BaseDisplayActivity;
import com.cn.android.mvp.BaseFragment;
import com.cn.android.mvp.fault.detail.cover.FaultDetailCoverFragment;
import com.cn.android.mvp.fault.index.present.IFaultIndexPresent;
import com.cn.android.mvp.fault.index.view.IFaultIndexView;
import com.cn.android.mvp.setting.SettingIndexFragment;

/**
 * Created by Administrator on 2017/3/20.管理员 巡检
 */

public class FaultIndexFragment extends BaseFragment implements IFaultIndexView, View.OnClickListener {

    @BindView(R.id.right)
    public ImageView right;
    @BindView(R.id.rv_index)
    RecyclerView rvIndex;

    private IFaultIndexPresent iFaultIndexPresent;
    private IndexAdapter indexAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fault_index, null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        title.setText("故障");
        back.setVisibility(View.GONE);
        iFaultIndexPresent = new IFaultIndexPresent(this);
        indexAdapter = new IndexAdapter();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
        rvIndex.setLayoutManager(layoutManager);
        rvIndex.setAdapter(indexAdapter);

    }

    @Override
    public void toIntegral() {
        Log.i("toIntegral", "Integral");
    }

    @Override
    public void toSetting() {
        Intent intent = new Intent(this.getActivity(), BaseDisplayActivity.class);
        intent.putExtra("class", SettingIndexFragment.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.right:
                iFaultIndexPresent.toSetting();
                break;
        }

    }

    public class IndexAdapter extends RecyclerView.Adapter<MyViewHolder> {

        private LayoutInflater inflater;

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            inflater = FaultIndexFragment.this.getActivity().getLayoutInflater();
            MyViewHolder holder = new MyViewHolder(inflater.inflate(R.layout.fault_index_item, parent, false));
            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, final int position) {
            if (position == 0) {
                holder.tvCode.setText("故障编号：82991");
                holder.tvTitle.setText("窨井盖丢失");
                holder.tvContent.setText("排污管线周桥至高速公路管理局段");
                holder.tvDate.setText("上报时间： 2016-12-25 12:10:12");
            } else if (position == 1) {
                holder.tvCode.setText("故障编号：82990");
                holder.tvTitle.setText("窨井盖损坏");
                holder.tvContent.setText("排污管线四惠街至七家庄东");
                holder.tvDate.setText("上报时间： 2016-12-26 12:09:10");
            }
            holder.lvRoot.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(FaultIndexFragment.this.getActivity(), BaseDisplayActivity.class);
                    intent.putExtra("class", FaultDetailCoverFragment.class);
                    startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return 2;
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_code)
        ImageView ivCode;
        @BindView(R.id.tv_code)
        TextView tvCode;
        @BindView(R.id.lv_code)
        LinearLayout lvCode;
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.tv_content)
        TextView tvContent;
        @BindView(R.id.tv_date)
        TextView tvDate;
        @BindView(R.id.lv_root)
        LinearLayout lvRoot;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
