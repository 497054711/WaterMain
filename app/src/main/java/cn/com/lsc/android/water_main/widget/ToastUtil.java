package cn.com.lsc.android.water_main.widget;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/3/25.
 */

public class ToastUtil {
    public static void showToast(Context context ,String msg){
        Toast.makeText(context,msg,Toast.LENGTH_LONG).show();
    }
}
