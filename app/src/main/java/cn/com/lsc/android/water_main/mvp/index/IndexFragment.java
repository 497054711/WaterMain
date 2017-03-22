package cn.com.lsc.android.water_main.mvp.index;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import cn.com.lsc.android.water_main.R;
import cn.com.lsc.android.water_main.mvp.BaseFragment;
import cn.com.lsc.android.water_main.mvp.index.present.PIndex;
import cn.com.lsc.android.water_main.mvp.index.view.IIndexView;

/**
 * Created by Administrator on 2017/3/20.
 */

public class IndexFragment extends BaseFragment implements IIndexView ,View.OnClickListener{
    private ImageView index_banner;
    private ImageView back,right;
    private ListView index_list;
    private PIndex pIndex;
    private IndexAdapter indexAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.index, null);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        index_banner= (ImageView) this.getView().findViewById(R.id.index_banner);
        index_banner.setOnClickListener(this);
        back= (ImageView) this.getView().findViewById(R.id.back);
        back.setVisibility(View.GONE);
        right= (ImageView) this.getView().findViewById(R.id.right);
        right.setImageResource(R.drawable.index_setting);
        right.setOnClickListener(this);
        index_list= (ListView) this.getView().findViewById(R.id.index_list);
        pIndex=new PIndex(this);
        indexAdapter=new IndexAdapter();
        index_list.setAdapter(indexAdapter);
    }

    @Override
    public void toIntegral() {
        Log.i("toIntegral","Integral");
    }

    @Override
    public void toSetting() {
        Log.i("toSetting","setting");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.index_banner:
                pIndex.toIntegral();
                break;
            case R.id.right:
                pIndex.toSetting();
                break;
        }

    }

    public class IndexAdapter extends BaseAdapter{
        private LayoutInflater inflater;
        private View view;

        public IndexAdapter() {
            inflater=IndexFragment.this.getActivity().getLayoutInflater();
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
        public View getView(int i, View view, ViewGroup viewGroup) {
            view= inflater.inflate(R.layout.index_task_item,null);
            return view;
        }
    }
}
