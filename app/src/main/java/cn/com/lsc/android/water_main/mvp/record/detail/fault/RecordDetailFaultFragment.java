package cn.com.lsc.android.water_main.mvp.record.detail.fault;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.com.lsc.android.water_main.R;
import cn.com.lsc.android.water_main.mvp.BaseFragment;
import cn.com.lsc.android.water_main.mvp.record.detail.fault.view.IRecordDetailFaultView;

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
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
        rvRecordDetailFault.setLayoutManager(layoutManager);
        rvRecordDetailFault.setAdapter(recordDetailFaultAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    public class RecordDetailFaultAdapter extends RecyclerView.Adapter<MyViewHolder> {

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                    RecordDetailFaultFragment.this.getActivity()).inflate(R.layout.record_detail_fault_item, parent,
                    false));
            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 3;
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {


        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
