package cn.com.lsc.android.water_main.mvp.task.index;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
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
import cn.com.lsc.android.water_main.mvp.BaseFragment;
import cn.com.lsc.android.water_main.mvp.record.index.RecordIndexFragment;
import cn.com.lsc.android.water_main.mvp.task.index.view.ITaskIndexView;
import cn.com.lsc.android.water_main.widget.MyAlertDialog;

/**
 * Created by Administrator on 2017/3/22.
 */

public class TaskIndexFragment extends BaseFragment implements ITaskIndexView {
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
        task_index_list = (ListView) this.getView().findViewById(R.id.task_index_list);
        taskIndexAdapter = new TaskIndexAdapter();
        task_index_list.setAdapter(taskIndexAdapter);
    }

    public class TaskIndexAdapter extends BaseAdapter {
        private LayoutInflater inflater;
        private MyAlertDialog myAlertDialog;

        public TaskIndexAdapter() {
            inflater = TaskIndexFragment.this.getActivity().getLayoutInflater();
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public Object getItem(int i) {
            return i;
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View convertView, ViewGroup viewGroup) {
            ViewHolder holder;
            if (convertView == null) {
                convertView = inflater.inflate(R.layout.task_index_item, null);
                holder = new ViewHolder(convertView);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            if (i == 0) {
                holder.tvIndexTaskItemCode.setText("管网巡检：G161213012");
                holder.ivIndexTaskItemCode.setImageResource(R.drawable.icon_pipe);
                holder.lvIndexTaskItemCode.setBackgroundColor(Color.parseColor("#55BC75"));
                holder.tvIndexTaskItemTitle.setText("排污管线周桥至高速公路管理局");
                holder.tvIndexTaskItemContent.setText("起：周桥 -- 止：高速公路管理局\n全长：4.8公里预计时长：60分钟");
            } else if (i == 1) {
                holder.tvIndexTaskItemCode.setText("一体化巡检：Y161213514");
                holder.ivIndexTaskItemCode.setImageResource(R.drawable.icon_inte);
                holder.lvIndexTaskItemCode.setBackgroundColor(Color.parseColor("#EB6740"));
                holder.tvIndexTaskItemTitle.setText("排污管线四惠街至七家庄东");
                holder.tvIndexTaskItemContent.setText("起：四惠街45号 -- 止：七家庄东55号\n全长：3公里预计时长：15分钟");
            } else if (i == 2) {
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

                }
            });
            return convertView;
        }

        public class ViewHolder {
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

            ViewHolder(View view) {
                ButterKnife.bind(this, view);
            }
        }
    }
}
