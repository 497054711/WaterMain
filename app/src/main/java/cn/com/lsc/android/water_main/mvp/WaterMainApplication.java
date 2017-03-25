package cn.com.lsc.android.water_main.mvp;

import android.app.Activity;
import android.app.Application;
import android.util.Log;

import java.util.Stack;

/**
 * Created by Administrator on 2017/3/25.
 */

public class WaterMainApplication extends Application {
    private static final WaterMainApplication ourInstance = new WaterMainApplication();
    public static Stack<Activity> activityStack;

    public static WaterMainApplication getInstance() {
        return ourInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        activityStack = new Stack<Activity>();
        Log.i("","");
    }

    public void addActivityToStack(Activity activity){
        activityStack.add(activity);
    }

    public void removeActivityFromStack(Activity activity){
        activityStack.remove(activity);
    }
    /**
     * @param
     */
    public void exitsApp() {
        for (Activity activity : activityStack) {
            finishActivity(activity);
        }
    }

    private void finishActivity(Activity activity) {
        activity.finish();
        activity = null;
    }

}
