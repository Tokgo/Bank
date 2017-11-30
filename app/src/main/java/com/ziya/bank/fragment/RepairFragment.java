package com.ziya.bank.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.ziya.bank.R;
import com.ziya.bank.base.BaseFragment;
import com.ziya.bank.fragment.iView.IRequestFragmentView;
import com.ziya.bank.fragment.presenter.RequestFragmentPresenter;
import com.ziya.bank.view.TimeView;

/**
 * Created by Oliver on 17/11/19.
 */

public class RepairFragment extends BaseFragment<RequestFragmentPresenter> implements IRequestFragmentView {

    private TimeView time_repair;
    private EditText et_repair_reason;
    private EditText et_repair_money;
    private Button btn_repair_money_confirm;
    private Button btn_repair_reason_confrim;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        root=inflater.inflate(R.layout.fragment_repair,null);
        initView();
        initData();
        return root;
    }

    private void initData() {
        initTitle();
        setTitle(R.string.repair);
        setRightImageVisible(View.VISIBLE);
        presenter.setOnRightImageClick(CarRecordTaskFragment.REPAIR);
    }

    private void initView() {
        time_repair=root.findViewById(R.id.fragment_repair_time);
        et_repair_reason=root.findViewById(R.id.fragment_repair_reason);
        et_repair_money=root.findViewById(R.id.fragment_repair_money);
        btn_repair_reason_confrim=root.findViewById(R.id.fragment_repair_reason_confirm);
        btn_repair_money_confirm=root.findViewById(R.id.fragment_repair_money_confirm);
    }

    @Override
    public Class<RequestFragmentPresenter> getPresenterClass() {
        return RequestFragmentPresenter.class;
    }
}
