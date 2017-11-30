package com.ziya.bank.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ziya.bank.R;
import com.ziya.bank.base.BaseFragment;
import com.ziya.bank.fragment.iView.IFunctionFragmentView;
import com.ziya.bank.fragment.presenter.FunctionFragmentPresenter;

/**
 * Created by Oliver on 17/11/18.
 */

public class CarRecordFragment extends BaseFragment<FunctionFragmentPresenter> implements IFunctionFragmentView,View.OnClickListener {

    private Button btn_out_of_storage;
    private Button btn_add_oil;
    private Button btn_repair;

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        root=inflater.inflate(R.layout.fragment_car_record,null);
        initView();
        initData();
        return root;
    }

    private void initData() {
        initTitle();
        setTitle(R.string.car_record);
        btn_out_of_storage.setOnClickListener(this);
        btn_add_oil.setOnClickListener(this);
        btn_repair.setOnClickListener(this);
    }

    private void initView() {
        btn_out_of_storage=root.findViewById(R.id.fragment_out_of_storage);
        btn_add_oil=root.findViewById(R.id.fragment_add_oil);
        btn_repair=root.findViewById(R.id.fragment_repair);
    }

    @Override
    public Class<FunctionFragmentPresenter> getPresenterClass() {
        return FunctionFragmentPresenter.class;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fragment_out_of_storage:
                presenter.toNext(new OutOfStorageFragment());
                break;
            case R.id.fragment_add_oil:
                presenter.toNext(new AddOilFragment());
                break;
            case R.id.fragment_repair:
                presenter.toNext(new RepairFragment());
                break;
            default:
                break;
        }
    }
}
