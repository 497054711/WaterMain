package com.cn.android.mvp.inspect.detail.pipe_grab_single;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import com.cn.android.R;
import com.cn.android.mvp.BaseDisplayActivity;
import com.cn.android.mvp.BaseFragment;
import com.cn.android.mvp.inspect.detail.pipe_grab_single.present.InspectDetailPipeGrabSinglePresent;
import com.cn.android.mvp.inspect.detail.pipe_grab_single.view.IInspectDetailPipeGrabSingleView;
import com.cn.android.mvp.task.map.pipe.TaskMapPipeFragment;
import com.cn.android.widget.MyAlertDialog;

/**
 * Created by Administrator on 2017/3/25.
 */

public class InspectDetailPipeGrabSingleFragment extends BaseFragment implements IInspectDetailPipeGrabSingleView, View.OnClickListener {
    @BindView(R.id.task_detail_grabSingle)
    TextView taskDetailGrabSingle;
    @BindView(R.id.rv_task_detail_pipe)
    RecyclerView rvTaskDetailPipe;
    @BindView(R.id.right)
    public ImageView right;

    private InspectDetailPipeGrabSinglePresent taskDetailPresent;
    private MyAlertDialog myAlertDialog;
    private TaskHandlePipeAdapter taskHandlePipeAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.inspect_detail_pipe_grab_single, null);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        taskDetailPresent = new InspectDetailPipeGrabSinglePresent(this);
        taskHandlePipeAdapter = new TaskHandlePipeAdapter();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
        rvTaskDetailPipe.setLayoutManager(layoutManager);
        rvTaskDetailPipe.setAdapter(taskHandlePipeAdapter);
        right.setImageResource(R.drawable.icon_gps);
        right.setOnClickListener(this);
        taskDetailGrabSingle.setOnClickListener(this);
        title.setText("G161213012");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void grabSingle() {
        myAlertDialog = new MyAlertDialog(InspectDetailPipeGrabSingleFragment.this.getActivity());
        myAlertDialog.setMsg("抢单成功");
        myAlertDialog.setConfirmBtEnable(true);
        myAlertDialog.setNegativeBtEnable(false);
        myAlertDialog.setClickInterface(new MyAlertDialog.ClickInterface() {
            @Override
            public void clickSure() {
                myAlertDialog.dismiss();
                InspectDetailPipeGrabSingleFragment.this.getActivity().finish();
            }

            @Override
            public void clickCancel() {
                myAlertDialog.dismiss();
            }
        });
        myAlertDialog.show();
    }

    @Override
    public void changeMode() {//更改模式
        Intent intent = new Intent(InspectDetailPipeGrabSingleFragment.this.getActivity(), BaseDisplayActivity.class);
        intent.putExtra("class", TaskMapPipeFragment.class);
        startActivity(intent);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.task_detail_grabSingle:
                taskDetailPresent.toGrabSingle();
                break;
            case R.id.right:
                taskDetailPresent.changeMode();
                break;
        }

    }

    public class TaskHandlePipeAdapter extends RecyclerView.Adapter<MyViewHolder> {
        private LayoutInflater inflater;
        private int icon[] = new int[]{R.drawable.icon_jinggai_lv, R.drawable.icon_jinggai_lv, R.drawable.icon_jinggai_zi,
                R.drawable.icon_jinggai_lv, R.drawable.icon_jinggai_lv, R.drawable.icon_jinggai_lv, R.drawable.icon_jinggai_lv,};
        private String places[] = new String[]{"周桥", "王庄", "一号泵", "二道桥 ", "变电所", "化工厂 ", "高速公路管理局"};
        private String places2[] = new String[]{"北口向西150米", "", "新华路25号", "北山门东南角", "向北50米", "西门125号", "向北65米", "东南角210米"};

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            inflater = InspectDetailPipeGrabSingleFragment.this.getActivity().getLayoutInflater();
            MyViewHolder holder = new MyViewHolder(inflater.inflate(R.layout.inspect_detail_pipe_grab_single_item, parent, false));
            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.ivIcon.setImageResource(icon[position]);
            holder.tvPlace.setText(places[position]);
            holder.tvPlace2.setText(places2[position]);
        }

        @Override
        public int getItemCount() {
            return 7;
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_icon)
        ImageView ivIcon;
        @BindView(R.id.tv_place)
        TextView tvPlace;
        @BindView(R.id.tv_place2)
        TextView tvPlace2;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
