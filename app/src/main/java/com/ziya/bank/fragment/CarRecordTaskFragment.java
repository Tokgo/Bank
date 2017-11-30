package com.ziya.bank.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ziya.bank.R;
import com.ziya.bank.base.BaseFragment;
import com.ziya.bank.fragment.iView.ICardRecordTaskView;
import com.ziya.bank.fragment.presenter.CarRecordTaskPresenter;

/**
 * Created by Oliver on 17/11/20.
 */

public class CarRecordTaskFragment extends BaseFragment<CarRecordTaskPresenter> implements ICardRecordTaskView{

    private static final String ARG_KEY="ARG_KEY";
    public static final int OUT_IN_STORAGE=1<<2;
    public static final int ADD_OIL=1<<3;
    public static final int REPAIR=1<<4;
    private int type=OUT_IN_STORAGE;

    private Button btn_out_in_storage;
    private Button btn_add_oil;
    private Button btn_repair;
    private TextView tv_list_title;
    private TextView tv_date;
    private RecyclerView date_list;
    private TextView tv_recycle_title;
    private LinearLayout out_of_mileage_layout;
    private TextView out_of_mileage_title;

    public static CarRecordTaskFragment newInstance(int type){
        CarRecordTaskFragment fragment=new CarRecordTaskFragment();
        Bundle bundle=new Bundle();
        bundle.putInt(ARG_KEY,type);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments=getArguments();
        if(arguments!=null){
            type=arguments.getInt(ARG_KEY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        root=inflater.inflate(R.layout.fragment_car_record_task,null);
        initView();
        initData();
        return root;
    }

    private void initData() {
        initTitle();
        setTitle(R.string.car_record_list);
        presenter.init(type);
        presenter.setDate();
        presenter.initRecycleView(type);
    }

    private void initView() {
        btn_out_in_storage=root.findViewById(R.id.fragment_out_of_storage);
        btn_add_oil=root.findViewById(R.id.fragment_add_oil);
        btn_repair=root.findViewById(R.id.fragment_repair);
        tv_list_title=root.findViewById(R.id.fragment_list_title);
        tv_date=root.findViewById(R.id.fragment_data);
        date_list=root.findViewById(R.id.fragment_data_list);
        out_of_mileage_title =root.findViewById(R.id.fragment_out_month_mileage);
        out_of_mileage_layout =root.findViewById(R.id.fragment_out_of_storage_show);
        tv_recycle_title=root.findViewById(R.id.fragment_show_list_title);
    }

    @Override
    public Class<CarRecordTaskPresenter> getPresenterClass() {
        return CarRecordTaskPresenter.class;
    }

    @Override
    public TextView getDateText() {
        return tv_date;
    }

    @Override
    public RecyclerView getRecycleView() {
        return date_list;
    }

    @Override
    public TextView getListTitle() {
        return tv_list_title;
    }

    @Override
    public Button getFirstButton() {
        return btn_out_in_storage;
    }

    @Override
    public Button getSecondButton() {
        return btn_add_oil;
    }

    @Override
    public Button getThirdButton() {
        return btn_repair;
    }

    @Override
    public TextView getOutOfTitle() {
        return out_of_mileage_title;
    }

    @Override
    public LinearLayout getOutOfLayout() {
        return out_of_mileage_layout;
    }

    @Override
    public TextView getRecycleTitle() {
        return tv_recycle_title;
    }
}
