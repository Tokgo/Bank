package com.ziya.bank.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.ziya.bank.R;
import com.ziya.bank.base.BaseFragment;
import com.ziya.bank.fragment.iView.IRequestFragmentView;
import com.ziya.bank.fragment.presenter.RequestFragmentPresenter;
import com.ziya.bank.view.TimeView;

/**
 * Created by Oliver on 17/11/18.
 */

public class OutOfStorageFragment extends BaseFragment<RequestFragmentPresenter> implements IRequestFragmentView {

    private TimeView time_mileage;
    private TimeView time_month;
    private EditText et_out_of_mileage;
    private EditText et_put_in_mileage;
    private Button btn_out_of_mileage_confirm;
    private Button btn_put_in_mileage_confirm;
    private EditText et_begin_month;
    private EditText et_end_month;
    private Button btn_month_confirm;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        root=inflater.inflate(R.layout.fragment_out_of_storage,null);
        initView();
        initData();
        return root;
    }

    private void initData() {
        initTitle();
        setTitle(R.string.out_of_storage);
        setRightImageVisible(View.VISIBLE);
        presenter.setOnRightImageClick(CarRecordTaskFragment.OUT_IN_STORAGE);
    }

    private void initView() {
        time_mileage=root.findViewById(R.id.fragment_out_time);
        et_out_of_mileage=root.findViewById(R.id.fragment_out_of_storage_mileage);
        et_put_in_mileage=root.findViewById(R.id.fragment_put_in_storage_mileage);
        btn_put_in_mileage_confirm=root.findViewById(R.id.fragment_put_in_storage_confirm);
        btn_out_of_mileage_confirm=root.findViewById(R.id.fragment_out_of_storage_confirm);
        time_month=root.findViewById(R.id.fragment_month_time);
        et_begin_month=root.findViewById(R.id.fragment_begin_month_mileage);
        et_end_month=root.findViewById(R.id.fragment_end_month_money);
        btn_month_confirm=root.findViewById(R.id.fragment_money_confirm);
    }

    @Override
    public Class<RequestFragmentPresenter> getPresenterClass() {
        return RequestFragmentPresenter.class;
    }
}
