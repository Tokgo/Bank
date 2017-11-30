package com.ziya.bank.activity.iView;

import com.ziya.bank.base.BaseView;

/**
 * Created by Oliver on 17/11/16.
 */

public interface ILoginActivityView extends BaseView {

    void setSerif();

    void setClickable(boolean b);

    String getID();

    String getPassword();

    void idNullAnimation();

    void passwordNullAnimation();

    void setID(String result);

    void setTitle(int res);

    void setScanEvent();
}
