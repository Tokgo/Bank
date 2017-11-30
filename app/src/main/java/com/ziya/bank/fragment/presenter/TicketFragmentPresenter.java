package com.ziya.bank.fragment.presenter;

import android.content.Intent;

import com.ziya.bank.base.BasePresenter;
import com.ziya.bank.fragment.iView.ITicketFragmentView;
import com.ziya.bank.manager.ScanManager;

/**
 * Created by Oliver on 17/11/17.
 */

public abstract class TicketFragmentPresenter extends BasePresenter<ITicketFragmentView>{

    public void scan(int requestCode) {
        ScanManager.scan(iView.getFragment(),iView.getActivity(),requestCode);
    }

    public abstract void onActivityResult(int requestCode, Intent data);

    public void confirm(){
        iView.setClickable(false);
        if(verify())
            execute();
    }

    protected abstract void execute();

    protected abstract boolean verify();
}
