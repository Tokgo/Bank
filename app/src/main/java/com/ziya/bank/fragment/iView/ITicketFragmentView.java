package com.ziya.bank.fragment.iView;

import android.support.v4.app.Fragment;

import com.ziya.bank.base.BaseView;

/**
 * Created by Oliver on 17/11/17.
 */

public interface ITicketFragmentView extends BaseView{

    Fragment getFragment();

    void setClickable(boolean status);
}
