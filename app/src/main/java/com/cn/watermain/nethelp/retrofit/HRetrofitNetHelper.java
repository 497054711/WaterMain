package com.cn.watermain.nethelp.retrofit;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;

import com.cn.watermain.nethelp.ICallBackListener;
import com.cn.watermain.nethelp.NetUtil;
import com.cn.watermain.nethelp.BaseCallBack;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
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
    public static final String BASE_URL = "http://www.simfg.cn:8080";

    private HRetrofitNetHelper(Context context) {
        this.mContext = context;
        mGson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .registerTypeAdapter(String.class, new DeserializerData())
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

    public void flowableSubscribe(Flowable<String> flowable, final ICallBackListener mICallBackListener) {
        flowable
                // Subscriber前面执行的代码都是在I/O线程中运行
                .subscribeOn(Schedulers.io())
                .onBackpressureBuffer()
                // 操作observeOn之后操作主线程中运行.
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        createSubscriber(mICallBackListener).onNext(s);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        createSubscriber(mICallBackListener).onError(throwable);
                    }
                }, new Action() {
                    @Override
                    public void run() throws Exception {
                        createSubscriber(mICallBackListener).onComplete();
                    }
                });
    }

    /**
     * 创建 Subscriber
     *
     * @param mICallBackListener
     * @return Subscriber
     */
    public Subscriber createSubscriber(final ICallBackListener mICallBackListener) {
        Subscriber mSubscriber = new Subscriber<String>() {
            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "[onError]" + e.getMessage());
                BaseCallBack mBaseCallBack = new BaseCallBack();
                mBaseCallBack.setResCode("400");
                mBaseCallBack.setResMsg("请求失败");
                mBaseCallBack.setResObj(null);
                mICallBackListener.onFaild(mBaseCallBack);
                return;
            }

            @Override
            public void onComplete() {
                Log.i(TAG, "[onCompleted]");
            }

            @Override
            public void onSubscribe(Subscription s) {
                Log.i(TAG, "[onSubscribe]");
            }

            @Override
            public void onNext(String s) {
                Log.i(TAG, "[onNext]" + s);
                Gson gosn = new Gson();
                BaseCallBack mBaseCallBack = gosn.fromJson(s, BaseCallBack.class);
                mBaseCallBack.setResCode("200");
                if (mBaseCallBack.getResCode().equals("200")) {
                    mICallBackListener.onSuccess(mBaseCallBack);
                } else {
                    mICallBackListener.onFaild(mBaseCallBack);
                }
            }
        };
        return mSubscriber;
    }

    public Cache getCache() {
        return cache;
    }

    public void clearCache() throws IOException {
        cache.delete();
    }
}
