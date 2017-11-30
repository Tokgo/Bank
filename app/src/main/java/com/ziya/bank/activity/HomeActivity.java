package com.ziya.bank.activity;

import android.os.Bundle;

import com.ziya.bank.R;
import com.ziya.bank.activity.base.BaseHomeActivity;
import com.ziya.bank.activity.presenter.HomeActivityPresenter;
import com.ziya.bank.fragment.FunctionFragment;

public class HomeActivity extends BaseHomeActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        addFragment(new FunctionFragment());
    }

    @Override
    public Class<HomeActivityPresenter> getPresenterClass() {
        return HomeActivityPresenter.class;
    }
}
