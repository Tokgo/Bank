package com.ziya.bank.utils;

import android.util.Log;

/**
 * @Author Eric Zhou
 * @date 2015年1月31日 上午9:51:12
 * @version V1.0
 */
public class BankLog {

	// RELEASE: 17/11/16 发布版本时修正
	private static final boolean isLog=true;

	private static final String TAG="Bank_";

	public static void t(String msg){
		if(isLog){
			Log.i("Testing",msg);
		}
	}

	public static void w(String tag,String msg){
		if(isLog){
			Log.i(TAG+tag, msg);
		}
	}
}
