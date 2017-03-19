package cn.com.lsc.android.water_main.animation;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import cn.com.lsc.android.water_main.R;

/**
 * Created by Administrator on 2017/3/11.
 */

public class AnimationPushBotton {
    private Animation animationIn, animationOut;
    private AnimationEndCallBack animationEndCallBack;

    public void setAnimationEndCallBack(AnimationEndCallBack animationEndCallBack) {
        this.animationEndCallBack = animationEndCallBack;
    }

    public AnimationPushBotton(Context context) {
        animationIn = AnimationUtils.loadAnimation(context, R.anim.push_bottom_in);
        animationOut = AnimationUtils.loadAnimation(context, R.anim.push_bottom_out);
    }
    public void startAnimationIn(View view){
        view.clearAnimation();
        view.startAnimation(animationIn);
        animationIn.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                animationEndCallBack.animationInEndcallBack();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
    public void startAnimationOUT(View view){
        view.clearAnimation();
        view.startAnimation(animationOut);
        animationOut.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                animationEndCallBack.animationOutEndcallBack();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
    public interface AnimationEndCallBack {
        public void animationInEndcallBack();
        public void animationOutEndcallBack();
    }
}
