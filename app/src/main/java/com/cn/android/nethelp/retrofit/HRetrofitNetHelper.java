package com.cn.android.nethelp.retrofit;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;

import com.cn.android.nethelp.ICallBackListener;
import com.cn.android.nethelp.NetUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by goach on 2016/6/12.
 */
public class HRetrofitNetHelper implements HttpLoggingInterceptor.Logger, Interceptor {
    private static final String TAG = HRetrofitNetHelper.class.getSimpleName();
    public static HRetrofitNetHelper mInstance;
    private final Cache cache;
    public Retrofit mRetrofit;
    public OkHttpClient mOkHttpClient;
    public HttpLoggingInterceptor mHttpLogInterceptor;
    private RetrofitBasicParamsInterceptor mBaseParamsInterceptor;
    private Interceptor mUrlInterceptor;
    private Context mContext;
    public Gson mGson;
    public static final String BASE_URL = "http://106.14.118.220:60340/mockjs/4/";
    public static final int STATUS_SUCCESS=200;

    private HRetrofitNetHelper(Context context) {
        this.mContext = context;
        mGson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
//                .registerTypeAdapter(String.class, new DeserializerData())
                .create();
        mHttpLogInterceptor = new HttpLoggingInterceptor(this);
        mHttpLogInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        Map<String, String> tempParams = getBaseParams(context);
        mBaseParamsInterceptor = new RetrofitBasicParamsInterceptor.Builder()
                .addParamsMap(tempParams)
                .build();
        mUrlInterceptor = this;
        File cacheFile = new File(context.getCacheDir(), "HttpCache");
        Log.d("zgx", "cacheFile=====" + cacheFile.getAbsolutePath());
        cache = new Cache(cacheFile, 1024 * 1024 * 100); //100Mb
        mOkHttpClient = new OkHttpClient.Builder()
                .connectTimeout(12, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .addInterceptor(mHttpLogInterceptor)
                .addInterceptor(mBaseParamsInterceptor)
                .addInterceptor(mUrlInterceptor)
                .cache(cache)
                .build();
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(mGson))
                .client(mOkHttpClient)
                .build();
    }

    public static HRetrofitNetHelper getInstance(Context context) {
        if (mInstance == null) {
            synchronized (HRetrofitNetHelper.class) {
                if (mInstance == null) {
                    mInstance = new HRetrofitNetHelper(context);
                }
            }
        }
        return mInstance;
    }

    public <T> T getAPIService(Class<T> service) {
        return mRetrofit.create(service);
    }

    @Override
    public void log(String message) {
        Log.d("zgx", "OkHttp: " + message);
    }

    public Map<String, String> getBaseParams(Context context) {//通用参数
        Map<String, String> params = new HashMap<>();
        params.put("userId", "US201507140000000035");
        params.put("uuid", "UU20170521191615F479FD978FCF49FA");
        params.put("userChannelType", "Android");
        return params;
    }

    @Override
    public okhttp3.Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        //缓存
        if (NetUtil.checkNetwork(mContext) == NetUtil.NO_NETWORK) {
            request = request.newBuilder()
                    .cacheControl(CacheControl.FORCE_CACHE)
                    .build();
            Log.d("zgx", "no network");
        }

        okhttp3.Response response = chain.proceed(request);
        String requestUrl = response.request().url().uri().getPath();
        if (!TextUtils.isEmpty(requestUrl)) {
            if (requestUrl.contains("LoginDataServlet")) {
                if (Looper.myLooper() == null) {
                    Looper.prepare();
                }
                Log.d("zgx", "现在请求的是登录接口");
            }
        }
        //缓存响应
        if (NetUtil.checkNetwork(mContext) != NetUtil.NO_NETWORK) {
            //有网的时候读接口上的@Headers里的配置，你可以在这里进行统一的设置
            String cacheControl = request.cacheControl().toString();
            Log.d("zgx", "cacheControl=====" + cacheControl);
            return response.newBuilder()
                    .header("Cache-Control", cacheControl)
                    .removeHeader("Pragma")
                    .build();
        } else {
            return response.newBuilder()
                    .header("Cache-Control", "public, only-if-cached, max-stale=120")
                    .removeHeader("Pragma")
                    .build();
        }
    }
    public Subscriber<RetrofitBaseCallBack> createSubcribe(final ICallBackListener mICallBackListener){
        //创建订阅者
        Subscriber<RetrofitBaseCallBack> subscriber = new Subscriber<RetrofitBaseCallBack>() {
            @Override
            public void onSubscribe(Subscription s) {
                //这一步是必须，我们通常可以在这里做一些初始化操作，调用request()方法表示初始化工作已经完成
                //调用request()方法，会立即触发onNext()方法
                //在onComplete()方法完成，才会再执行request()后边的代码
                s.request(10);
            }

            @Override
            public void onNext(RetrofitBaseCallBack mRetrofitBaseCallBack) {
                Log.i(TAG, "[onNext]");
                if (mRetrofitBaseCallBack!=null&&mRetrofitBaseCallBack.getRet()==STATUS_SUCCESS) {
                    mICallBackListener.onSuccess(mRetrofitBaseCallBack);
                } else {
                    mICallBackListener.onFaild(mRetrofitBaseCallBack);
                }
            }

            @Override
            public void onError(Throwable throwable) {
                Log.e(TAG, "[onError]" + throwable.getMessage());
                RetrofitBaseCallBack mRetrofitBaseCallBack = new RetrofitBaseCallBack();
                mRetrofitBaseCallBack.setMsg("网络异常,请检查网络");
                mICallBackListener.onFaild(mRetrofitBaseCallBack);
            }

            @Override
            public void onComplete() {
                //由于Reactive-Streams的兼容性，方法onCompleted被重命名为onComplete
                Log.e(TAG, "[onComplete]");
            }
        };
        return subscriber;
    }

    public Cache getCache() {
        return cache;
    }

    public void clearCache() throws IOException {
        cache.delete();
    }
}
