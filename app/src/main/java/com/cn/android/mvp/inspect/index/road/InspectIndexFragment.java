package com.cn.android.mvp.inspect.index.road;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import com.cn.android.R;
import com.cn.android.mvp.BaseDisplayActivity;
import com.cn.android.mvp.BaseFragment;
import com.cn.android.mvp.inspect.detail.pipe.InspectDetailPipeFragment;
import com.cn.android.mvp.inspect.detail.pipe_grab_single.InspectDetailPipeGrabSingleFragment;
import com.cn.android.mvp.inspect.index.map.InspectIndexMapFragment;
import com.cn.android.mvp.inspect.index.road.present.InspecIndexPresent;
import com.cn.android.mvp.inspect.index.road.view.IInspectIndexView;

/**
 * Created by Administrator on 2017/3/20.管理员 巡检
 */

public class InspectIndexFragment extends BaseFragment implements IInspectIndexView, View.OnClickListener {

    @BindView(R.id.right)
    public ImageView right;
    @BindView(R.id.rv_index)
    RecyclerView rvIndex;

    private InspecIndexPresent inspecIndexPresent;
    private IndexAdapter indexAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.inspect_index, null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        title.setText("巡检线路");
        back.setVisibility(View.GONE);
        right.setImageResource(R.drawable.icon_gps);
        right.setOnClickListener(this);
        inspecIndexPresent = new InspecIndexPresent(this);
        indexAdapter = new IndexAdapter();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
        rvIndex.setLayoutManager(layoutManager);
        rvIndex.setAdapter(indexAdapter);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.right:
                inspecIndexPresent.changeMode();
                break;
        }

    }

    @Override
    public void changeMode() {
        Intent intent = new Intent(InspectIndexFragment.this.getActivity(), BaseDisplayActivity.class);
        intent.putExtra("class", InspectIndexMapFragment.class);
        startActivity(intent);
    }

    public class IndexAdapter extends RecyclerView.Adapter<MyViewHolder> {

        private LayoutInflater inflater;

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            inflater = InspectIndexFragment.this.getActivity().getLayoutInflater();
            MyViewHolder holder = new MyViewHolder(inflater.inflate(R.layout.inspect_index_item, parent, false));
            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, final int position) {
            if (position == 0) {
                holder.tvCode.setText("管网巡检：G161213012");
                holder.ivCode.setImageResource(R.drawable.icon_pipe);
                holder.tvTitle.setText("排污管线周桥至高速公路管理局");
                holder.tvContent.setText("起：周桥 -- 止：高速公路管理局");
                holder.tvStatus.setText("巡检中");
                holder.progressHorizontal.setProgress(50);
            } else if (position == 1) {
                holder.tvCode.setText("一体化巡检：Y161213514");
                holder.ivCode.setImageResource(R.drawable.icon_inte);
                holder.tvTitle.setText("排污管线四惠街至七家庄东");
                holder.tvContent.setText("起：四惠街45号 -- 止：七家庄东55号");
                holder.tvStatus.setText("已接单");
                holder.progressHorizontal.setProgress(10);
            } else if (position == 2) {
                holder.tvCode.setText("管网巡检：G161213016");
                holder.ivCode.setImageResource(R.drawable.icon_pipe);
                holder.tvTitle.setText("排污管线龙江小区北门至门庙坡");
                holder.tvContent.setText("起：龙江小区北门 -- 止：门庙坡");
                holder.tvStatus.setText("等待接单");
                holder.progressHorizontal.setProgress(0);
            } else if (position == 3) {
                holder.tvCode.setText("一体化巡检：Y161213514");
                holder.ivCode.setImageResource(R.drawable.icon_inte);
                holder.tvTitle.setText("排污管线沈大坝南角至水西门桥段");
                holder.tvContent.setText("起：沈大坝南角 -- 止：水西门桥");
                holder.tvStatus.setText("已完成");
                holder.progressHorizontal.setProgress(100);
            }
            holder.lvRoot.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(position!=2){
                        Intent intent = new Intent(InspectIndexFragment.this.getActivity(), BaseDisplayActivity.class);
                        intent.putExtra("class", InspectDetailPipeFragment.class);
                        startActivity(intent);
                    }else{
                        Intent intent = new Intent(InspectIndexFragment.this.getActivity(), BaseDisplayActivity.class);
                        intent.putExtra("class", InspectDetailPipeGrabSingleFragment.class);
                        startActivity(intent);
                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            return 4;
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.lv_root)
        LinearLayout lvRoot;
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
        @BindView(R.id.tv_status)
        TextView tvStatus;
        @BindView(R.id.progress_horizontal)
        ProgressBar progressHorizontal;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
