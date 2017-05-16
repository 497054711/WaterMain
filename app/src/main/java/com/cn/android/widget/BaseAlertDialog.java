package com.cn.android.widget;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.animation.AnimationSet;

import com.cn.android.R;
import com.cn.android.utils.OptAnimationLoader;


public class BaseAlertDialog extends Dialog {

	private AnimationSet mModalInAnim,mModalOutAnim;
	private View mDialogView;
	private Context context;
	public BaseAlertDialog(Context context, boolean cancelable,
                           OnCancelListener cancelListener) {
		super(context, cancelable, cancelListener);
		// TODO Auto-generated constructor stub
		init(context);
	}

	public BaseAlertDialog(Context context, int theme) {
		super(context, theme);
		// TODO Auto-generated constructor stub
		init(context);
	}

	public BaseAlertDialog(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		init(context);
	}
	private void init(Context context){
		this.context=context;
		initAnimation();
	}
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		if(mDialogView==null){
			mDialogView = getWindow().getDecorView().findViewById(android.R.id.content);
		}
		if(mModalInAnim!=null){
			mDialogView.clearAnimation();
			mDialogView.startAnimation(mModalInAnim);
		}
	}
	
	@Override
	public void cancel() {
		// TODO Auto-generated method stub
		super.cancel();
		if(mDialogView==null){
			mDialogView = getWindow().getDecorView().findViewById(android.R.id.content);
		}
		if(mModalOutAnim!=null){
			mDialogView.startAnimation(mModalOutAnim);
		}
	}
	private void initAnimation(){
		mModalInAnim = (AnimationSet) OptAnimationLoader.loadAnimation(context, R.anim.modal_in);
		mModalOutAnim = (AnimationSet) OptAnimationLoader.loadAnimation(context, R.anim.modal_out);
		mModalInAnim.setDuration(120);
	}
}
