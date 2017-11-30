package com.ziya.bank.base;

/**
 * Created by Oliver on 17/11/16.
 */

public abstract class BasePresenter<V extends BaseView> {
    protected V iView;

    public void setView(V iView) {
        this.iView = iView;
    }

}
