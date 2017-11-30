package com.ziya.bank.activity.handler;

import android.app.Activity;
import android.content.Intent;

import com.ziya.bank.activity.HomeActivity;
import com.ziya.bank.activity.base.CaptureHandler;
import com.ziya.bank.manager.FLAG;

/**
 * Created by Oliver on 17/11/17.
 */

public class HomeHandler implements CaptureHandler {
    @Override
    public void handler(Activity activity, String result) {
        Intent intent=new Intent(activity, HomeActivity.class);
        intent.putExtra(FLAG.SCAN_RESULT,result);
        activity.setResult(1,intent);
        activity.finish();
    }
}
