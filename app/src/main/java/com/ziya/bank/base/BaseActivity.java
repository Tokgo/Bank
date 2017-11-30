package com.ziya.bank.base;

import android.app.Activity;

import com.ziya.bank.activity.base.BankActivity;

/**
 * Created by Oliver on 17/11/16.
 */

public abstract class BaseActivity<P extends BasePresenter> extends BankActivity implements BaseView {

    protected P presenter;

    public BaseActivity(){
        try {
            presenter= getPresenterClass().newInstance();
            presenter.setView(this);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public abstract Class<P> getPresenterClass();

    @Override
    public Activity getActivity() {
        return this;
    }
}
