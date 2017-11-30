package com.ziya.bank.fragment.handler;

import android.view.View;

import com.ziya.bank.R;
import com.ziya.bank.fragment.base.BankFragment;
import com.ziya.bank.fragment.base.InitHandler;

/**
 * Created by Oliver on 17/11/18.
 */

public class PackageHandler implements InitHandler {
    @Override
    public void setTitle(BankFragment fragment) {
        fragment.setTitle(R.string.normal_package);
    }

    @Override
    public void setRightImageVisible(BankFragment fragment) {
        fragment.setRightImageVisible(View.VISIBLE);
    }

    @Override
    public void request() {

    }
}
