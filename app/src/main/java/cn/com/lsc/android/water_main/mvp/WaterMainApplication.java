package cn.com.lsc.android.water_main.mvp;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.StrictMode;
import android.support.multidex.MultiDex;
import android.util.Log;
import android.widget.Toast;

import com.tencent.bugly.Bugly;
import com.tencent.bugly.beta.Beta;
import com.tencent.bugly.beta.interfaces.BetaPatchListener;

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
    public void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        //you must install multiDex whatever tinker is installed!
        // you must install multiDex whatever tinker is installed!
        MultiDex.install(base);

        // 安装tinker
        Beta.installTinker();
    }
    @Override
    public void onCreate() {
        super.onCreate();
        activityStack = new Stack<Activity>();
        initBugly();
    }
    @TargetApi(9)
    protected void setStrictMode() {
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitAll().build());
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectAll().penaltyLog().build());
    }

    /**
     * 初始化bugly
     */
    private void initBugly(){
        Log.i("","");
        setStrictMode();
        // 设置是否关闭热更新能力，默认为true
        Beta.enableHotfix = true;
        // 设置是否自动下载补丁
        Beta.canAutoDownloadPatch = true;
//        // 设置是否提示用户重启
//        Beta.canNotifyUserRestart = true;
        // 设置是否自动合成补丁
        Beta.canAutoPatch = true;
        /**
         * 补丁回调接口，可以监听补丁接收、下载、合成的回调
         */
        Beta.betaPatchListener = new BetaPatchListener() {
            @Override
            public void onPatchReceived(String patchFileUrl) {
//                Toast.makeText(getApplicationContext(), patchFileUrl, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDownloadReceived(long savedLength, long totalLength) {
//                Toast.makeText(getApplicationContext(), String.format(Locale.getDefault(),
//                        "%s %d%%",
//                        Beta.strNotificationDownloading,
//                        (int) (totalLength == 0 ? 0 : savedLength * 100 / totalLength)), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDownloadSuccess(String patchFilePath) {
//                Toast.makeText(getApplicationContext(), patchFilePath, Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), "下载成功", Toast.LENGTH_SHORT).show();
                Beta.applyDownloadedPatch();
            }

            @Override
            public void onDownloadFailure(String msg) {
//                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), "下载失败", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onApplySuccess(String msg) {
//                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), "应用成功"+msg, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onApplyFailure(String msg) {
                Toast.makeText(getApplicationContext(), "应用失败"+msg, Toast.LENGTH_SHORT).show();
//                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPatchRollback() {

            }
        };

        long start = System.currentTimeMillis();
        // 这里实现SDK初始化，appId替换成你的在Bugly平台申请的appId,调试时将第三个参数设置为true
        Bugly.init(this, "8d3e164ee6", false);
        long end = System.currentTimeMillis();
        Log.e("init time--->", end - start + "ms");
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
