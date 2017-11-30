package com.ziya.bank.activity.presenter;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.view.View;

import com.ziya.bank.R;
import com.ziya.bank.activity.CaptureActivity;
import com.ziya.bank.activity.HomeActivity;
import com.ziya.bank.activity.iView.ILoginActivityView;
import com.ziya.bank.base.BasePresenter;
import com.ziya.bank.i.Verify;
import com.ziya.bank.manager.FLAG;
import com.ziya.bank.manager.PermissionsManager;
import com.ziya.bank.utils.BankLog;
import com.ziya.bank.utils.StringUtil;

/**
 * Created by Oliver on 17/11/16.
 */

public class LoginActivityPresenter extends BasePresenter<ILoginActivityView> {

    public void start(Verify verify) {
        iView.setClickable(false);
        if (verify.verify())
            verify.execute();
        else
            iView.setClickable(true);
    }

    public boolean verify() {
        String id = iView.getID();
        if (StringUtil.isEmpty(id)) {
            iView.idNullAnimation();
            return false;
        }
        String password = iView.getPassword();
        if (StringUtil.isEmpty(password)) {
            iView.passwordNullAnimation();
            return false;
        }
        return true;
    }

    public void login() {
        // TODO: 17/11/17 验证账号密码，成功则进入下一个界面，失败弹出提示信息
        Intent intent=new Intent(iView.getActivity(), HomeActivity.class);
        iView.getActivity().startActivity(intent);
        iView.getActivity().finish();
    }

    public void goScan() {
        Intent intent = new Intent(iView.getActivity(), CaptureActivity.class);
        intent.putExtra(FLAG.SCAN_FLAG,FLAG.LOGIN);
        iView.getActivity().startActivityForResult(intent, FLAG.SCAN_FOR_RESULT);
    }

    public void updateId(Intent intent) {
        if(intent==null||!intent.hasExtra(FLAG.SCAN_RESULT))
            return;
        String result = intent.getStringExtra(FLAG.SCAN_RESULT);
        BankLog.w("LoginActPre_updateId","id=>"+result);
        iView.setID(result);
    }

    public void getPermissions() {

        PermissionsManager.requestPermission(iView.getActivity(), Manifest.permission.CAMERA, new PermissionsManager.RequestPermission() {
            @Override
            public void noNeedRequest() {
                iView.setScanEvent();
            }
        }, PermissionsManager.REQUEST_CAMERA_PERMISSIONS);
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        BankLog.w("LoginActivityPresenter_onRequestPermissionsResult", "requestCode=>" + requestCode);
        if (requestCode == PermissionsManager.REQUEST_CAMERA_PERMISSIONS) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                iView.setScanEvent();
        }
    }
}
