package com.ziya.bank.fragment.presenter;

import android.view.View;

import com.ziya.bank.activity.base.BaseHomeActivity;
import com.ziya.bank.base.BasePresenter;
import com.ziya.bank.fragment.CarRecordTaskFragment;
import com.ziya.bank.fragment.iView.IRequestFragmentView;

/**
 * Created by Oliver on 17/11/19.
 */

public class RequestFragmentPresenter extends BasePresenter<IRequestFragmentView> {

    public void setOnRightImageClick(final int type) {
        iView.getRightImage().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((BaseHomeActivity)iView.getActivity()).addFragment(CarRecordTaskFragment.newInstance(type));
            }
        });
    }
}
