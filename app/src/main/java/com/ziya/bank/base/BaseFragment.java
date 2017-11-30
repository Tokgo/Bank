package com.ziya.bank.base;

import com.ziya.bank.fragment.base.BankFragment;

/**
 * Created by Oliver on 17/11/17.
 */

public abstract class BaseFragment<P extends BasePresenter> extends BankFragment implements BaseView {

    protected P presenter;

    public BaseFragment(){
        try {
            presenter= getPresenterClass().newInstance();
            presenter.setView(this);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (java.lang.InstantiationException e) {
            e.printStackTrace();
        }
    }

    public abstract Class<P> getPresenterClass();
}
