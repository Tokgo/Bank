package com.ziya.bank.utils;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;

/**
 * @Author Oliver Lau
 */
public class DensityUtil {
	
	private static Context context;
	//public static float density;
//	public static int screenWidth;
//	public static int screenHeight;
	
	private static boolean isInit = false;
	
	public static void init(Context activity) {
		if(isInit) {
			return;
		}
		isInit = true;
		DensityUtil.context = activity;
//		DisplayMetrics dm = new DisplayMetrics();
//		activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
////		screenWidth = dm.widthPixels;//宽度
////		screenHeight = dm.heightPixels ;//高度
//		density = dm.density;
	}

    /** 
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素) 
     */  
    public static int dip2px(float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;  
        return (int) (dpValue * scale + 0.5f);  
    }  

    /** 
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp 
     */  
    public static int px2dip(float pxValue) {  
        final float scale = context.getResources().getDisplayMetrics().density;  
        return (int) (pxValue / scale + 0.5f);  
    }
    public static float getDensity(Activity activity){
        DisplayMetrics dm = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
////		screenWidth = dm.widthPixels;//宽度
////		screenHeight = dm.heightPixels ;//高度
		return dm.density;
    }
}
