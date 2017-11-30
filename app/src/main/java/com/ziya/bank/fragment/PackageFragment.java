package com.ziya.bank.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ziya.bank.R;
import com.ziya.bank.base.BaseFragment;
import com.ziya.bank.fragment.base.InitHandler;
import com.ziya.bank.fragment.builder.ScanBuilder;
import com.ziya.bank.fragment.iView.ITicketFragmentView;
import com.ziya.bank.fragment.presenter.PackageFragmentPresenter;
import com.ziya.bank.manager.FLAG;

/**
 * Created by Oliver on 17/11/17.
 */

public class PackageFragment extends BaseFragment<PackageFragmentPresenter> implements ITicketFragmentView {

    private Button btn_package_scan;
    private Button btn_confirm;
    private InitHandler handler;

    public static PackageFragment newInstance(int flag){
        PackageFragment fragment=new PackageFragment();
        Bundle bundle=new Bundle();
        bundle.putInt(FLAG.SCAN_FLAG,flag);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments=getArguments();
        if(arguments!=null)
           handler=ScanBuilder.build(arguments.getInt(FLAG.SCAN_FLAG));

    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        root=inflater.inflate(R.layout.fragment_package,null);
        initView();
        initData();
        return root;
    }

    private void initData() {
        initTitle();
        handler.setTitle(this);
        handler.setRightImageVisible(this);
        btn_package_scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.scan(FLAG.DOT_SCAN);
            }
        });
        btn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.confirm();
            }
        });
    }

    private void initView() {
        btn_package_scan=root.findViewById(R.id.fragment_package_scan);
        btn_confirm=root.findViewById(R.id.fragment_confirm);
    }

    @Override
    public void setClickable(final boolean status) {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                btn_package_scan.setClickable(status);
                btn_package_scan.setFocusable(status);
                btn_package_scan.setFocusableInTouchMode(status);
                btn_confirm.setClickable(status);
                btn_confirm.setFocusable(status);
                btn_confirm.setFocusableInTouchMode(status);
            }
        });
    }

    @Override
    public Class<PackageFragmentPresenter> getPresenterClass() {
        return PackageFragmentPresenter.class;
    }
}
