package com.cn.android.mvp.task.handle.pipe;

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
import com.cn.android.R;
import com.cn.android.mvp.BaseFragment;
import com.cn.android.mvp.task.handle.pipe.present.TaskHandlePiePresent;
import com.cn.android.mvp.task.handle.pipe.view.ITaskHandlePipeView;
import com.cn.android.utils.LoadLocalImageUtil;

/**
 * Created by Administrator on 2017/3/25.
 */

public class TaskHandlePipeFragment extends BaseFragment implements ITaskHandlePipeView {
    @BindView(R.id.lv_task_handle_pipe)
    RecyclerView lvTaskHandlePipe;
    private TaskHandlePiePresent taskDetailPresent;
    private TaskHandlePipeAdapter taskHandlePipeAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.task_handle_pipe, null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        taskDetailPresent = new TaskHandlePiePresent(this);
        taskHandlePipeAdapter = new TaskHandlePipeAdapter();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
        lvTaskHandlePipe.setLayoutManager(layoutManager);
        lvTaskHandlePipe.setAdapter(taskHandlePipeAdapter);
        title.setText("G161213012");
    }

    class TaskHandlePipeAdapter extends RecyclerView.Adapter<MyViewHolder> {

        private int icon[] = new int[]{R.drawable.icon_jinggai_lv, R.drawable.icon_jinggai_lv, R.drawable.icon_jinggai_lv, R.drawable.icon_jinggai_zi,
                R.drawable.icon_jinggai_lv, R.drawable.icon_jinggai_lv, R.drawable.icon_jinggai_lv, R.drawable.icon_jinggai_lv,};
        private String title[] = new String[]{"井盖：W0031", "井盖：W0031", "井盖：W0521", "泵房：一号泵", "井盖：W0522", "井盖：WS1356", "变电所井盖：F0256", "井盖：PY1296"};

        private String places[] = new String[]{"周桥", "声音", "王庄", "一号泵", "二道桥 ", "变电所", "化工厂 ", "高速公路管理局"};
        private String places2[] = new String[]{"北口向西150米", "", "新华路25号", "北山门东南角", "向北50米", "西门125号", "向北65米", "东南角210米"};
        private String date[] = new String[]{"12月13日 13:03", "12月13日 13:10", "12月13日 13:19", "12月13日 13:27", "", "", "", ""};
        private int damages[] = new int[]{R.drawable.jinggai_formal, R.drawable.taskhandle_voice, R.drawable.jinggai_lost, R.drawable.beng01_forml, R.drawable.jinggai_damage01, R.drawable.taskhandle_voice, R.drawable.taskhandle_voice, R.drawable.taskhandle_voice};

        private String status[] = new String[]{"正常", "正常", "井盖丢失", "正常", "井盖破损", "", "", ""};

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                    TaskHandlePipeFragment.this.getActivity()).inflate(R.layout.task_handle_pipe_item, parent,
                    false));
            return holder;
        }

        @Override
        public void onBindViewHolder(final MyViewHolder holder, int position) {
            holder.ivIcon.setImageResource(icon[position]);
            holder.tvTitle.setText(title[position]);
            holder.tvPlace.setText(places[position]);
            holder.tvPlace2.setText(places2[position]);
            holder.tvDate.setText(date[position]);
            holder.tvStatus.setText(status[position]);
            if (position < 5) {
                LoadLocalImageUtil.getInstance(TaskHandlePipeFragment.this.getActivity()).displayFromDrawable(damages[position], holder.ivDamage);
            }
            Glide.with(TaskHandlePipeFragment.this.getActivity()).load(R.drawable.user).asBitmap().centerCrop().into(new BitmapImageViewTarget( holder.ivUserIcon) {
                @Override
                protected void setResource(Bitmap resource) {
                    RoundedBitmapDrawable circularBitmapDrawable =
                            RoundedBitmapDrawableFactory.create(TaskHandlePipeFragment.this.getResources(), resource);
                    circularBitmapDrawable.setCircular(true);
                    holder.ivUserIcon.setImageDrawable(circularBitmapDrawable);
                }
            });
            holder.ivDamage.setVisibility(View.VISIBLE);
            holder.ivUserIcon.setVisibility(View.VISIBLE);
            holder.tvStatus.setVisibility(View.VISIBLE);
            holder.tvUserName.setVisibility(View.VISIBLE);
            if (position == 5) {
                holder.ivDamage.setVisibility(View.GONE);
                holder.ivUserIcon.setVisibility(View.GONE);
                holder.tvStatus.setVisibility(View.GONE);
                holder.tvUserName.setVisibility(View.GONE);
            } else if (position == 6) {
                holder.ivDamage.setVisibility(View.GONE);
                holder.ivUserIcon.setVisibility(View.GONE);
                holder.tvStatus.setVisibility(View.GONE);
                holder.tvUserName.setVisibility(View.GONE);
            } else if (position == 7) {
                holder.ivDamage.setVisibility(View.GONE);
                holder.ivUserIcon.setVisibility(View.GONE);
                holder.tvStatus.setVisibility(View.GONE);
                holder.tvUserName.setVisibility(View.GONE);
            }
        }

        @Override
        public int getItemCount() {
            return 8;
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_icon)
        ImageView ivIcon;
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.tv_place)
        TextView tvPlace;
        @BindView(R.id.tv_place2)
        TextView tvPlace2;
        @BindView(R.id.iv_user_icon)
        ImageView ivUserIcon;
        @BindView(R.id.tv_user_name)
        TextView tvUserName;
        @BindView(R.id.tv_status)
        TextView tvStatus;
        @BindView(R.id.iv_damage)
        ImageView ivDamage;
        @BindView(R.id.tv_date)
        TextView tvDate;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
