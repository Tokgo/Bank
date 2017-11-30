package com.ziya.bank.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ziya.bank.R;
import com.ziya.bank.base.BaseFragment;
import com.ziya.bank.fragment.iView.IRequestFragmentView;
import com.ziya.bank.fragment.presenter.RequestFragmentPresenter;

/**
 * Created by Oliver on 17/11/19.
 */

public class AddOilFragment extends BaseFragment<RequestFragmentPresenter> implements IRequestFragmentView {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        root=inflater.inflate(R.layout.fragment_add_oil,null);
        initView();
        return root;
    }

    private void initView() {
        initTitle();
        setTitle(R.string.add_oil);
        setRightImageVisible(View.VISIBLE);
        presenter.setOnRightImageClick(CarRecordTaskFragment.ADD_OIL);
    }

    @Override
    public Class<RequestFragmentPresenter> getPresenterClass() {
        return RequestFragmentPresenter.class;
    }
}
