package cn.com.lsc.android.water_main.db;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class GuaidDb {
	
	private static final String PREFERENCES_NAME = "com_water_main_version";//版本升级的时候记得升级此数据库
	private static final String GUAID= "guaid";

	public static void setShowGuaid(Context context, boolean isHasShow) {
		if (null == context) {
			return;
		}
		SharedPreferences pref = context.getSharedPreferences(PREFERENCES_NAME,Context.MODE_PRIVATE);
		Editor editor = pref.edit();
		editor.putBoolean(GUAID,isHasShow);
		editor.commit();
	}

	public static boolean isShowGuaid(Context context) {
		if (null == context) {
			return false;
		}
		SharedPreferences pref = context.getSharedPreferences(PREFERENCES_NAME,Context.MODE_PRIVATE);
		return pref.getBoolean(GUAID, true);
	}

}
