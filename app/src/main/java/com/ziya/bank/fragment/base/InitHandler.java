package com.ziya.bank.fragment.base;

/**
 * Created by Oliver on 17/11/18.
 */

public interface InitHandler {
    void setTitle(BankFragment fragment);

    void setRightImageVisible(BankFragment fragment);

    // TODO: 17/11/18 对于普通包裹和分拣中心，参照之后的API决定该方法是否相同
    void request();
}
