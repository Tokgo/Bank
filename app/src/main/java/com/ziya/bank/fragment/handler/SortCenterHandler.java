package com.ziya.bank.fragment.handler;

import com.ziya.bank.R;
import com.ziya.bank.fragment.base.BankFragment;
import com.ziya.bank.fragment.base.InitHandler;

/**
 * Created by Oliver on 17/11/18.
 */

public class SortCenterHandler implements InitHandler {
    @Override
    public void setTitle(BankFragment fragment) {
        fragment.setTitle(R.string.sort_center);
    }

    @Override
    public void setRightImageVisible(BankFragment fragment) {

    }

    @Override
    public void request() {

    }
}
