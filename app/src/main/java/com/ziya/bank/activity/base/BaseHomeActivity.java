package com.ziya.bank.activity.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;

import com.ziya.bank.R;
import com.ziya.bank.activity.presenter.HomeActivityPresenter;
import com.ziya.bank.base.BaseActivity;
import com.ziya.bank.base.BaseView;
import com.ziya.bank.fragment.base.BankFragment;

import java.util.Stack;

/**
 * Created by Oliver on 17/11/17.
 */

public abstract class BaseHomeActivity extends BaseActivity<HomeActivityPresenter> implements BaseView {
    protected BankFragment fragment;
    protected Stack<BankFragment> fragments;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragments = new Stack<>();
    }

    public void addFragment(BankFragment fragment) {
        //peek查找栈顶不移除，pop移除返回栈顶对象
        if (fragment == null || (fragments.size() > 0 && fragment.getClass() == fragments
                .peek().getClass())) {
            return;
        }

        this.fragment = fragment;
        fragments.add(fragment);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager()
                .beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.tran_in, R.anim.tran_out);
        fragmentTransaction.add(R.id.home_fragment, fragment);
        fragmentTransaction.commit();
    }

    public void removeFragment() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager()
                .beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.tran_in_left, R.anim.tran_out_right);
        fragmentTransaction.remove(fragments.pop());
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        removeFragment();
    }
}
