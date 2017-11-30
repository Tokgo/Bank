package com.ziya.bank.fragment.presenter;

import com.ziya.bank.activity.base.BaseHomeActivity;
import com.ziya.bank.base.BasePresenter;
import com.ziya.bank.fragment.CarRecordFragment;
import com.ziya.bank.fragment.PackageFragment;
import com.ziya.bank.fragment.TicketConversionFragment;
import com.ziya.bank.fragment.TicketTransferFragment;
import com.ziya.bank.fragment.base.BankFragment;
import com.ziya.bank.fragment.iView.IFunctionFragmentView;
import com.ziya.bank.manager.FLAG;

/**
 * Created by Oliver on 17/11/17.
 */

public class FunctionFragmentPresenter extends BasePresenter<IFunctionFragmentView> {

    public void toNext(BankFragment fragment) {
        ((BaseHomeActivity)iView.getActivity()).addFragment(fragment);
    }
}
