package cn.com.lsc.android.water_main.mvp.task.index;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.com.lsc.android.water_main.R;
import cn.com.lsc.android.water_main.mvp.BaseDisplayActivity;
import cn.com.lsc.android.water_main.mvp.BaseFragment;
import cn.com.lsc.android.water_main.mvp.task.handle.integrate.TaskHandleIntegrateFragment;
import cn.com.lsc.android.water_main.mvp.task.handle.pipe.TaskHandlePipeFragment;
import cn.com.lsc.android.water_main.mvp.task.index.view.ITaskIndexView;
import cn.com.lsc.android.water_main.widget.MyAlertDialog;

/**
 * Created by Administrator on 2017/3/22.
 */

public class TaskIndexFragment extends BaseFragment implements ITaskIndexView {
    @BindView(R.id.rv_task_index)
    RecyclerView rvTaskIndex;

    private ListView task_index_list;
    private TextView title;
    private ImageView back;
    private TaskIndexAdapter taskIndexAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.task_index, null);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        title = (TextView) this.getView().findViewById(R.id.title);
        title.setText("任务");
        back = (ImageView) this.getView().findViewById(R.id.back);
        back.setVisibility(View.GONE);
        taskIndexAdapter = new TaskIndexAdapter();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
        rvTaskIndex.setLayoutManager(layoutManager);
        rvTaskIndex.setAdapter(taskIndexAdapter);
    }

    public class TaskIndexAdapter extends RecyclerView.Adapter<MyViewHolder>{
        private MyAlertDialog myAlertDialog;
        private LayoutInflater inflater;
        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            inflater = TaskIndexFragment.this.getActivity().getLayoutInflater();
            MyViewHolder holder = new MyViewHolder(inflater.inflate(R.layout.task_index_item, parent, false));
            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, final int position) {
            if (position == 0) {
                holder.tvIndexTaskItemCode.setText("管网巡检：G161213012");
                holder.ivIndexTaskItemCode.setImageResource(R.drawable.icon_pipe);
                holder.lvIndexTaskItemCode.setBackgroundColor(Color.parseColor("#55BC75"));
                holder.tvIndexTaskItemTitle.setText("排污管线周桥至高速公路管理局");
                holder.tvIndexTaskItemContent.setText("起：周桥 -- 止：高速公路管理局\n全长：4.8公里预计时长：60分钟");
            } else if (position == 1) {
                holder.tvIndexTaskItemCode.setText("一体化巡检：Y161213514");
                holder.ivIndexTaskItemCode.setImageResource(R.drawable.icon_inte);
                holder.lvIndexTaskItemCode.setBackgroundColor(Color.parseColor("#EB6740"));
                holder.tvIndexTaskItemTitle.setText("排污管线四惠街至七家庄东");
                holder.tvIndexTaskItemContent.setText("起：四惠街45号 -- 止：七家庄东55号\n全长：3公里预计时长：15分钟");
            } else if (position == 2) {
                holder.tvIndexTaskItemCode.setText("管网巡检：G161213016");
                holder.ivIndexTaskItemCode.setImageResource(R.drawable.icon_pipe);
                holder.lvIndexTaskItemCode.setBackgroundColor(Color.parseColor("#55BC75"));
                holder.tvIndexTaskItemTitle.setText("排污管线龙江小区北门至门庙坡");
                holder.tvIndexTaskItemContent.setText(" 起：龙江小区北门 -- 止：门庙坡\n全长：4.8公里预计时长：60分钟");
            }

            holder.tvIndexItemGiveUp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    myAlertDialog = new MyAlertDialog(TaskIndexFragment.this.getActivity());
                    myAlertDialog.setMsg("放弃任务有可能扣除积分，确认放弃？");
                    myAlertDialog.setConfirmBtEnable(true);
                    myAlertDialog.setNegativeBtEnable(true);
                    myAlertDialog.setClickInterface(new MyAlertDialog.ClickInterface() {
                        @Override
                        public void clickSure() {
                            myAlertDialog.dismiss();
                        }

                        @Override
                        public void clickCancel() {
                            myAlertDialog.dismiss();
                        }
                    });
                    myAlertDialog.show();
                }
            });
            holder.tvIndexItemCheck.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (position == 0) {
                        Intent intent = new Intent(TaskIndexFragment.this.getActivity(), BaseDisplayActivity.class);
                        intent.putExtra("class", TaskHandlePipeFragment.class);
                        startActivity(intent);
                    } else if (position == 1) {
                        Intent intent = new Intent(TaskIndexFragment.this.getActivity(), BaseDisplayActivity.class);
                        intent.putExtra("class", TaskHandleIntegrateFragment.class);
                        startActivity(intent);
                    } else if (position == 2) {
                        Intent intent = new Intent(TaskIndexFragment.this.getActivity(), BaseDisplayActivity.class);
                        intent.putExtra("class", TaskHandlePipeFragment.class);
                        startActivity(intent);
                    }

                }
            });
        }

        @Override
        public int getItemCount() {
            return 3;
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_index_task_item_code)
        ImageView ivIndexTaskItemCode;
        @BindView(R.id.tv_index_task_item_code)
        TextView tvIndexTaskItemCode;
        @BindView(R.id.lv_index_task_item_code)
        LinearLayout lvIndexTaskItemCode;
        @BindView(R.id.tv_index_task_item_title)
        TextView tvIndexTaskItemTitle;
        @BindView(R.id.tv_index_task_item_content)
        TextView tvIndexTaskItemContent;
        @BindView(R.id.tv_index_item_check)
        TextView tvIndexItemCheck;
        @BindView(R.id.tv_index_item_giveUp)
        TextView tvIndexItemGiveUp;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
