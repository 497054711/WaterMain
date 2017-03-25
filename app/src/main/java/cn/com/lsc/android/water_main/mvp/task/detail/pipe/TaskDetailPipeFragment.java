package cn.com.lsc.android.water_main.mvp.task.detail.pipe;

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
import butterknife.OnClick;
import butterknife.Unbinder;
import cn.com.lsc.android.water_main.R;
import cn.com.lsc.android.water_main.mvp.BaseFragment;
import cn.com.lsc.android.water_main.mvp.task.detail.pipe.present.TaskDetailPipePresent;
import cn.com.lsc.android.water_main.mvp.task.detail.pipe.view.ITaskDetailPipeView;
import cn.com.lsc.android.water_main.widget.MyAlertDialog;

/**
 * Created by Administrator on 2017/3/25.
 */

public class TaskDetailPipeFragment extends BaseFragment implements ITaskDetailPipeView {
    @BindView(R.id.task_detail_grabSingle)
    TextView taskDetailGrabSingle;
    @BindView(R.id.rv_task_detail_pipe)
    RecyclerView rvTaskDetailPipe;
    private TaskDetailPipePresent taskDetailPresent;
    private MyAlertDialog myAlertDialog;
    private TaskHandlePipeAdapter taskHandlePipeAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.task_detail_pipe, null);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        taskDetailPresent = new TaskDetailPipePresent(this);
        taskHandlePipeAdapter = new TaskHandlePipeAdapter();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
        rvTaskDetailPipe.setLayoutManager(layoutManager);
        rvTaskDetailPipe.setAdapter(taskHandlePipeAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @OnClick(R.id.task_detail_grabSingle)
    public void toGrabSingle() {
        taskDetailPresent.toGrabSingle();
    }

    @Override
    public void grabSingle() {
        myAlertDialog = new MyAlertDialog(TaskDetailPipeFragment.this.getActivity());
        myAlertDialog.setMsg("抢单成功");
        myAlertDialog.setConfirmBtEnable(true);
        myAlertDialog.setNegativeBtEnable(false);
        myAlertDialog.setClickInterface(new MyAlertDialog.ClickInterface() {
            @Override
            public void clickSure() {
                myAlertDialog.dismiss();
                TaskDetailPipeFragment.this.getActivity().finish();
            }

            @Override
            public void clickCancel() {
                myAlertDialog.dismiss();
            }
        });
        myAlertDialog.show();
    }
    class TaskHandlePipeAdapter extends RecyclerView.Adapter<MyViewHolder> {
        private LayoutInflater inflater;
        private int icon[] = new int[]{R.drawable.icon_jinggai_lv ,R.drawable.icon_jinggai_lv, R.drawable.icon_jinggai_zi,
                R.drawable.icon_jinggai_lv, R.drawable.icon_jinggai_lv, R.drawable.icon_jinggai_lv, R.drawable.icon_jinggai_lv,};
        private String places[] = new String[]{"周桥", "王庄", "一号泵", "二道桥 ", "变电所", "化工厂 ", "高速公路管理局"};
        private String places2[] = new String[]{"北口向西150米", "", "新华路25号", "北山门东南角", "向北50米", "西门125号", "向北65米", "东南角210米"};

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            inflater=TaskDetailPipeFragment.this.getActivity().getLayoutInflater();
            MyViewHolder holder = new MyViewHolder(inflater.inflate(R.layout.task_detail_pipe_item, parent,false));
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
