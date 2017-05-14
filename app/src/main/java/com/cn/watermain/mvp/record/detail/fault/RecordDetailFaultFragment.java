package com.cn.watermain.mvp.record.detail.fault;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;

import butterknife.BindView;
import butterknife.ButterKnife;
import com.cn.watermain.R;
import com.cn.watermain.mvp.BaseFragment;
import com.cn.watermain.mvp.record.detail.fault.view.IRecordDetailFaultView;
import com.cn.watermain.utils.LoadLocalImageUtil;

/**
 * Created by Administrator on 2017/3/31.
 */

public class RecordDetailFaultFragment extends BaseFragment implements IRecordDetailFaultView {

    @BindView(R.id.rv_record_detail_fault)
    RecyclerView rvRecordDetailFault;
    private RecordDetailFaultAdapter recordDetailFaultAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.record_detail_fault, null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        title.setText("报告详情");
        recordDetailFaultAdapter=new RecordDetailFaultAdapter();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
        rvRecordDetailFault.setLayoutManager(layoutManager);
        rvRecordDetailFault.setAdapter(recordDetailFaultAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    public class RecordDetailFaultAdapter extends RecyclerView.Adapter<MyViewHolder> {

        private String date[]=new String[]{"报告时间：11月23日 15:03","修复时间：11月23日 16:28","复查时间：11月24日 8:28"};
        private String userName[]=new String[]{"王苗:","李师傅:","刘军:"};
        private String status[]=new String[]{"小水泵管道破裂了。","已经修复。天太冷，冻坏了。","已确认修复。"};
        private int userIcon[]=new int[]{R.drawable.user,R.drawable.weixiu,R.drawable.user3};
        private int damages[]=new int[]{R.drawable.beng_damage,R.drawable.xiufu01,R.drawable.querenciufu01};

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                    RecordDetailFaultFragment.this.getActivity()).inflate(R.layout.record_detail_fault_item, parent,
                    false));
            return holder;
        }

        @Override
        public void onBindViewHolder(final MyViewHolder holder, int position) {
            holder.tvDate.setText(date[position]);
            holder.tvUserName.setText(userName[position]);
            holder.tvStatus.setText(status[position]);
            LoadLocalImageUtil.getInstance(RecordDetailFaultFragment.this.getActivity()).displayFromDrawable(damages[position], holder.ivDamage);
            Glide.with(RecordDetailFaultFragment.this.getActivity()).load(userIcon[position]).asBitmap().centerCrop().into(new BitmapImageViewTarget( holder.ivUserIcon) {
                @Override
                protected void setResource(Bitmap resource) {
                    RoundedBitmapDrawable circularBitmapDrawable =
                            RoundedBitmapDrawableFactory.create(RecordDetailFaultFragment.this.getResources(), resource);
                    circularBitmapDrawable.setCircular(true);
                    holder.ivUserIcon.setImageDrawable(circularBitmapDrawable);
                }
            });
        }

        @Override
        public int getItemCount() {
            return 3;
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_date)
        TextView tvDate;
        @BindView(R.id.iv_user_icon)
        ImageView ivUserIcon;
        @BindView(R.id.tv_user_name)
        TextView tvUserName;
        @BindView(R.id.tv_status)
        TextView tvStatus;
        @BindView(R.id.iv_damage)
        ImageView ivDamage;
        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
