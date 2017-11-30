package com.ziya.bank.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

import com.ziya.bank.R;
import com.ziya.bank.base.BaseFragment;
import com.ziya.bank.fragment.iView.ITicketFragmentView;
import com.ziya.bank.fragment.presenter.IDTicketFragmentPresenter;
import com.ziya.bank.manager.FLAG;

/**
 * Created by Oliver on 17/11/17.
 */

public class TicketTransferFragment extends BaseFragment<IDTicketFragmentPresenter> implements ITicketFragmentView, View.OnClickListener {

    private Button btn_id_scan;
    private Button btn_ticket_scan;
    private CheckBox cb_empty_package;
    private CheckBox cb_no_package;
    private Button btn_confirm;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_ticket_transfer, null);
        initView();
        initData();
        return root;
    }

    private void initView() {
        btn_id_scan = root.findViewById(R.id.fragment_id_scan);
        btn_ticket_scan = root.findViewById(R.id.fragment_ticket_scan);
        cb_empty_package = root.findViewById(R.id.fragment_empty_package);
        cb_no_package = root.findViewById(R.id.fragment_no_package);
        btn_confirm = root.findViewById(R.id.fragment_confirm);
    }

    private void initData() {
        initTitle();
        setTitle(R.string.ticket_transfer);
        setRightImageVisible(View.VISIBLE);
        btn_id_scan.setOnClickListener(this);
        btn_ticket_scan.setOnClickListener(this);
        btn_confirm.setOnClickListener(this);
    }

    @Override
    public Class<IDTicketFragmentPresenter> getPresenterClass() {
        return IDTicketFragmentPresenter.class;
    }

    @Override
    public void setClickable(final boolean status) {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                btn_id_scan.setClickable(status);
                btn_id_scan.setFocusable(status);
                btn_id_scan.setFocusableInTouchMode(status);
                btn_ticket_scan.setClickable(status);
                btn_ticket_scan.setFocusable(status);
                btn_ticket_scan.setFocusableInTouchMode(status);
                cb_empty_package.setClickable(status);
                cb_empty_package.setFocusable(status);
                cb_empty_package.setFocusableInTouchMode(status);
                cb_no_package.setClickable(status);
                cb_no_package.setFocusable(status);
                cb_no_package.setFocusableInTouchMode(status);
                btn_confirm.setClickable(status);
                btn_confirm.setFocusable(status);
                btn_confirm.setFocusableInTouchMode(status);
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fragment_id_scan:
                presenter.scan(FLAG.DOT_SCAN);
                break;
            case R.id.fragment_ticket_scan:
                presenter.scan(FLAG.TICKET_SCAN);
                break;
            case R.id.fragment_confirm:
                presenter.confirm();
                break;
            default:
                break;
        }
    }
}
