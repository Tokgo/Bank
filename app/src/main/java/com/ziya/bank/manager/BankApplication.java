package com.ziya.bank.manager;

import android.app.Application;

import com.ziya.bank.utils.DensityUtil;

/**
 * Created by Oliver on 17/11/19.
 */

public class BankApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        DensityUtil.init(getApplicationContext());
    }
}
