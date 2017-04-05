package cn.com.lsc.android.water_main.mvp.message.index;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;

import butterknife.BindView;
import cn.com.lsc.android.water_main.R;
import cn.com.lsc.android.water_main.mvp.BaseFragment;
import cn.com.lsc.android.water_main.mvp.message.index.view.IMessageIndexView;

/**
 * Created by Administrator on 2017/4/4.
 */

public class MessageIndexFragment extends BaseFragment implements IMessageIndexView {
    @BindView(R.id.right)
    ImageView right;
    @BindView(R.id.rv_waterMainTitle)
    RelativeLayout rvWaterMainTitle;
    @BindView(R.id.iv_user)
    ImageView ivUser;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.message_index, null);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        title.setText("消息");
        back.setVisibility(View.GONE);
        Glide.with(MessageIndexFragment.this.getActivity()).load(R.drawable.user_administrator).asBitmap().centerCrop().into(new BitmapImageViewTarget(ivUser) {
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable circularBitmapDrawable =
                        RoundedBitmapDrawableFactory.create(MessageIndexFragment.this.getResources(), resource);
                circularBitmapDrawable.setCircular(true);
                ivUser.setImageDrawable(circularBitmapDrawable);
            }
        });
    }
}
