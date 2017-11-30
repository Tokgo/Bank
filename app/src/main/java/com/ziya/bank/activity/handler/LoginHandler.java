package com.ziya.bank.activity.handler;

import android.app.Activity;
import android.content.Intent;

import com.ziya.bank.activity.LoginActivity;
import com.ziya.bank.activity.base.CaptureHandler;
import com.ziya.bank.manager.FLAG;

/**
 * Created by Oliver on 17/11/17.
 */

public class LoginHandler implements CaptureHandler {
    @Override
    public void handler(Activity activity, String result) {
        Intent intent=new Intent(activity, LoginActivity.class);
        intent.putExtra(FLAG.SCAN_RESULT,result);
        activity.setResult(1,intent);
        activity.finish();
    }
}
