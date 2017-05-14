
package com.cn.watermain.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.util.Util;


public class LoadLocalImageUtil {
	private Context context;
	private Activity activity;

	private LoadLocalImageUtil(Context context) {
		this.context=context;
		activity=(Activity)context;
	}

	private static LoadLocalImageUtil instance = null;

	public static LoadLocalImageUtil getInstance(Context context) {
		instance = new LoadLocalImageUtil(context);
		return instance;
	}

	/**
	 * 从内存卡中异步加载本地图片
	 * 
	 * @param uri
	 * @param imageView
	 */
	public void displayFromSDCard(String uri, ImageView imageView) {//支持webp格式图片
		// String imageUri = "file:///mnt/sdcard/image.png"; // from SD card
//		loader.displayImage("file://" + uri, imageView,defaultOptions);
		if((!Util.isOnMainThread())||activity.isFinishing()) {
			return;
		}
		Glide.with(context).load(uri).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(imageView);
	}

	/**
	 * 从内存卡中异步加载本地图片
	 * 
	 * @param uri
	 * @param imageView
	 */
	public void displayFromSDCard(String uri, ImageView imageView, final Handler handler) {//支持webp格式图片
		// String imageUri = "file:///mnt/sdcard/image.png"; // from SD card
		if((!Util.isOnMainThread())||activity.isFinishing()) {
			return;
		}
		Glide.with(context).load(uri).diskCacheStrategy(DiskCacheStrategy.SOURCE).listener(new RequestListener<String, GlideDrawable>() {
			@Override
			public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
				if(handler!=null){
					handler.sendEmptyMessage(1);
				}
				return false;
			}

			@Override
			public boolean onResourceReady(final GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
				if(handler!=null){
					handler.sendEmptyMessage(0);
				}
				return false;
			}
		}).into(imageView);
	}
	
	/**
	 * 从assets文件夹中异步加载图片
	 * 
	 * @param imageName
	 *            图片名称，带后缀的，例如：1.png
	 * @param imageView
	 */
	public void dispalyFromAssets(String imageName, ImageView imageView) {//支持webp格式图片
		// String imageUri = "assets://image.png"; // from assets
//		loader.displayImage("assets://" + imageName, imageView,defaultOptions);
		if((!Util.isOnMainThread())||activity.isFinishing()) {
			return;
		}
		Glide.with(context).load("file:///android_asset/" + imageName).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(imageView);
	}

	/**
	 * 从drawable中异步加载本地图片
	 * 
	 * @param imageId
	 * @param imageView
	 */
	public void displayFromDrawable(int imageId, ImageView imageView) {//支持webp格式图片
		// String imageUri = "drawable://" + R.drawable.image; // from drawables
		// (only images, non-9patch)
//		loader.displayImage("drawable://" + imageId,imageView,defaultOptions);
		if((!Util.isOnMainThread())||activity.isFinishing()) {
			return;
		}
		Glide.with(context).load(imageId).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(imageView);
	}
	
	/**
	 * 从内容提提供者中抓取图片
	 */
	public void displayFromNet(String url, ImageView imageView) {//没尝试是否支持webp格式图片
//		loader.displayImage(url, imageView,defaultOptions);
		if((!Util.isOnMainThread())||activity.isFinishing()) {
			return;
		}
		Glide.with(context).load(url).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(imageView);
	}

}
