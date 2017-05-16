package com.cn.android.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.cn.android.R;


public class MyAlertDialog extends BaseAlertDialog implements View.OnClickListener{
    private String msg;
	private View mDialogView;
	private TextView sure,cancel;
	private boolean isNegativeBtEnable=true;
	private boolean isConfirmBtEnable=true;
	private ClickInterface clickInterface;
	
	public MyAlertDialog(Context context) {
		super(context,R.style.Dialog);
		// TODO Auto-generated constructor stub
	}

	public MyAlertDialog(Context context, boolean cancelable,
                         DialogInterface.OnCancelListener cancelListener) {
		super(context, cancelable, cancelListener);
		// TODO Auto-generated constructor stub
	}

	public MyAlertDialog(Context context, int theme) {
		super(context, R.style.Dialog);
		// TODO Auto-generated constructor stub
	}

	public void setClickInterface(ClickInterface clickInterface) {
		this.clickInterface = clickInterface;
	}

	public void setNegativeBtEnable(boolean negativeBtEnable) {
		isNegativeBtEnable = negativeBtEnable;
	}

	public void setConfirmBtEnable(boolean confirmBtEnable) {
		isConfirmBtEnable = confirmBtEnable;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	private void init(){
		this.setContentView(R.layout.alert_dialog);
		mDialogView=this.getWindow().getDecorView();

		((TextView)mDialogView.findViewById(R.id.tipText)).setText(msg);
		sure=(TextView) mDialogView.findViewById(R.id.sure);
		cancel=(TextView) mDialogView.findViewById(R.id.cancel);

		if(isNegativeBtEnable){
			cancel.setVisibility(View.VISIBLE);
		}else{
			cancel.setVisibility(View.GONE);
		}
		if(isConfirmBtEnable){
			sure.setVisibility(View.VISIBLE);
		}else{
			sure.setVisibility(View.GONE);
		}

		if(isConfirmBtEnable||isNegativeBtEnable){
			mDialogView.findViewById(R.id.bottom).setVisibility(View.VISIBLE);
		}else{
			mDialogView.findViewById(R.id.bottom).setVisibility(View.GONE);
		}
		this.setCanceledOnTouchOutside(false);
		this.setCancelable(false);

		sure.setOnClickListener(this);
		cancel.setOnClickListener(this);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		init();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.sure:
			if(clickInterface!=null){
				clickInterface.clickSure();
			}
			break;
		case R.id.cancel:
			if(clickInterface!=null){
				clickInterface.clickCancel();
			}
			break;

		default:
			break;
		}
	}
	public interface ClickInterface{
		public void clickSure();
		public void clickCancel();
	}
}
