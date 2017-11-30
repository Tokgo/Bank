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
import com.ziya.bank.manager.FLAG;

/**
 * Created by Oliver on 17/11/17.
 */

public class FunctionFragment extends BaseFragment<FunctionFragmentPresenter> implements IFunctionFragmentView, View.OnClickListener {

    private Button btn_ticket_conversion;
    private Button btn_ticket_transfer;
    private Button btn_package;
    private Button btn_sort_center;
    private Button btn_car_record;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_function, null);
        initView();
        initData();
        return root;
    }

    private void initData() {
        initTitle();
        setTitle(R.string.bank_ticket_transfer);
        setBackImageVisible(View.GONE);
        setBackTextVisible(View.VISIBLE);
        setRightImageVisible(View.VISIBLE);
        btn_ticket_conversion.setOnClickListener(this);
        btn_ticket_transfer.setOnClickListener(this);
        btn_package.setOnClickListener(this);
        btn_sort_center.setOnClickListener(this);
        btn_car_record.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fragment_ticket_conversion:
                presenter.toNext(new TicketConversionFragment());
                break;
            case R.id.fragment_ticket_transfer:
                presenter.toNext(new TicketTransferFragment());
                break;
            case R.id.fragment_package:
                presenter.toNext(PackageFragment.newInstance(FLAG.FLAG_PACKAGE));
                break;
            case R.id.fragment_sort_center:
                presenter.toNext(PackageFragment.newInstance(FLAG.FLAG_SORT_CENTER));
                break;
            case R.id.fragment_car_record:
                presenter.toNext(new CarRecordFragment());
                break;
            default:
                break;
        }
    }

    private void initView() {
        btn_ticket_conversion = root.findViewById(R.id.fragment_ticket_conversion);
        btn_ticket_transfer = root.findViewById(R.id.fragment_ticket_transfer);
        btn_package = root.findViewById(R.id.fragment_package);
        btn_sort_center = root.findViewById(R.id.fragment_sort_center);
        btn_car_record = root.findViewById(R.id.fragment_car_record);
    }

    @Override
    public Class<FunctionFragmentPresenter> getPresenterClass() {
        return FunctionFragmentPresenter.class;
    }
}
