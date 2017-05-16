package com.cn.android.mvp.user_task.index;

import android.content.Intent;
import android.graphics.Color;
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
import com.cn.android.mvp.setting.SettingIndexFragment;
import com.cn.android.mvp.task.detail.integrate.TaskDetailIntegrateFragment;
import com.cn.android.mvp.task.detail.pipe.TaskDetailPipeFragment;
import com.cn.android.mvp.user_task.index.present.IIndexPresent;
import com.cn.android.mvp.user_task.index.view.IIndexView;
import com.cn.android.widget.MyAlertDialog;

/**
 * Created by Administrator on 2017/3/20.
 */

public class IndexFragment extends BaseFragment implements IIndexView, View.OnClickListener {
    @BindView(R.id.index_banner)
    public ImageView index_banner;
    @BindView(R.id.right)
    public ImageView right;
    @BindView(R.id.rv_index)
    RecyclerView rvIndex;

    private IIndexPresent iIndexPresent;
    private IndexAdapter indexAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.user_task_index, null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        title.setText("首页");
        index_banner.setOnClickListener(this);
        back.setVisibility(View.GONE);
        right.setImageResource(R.drawable.index_setting);
        right.setOnClickListener(this);
        iIndexPresent = new IIndexPresent(this);
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
            case R.id.index_banner:
                iIndexPresent.toIntegral();
                break;
            case R.id.right:
                iIndexPresent.toSetting();
                break;
        }

    }

    public class IndexAdapter extends RecyclerView.Adapter<MyViewHolder> {
        private LayoutInflater inflater;
        private MyAlertDialog myAlertDialog;

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            inflater = IndexFragment.this.getActivity().getLayoutInflater();
            MyViewHolder holder = new MyViewHolder(inflater.inflate(R.layout.user_task_index_task_item, parent, false));
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
                holder.tvIndexTaskItemContent.setText("起：龙江小区北门 -- 止：门庙坡\n全长：4.8公里预计时长：60分钟");
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
                    if (position == 0) {
                        Intent intent = new Intent(IndexFragment.this.getActivity(), BaseDisplayActivity.class);
                        intent.putExtra("class", TaskDetailPipeFragment.class);
                        startActivity(intent);
                    } else if (position == 1) {
                        Intent intent = new Intent(IndexFragment.this.getActivity(), BaseDisplayActivity.class);
                        intent.putExtra("class", TaskDetailIntegrateFragment.class);
                        startActivity(intent);
                    } else if (position == 2) {
                        Intent intent = new Intent(IndexFragment.this.getActivity(), BaseDisplayActivity.class);
                        intent.putExtra("class", TaskDetailPipeFragment.class);
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
        @BindView(R.id.tv_index_item_grabSingle)
        TextView tvIndexItemGrabSingle;
        @BindView(R.id.tv_index_item_detail)
        TextView tvIndexItemDetail;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
