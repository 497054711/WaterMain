package cn.com.lsc.android.water_main.mvp.record.index;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.com.lsc.android.water_main.R;
import cn.com.lsc.android.water_main.mvp.BaseDisplayActivity;
import cn.com.lsc.android.water_main.mvp.BaseFragment;
import cn.com.lsc.android.water_main.mvp.record.detail.fault.RecordDetailFaultFragment;
import cn.com.lsc.android.water_main.mvp.record.detail.integrate.RecordDetailIntegrateFragment;
import cn.com.lsc.android.water_main.mvp.record.detail.pipe.RecordDetailPipeFragment;
import cn.com.lsc.android.water_main.mvp.record.detail.traine.RecordDetailTraineFragment;
import cn.com.lsc.android.water_main.mvp.record.index.view.IRecordIndexView;

/**
 * 记录首页
 * Created by Administrator on 2017/3/25.
 */

public class RecordIndexFragment extends BaseFragment implements IRecordIndexView {

    @BindView(R.id.rv_record_index)
    RecyclerView rvRecordIndex;
    private RecordIndexAdapter recordIndexAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.record_index, null);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        title.setText("我的记录");
        back.setVisibility(View.GONE);
        recordIndexAdapter = new RecordIndexAdapter();
        rvRecordIndex.setAdapter(recordIndexAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
        rvRecordIndex.setLayoutManager(layoutManager);
        rvRecordIndex.setAdapter(recordIndexAdapter);
    }

    public class RecordIndexAdapter extends RecyclerView.Adapter<MyViewHolder> {

        private LayoutInflater inflater;

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            inflater = RecordIndexFragment.this.getActivity().getLayoutInflater();
            MyViewHolder holder = new MyViewHolder(inflater.inflate(R.layout.record_index_item, parent, false));
            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, final int position) {
            if (position == 0) {
                holder.tvIndexTaskItemCode.setText("管网巡检：G161213012");
                holder.ivIndexTaskItemCode.setImageResource(R.drawable.icon_pipe);
                holder.lvIndexTaskItemCode.setBackgroundColor(Color.parseColor("#55BC75"));
                holder.tvIndexTaskItemTitle.setText("排污管线周桥至高速公路管理局");

            } else if (position == 1) {
                holder.tvIndexTaskItemCode.setText("一体化巡检：Y161213514");
                holder.ivIndexTaskItemCode.setImageResource(R.drawable.icon_inte);
                holder.lvIndexTaskItemCode.setBackgroundColor(Color.parseColor("#EB6740"));
                holder.tvIndexTaskItemTitle.setText("大崔庄一体化排污箱");

            } else if (position == 2) {
                holder.tvIndexTaskItemCode.setText("上报故障：9201");
                holder.ivIndexTaskItemCode.setImageResource(R.drawable.icon_faultd);
                holder.lvIndexTaskItemCode.setBackgroundColor(Color.parseColor("#EBC95E"));
                holder.tvIndexTaskItemTitle.setText("水洼子小水泵管道破裂了");
            } else if (position == 3) {
                holder.tvIndexTaskItemCode.setText("培训记录");
                holder.ivIndexTaskItemCode.setImageResource(R.drawable.icon_trained);
                holder.lvIndexTaskItemCode.setBackgroundColor(Color.parseColor("#5EA0EB"));
                holder.tvIndexTaskItemTitle.setText("一体化设备检查规范");
            }
            holder.root.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (position == 0) {
                        Intent intent = new Intent(RecordIndexFragment.this.getActivity(), BaseDisplayActivity.class);
                        intent.putExtra("class", RecordDetailPipeFragment.class);
                        startActivity(intent);
                    }else if(position == 1){
                        Intent intent = new Intent(RecordIndexFragment.this.getActivity(), BaseDisplayActivity.class);
                        intent.putExtra("class", RecordDetailIntegrateFragment.class);
                        startActivity(intent);
                    }else if(position == 2){
                        Intent intent = new Intent(RecordIndexFragment.this.getActivity(), BaseDisplayActivity.class);
                        intent.putExtra("class", RecordDetailFaultFragment.class);
                        startActivity(intent);
                    }else if(position == 3){
                        Intent intent = new Intent(RecordIndexFragment.this.getActivity(), BaseDisplayActivity.class);
                        intent.putExtra("class", RecordDetailTraineFragment.class);
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
        @BindView(R.id.root)
        LinearLayout root;
        @BindView(R.id.iv_index_task_item_code)
        ImageView ivIndexTaskItemCode;
        @BindView(R.id.tv_index_task_item_code)
        TextView tvIndexTaskItemCode;
        @BindView(R.id.lv_index_task_item_code)
        LinearLayout lvIndexTaskItemCode;
        @BindView(R.id.tv_index_task_item_title)
        TextView tvIndexTaskItemTitle;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
