package com.cn.watermain.db;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;


public class LoginInfoDB {
	private static final String PREFERENCES_NAME = "logininfo";
	private static final String LOGIN_INFO= "logininfo";

	public static void writeLoginInfo(Context context, String loginInfo){
		if (null == context ) {
			return;
		}
		SharedPreferences pref = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
		Editor editor = pref.edit();
		editor.putString(LOGIN_INFO, loginInfo);
		editor.commit();
	}

	public static String readLoginInfo(Context context) {
		if (null == context) {
			return "";
		}
		SharedPreferences pref = context.getSharedPreferences(PREFERENCES_NAME,Context.MODE_PRIVATE);
		return pref.getString(LOGIN_INFO, "");
	}
	public static boolean isLogin(Context context){
		String loginInfo=readLoginInfo(context);
		if(loginInfo==null||"".equals(loginInfo)){
			return false;
		}
		return true;
	}
}
