package cn.com.lsc.android.water_main.mvp.user_task.index;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
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
import cn.com.lsc.android.water_main.mvp.user_task.index.present.IIndexPresent;
import cn.com.lsc.android.water_main.mvp.user_task.index.view.IIndexView;
import cn.com.lsc.android.water_main.widget.MyAlertDialog;

/**
 * Created by Administrator on 2017/3/20.
 */

public class IndexFragment extends BaseFragment implements IIndexView, View.OnClickListener {
    @BindView(R.id.index_banner)
    public ImageView index_banner;
    @BindView(R.id.right)
    public ImageView right;
    @BindView(R.id.index_list)
    public ListView index_list;

    private IIndexPresent iIndexPresent;
    private IndexAdapter indexAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.index, null);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        title = (TextView) this.getView().findViewById(R.id.title);
        title.setText("首页");
        index_banner.setOnClickListener(this);
        back.setVisibility(View.GONE);
        right.setImageResource(R.drawable.index_setting);
        right.setOnClickListener(this);
        iIndexPresent = new IIndexPresent(this);
        indexAdapter = new IndexAdapter();
        index_list.setAdapter(indexAdapter);
    }

    @Override
    public void toIntegral() {
        Log.i("toIntegral", "Integral");
    }

    @Override
    public void toSetting() {
        Log.i("toSetting", "setting");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.index_banner:
                iIndexPresent.toIntegral();
                break;
            case R.id.right:
                iIndexPresent.toSetting();
                break;
        }

    }

    public class IndexAdapter extends BaseAdapter {
        private LayoutInflater inflater;
        private MyAlertDialog myAlertDialog;

        public IndexAdapter() {
            inflater = IndexFragment.this.getActivity().getLayoutInflater();
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
                convertView = inflater.inflate(R.layout.index_task_item, null);
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

            holder.tvIndexItemGrabSingle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    myAlertDialog = new MyAlertDialog(IndexFragment.this.getActivity());
                    myAlertDialog.setMsg("已抢单，请在今日14：00前完成巡检");
                    myAlertDialog.setConfirmBtEnable(true);
                    myAlertDialog.setNegativeBtEnable(false);
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
            holder.tvIndexItemDetail.setOnClickListener(new View.OnClickListener() {
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
            @BindView(R.id.tv_index_item_grabSingle)
            TextView tvIndexItemGrabSingle;
            @BindView(R.id.tv_index_item_detail)
            TextView tvIndexItemDetail;

            ViewHolder(View view) {
                ButterKnife.bind(this, view);
            }
        }
    }
}
