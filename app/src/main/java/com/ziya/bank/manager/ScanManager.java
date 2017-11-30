package com.ziya.bank.manager;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;

import com.ziya.bank.activity.CaptureActivity;

/**
 * Created by Oliver on 17/11/17.
 */

public class ScanManager {
    public static void scan(Fragment fragment, Activity activity,int requestCode){
        Intent intent=new Intent(activity, CaptureActivity.class);
        intent.putExtra(FLAG.SCAN_FLAG,FLAG.HOME);
        fragment.startActivityForResult(intent,requestCode);
    }

}
