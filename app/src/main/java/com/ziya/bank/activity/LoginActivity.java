package com.ziya.bank.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.ziya.bank.R;
import com.ziya.bank.activity.iView.ILoginActivityView;
import com.ziya.bank.activity.presenter.LoginActivityPresenter;
import com.ziya.bank.base.BaseActivity;
import com.ziya.bank.i.Verify;
import com.ziya.bank.manager.FLAG;
import com.ziya.bank.utils.AnimationUtil;
import com.ziya.bank.utils.BankLog;

/**
 * Created by Oliver on 17/11/16.
 */

public class LoginActivity extends BaseActivity<LoginActivityPresenter> implements ILoginActivityView {

    private EditText et_id;
    private ImageButton iv_scan;
    private EditText et_password;
    private Button btn_login;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        initData();
    }

    private void initData() {
        initTitle();
        setTitle(R.string.bank);
        setBackVisible(View.GONE);
        setSerif();
        presenter.getPermissions();
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.start(new Verify() {

                    @Override
                    public boolean verify() {
                        return presenter.verify();
                    }

                    @Override
                    public void execute() {
                        presenter.login();
                    }
                });
            }
        });
    }

    @Override
    public void setScanEvent() {
        iv_scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.goScan();
            }
        });
    }

    private void initView() {
        et_id=findViewById(R.id.activity_login_id);
        iv_scan=findViewById(R.id.activity_login_scan);
        et_password=findViewById(R.id.activity_login_password);
        btn_login=findViewById(R.id.activity_login_next);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        BankLog.w("LoginActivity_onActivityResult","requestCode=>"+requestCode);
        if(requestCode== FLAG.SCAN_FOR_RESULT){
            presenter.updateId(data);
        }
    }

    @Override
    public Class<LoginActivityPresenter> getPresenterClass() {
        return LoginActivityPresenter.class;
    }

    @Override
    public void setSerif() {
        et_password.setTypeface(Typeface.SANS_SERIF);
    }

    @Override
    public void setClickable(final boolean b) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                et_id.setFocusable(b);
                et_id.setFocusableInTouchMode(b);
                et_id.setClickable(b);
                et_password.setFocusable(b);
                et_password.setFocusableInTouchMode(b);
                et_password.setClickable(b);
                iv_scan.setFocusable(b);
                iv_scan.setFocusableInTouchMode(b);
                iv_scan.setClickable(b);
                btn_login.setFocusable(b);
                btn_login.setFocusableInTouchMode(b);
                btn_login.setClickable(b);
            }
        });
    }

    @Override
    public String getID() {
        return et_id.getText().toString().trim();
    }

    @Override
    public String getPassword() {
        return et_password.getText().toString().trim();
    }

    @Override
    public void idNullAnimation() {
        AnimationUtil.shakeAnim(this,et_id);
    }

    @Override
    public void passwordNullAnimation() {
        AnimationUtil.shakeAnim(this,et_password);
    }

    @Override
    public void setID(String result) {
        et_id.setText(result);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,String[] permissions,int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        presenter.onRequestPermissionsResult(requestCode,permissions,grantResults);
    }
}
