package cn.com.lsc.android.water_main.mvp.record.index;

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
import cn.com.lsc.android.water_main.mvp.record.index.view.IRecordIndexView;

/**
 * Created by Administrator on 2017/3/25.
 */

public class RecordIndexFragment extends BaseFragment implements IRecordIndexView {
    @BindView(R.id.lv_record_index)
    public ListView lv_record_index;

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
        lv_record_index.setAdapter(recordIndexAdapter);
    }

    public class RecordIndexAdapter extends BaseAdapter {
        private LayoutInflater inflater;

        public RecordIndexAdapter() {
            inflater = RecordIndexFragment.this.getActivity().getLayoutInflater();
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
                convertView = inflater.inflate(R.layout.record_index_item, null);
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

            } else if (i == 1) {
                holder.tvIndexTaskItemCode.setText("一体化巡检：Y161213514");
                holder.ivIndexTaskItemCode.setImageResource(R.drawable.icon_inte);
                holder.ivIndexTaskItemCode.setBackgroundColor(Color.parseColor("#EB6740"));
                holder.tvIndexTaskItemTitle.setText("排污管线四惠街至七家庄东");

            } else if (i == 2) {
                holder.tvIndexTaskItemCode.setText("管网巡检：G161213016");
                holder.ivIndexTaskItemCode.setImageResource(R.drawable.icon_pipe);
                holder.ivIndexTaskItemCode.setBackgroundColor(Color.parseColor("#55BC75"));
                holder.tvIndexTaskItemTitle.setText("排污管线龙江小区北门至门庙坡");
            }
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

            ViewHolder(View view) {
                ButterKnife.bind(this, view);
            }
        }
    }
}
