package com.ziya.bank.manager;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.view.View;

import com.ziya.bank.view.ToastDialog;
/**
 * @author Oliver.Lau
 * @version 2.0.8
 * @data 2016年06月20日
 */
public class PermissionsManager {

    public static final int REQUEST_CAMERA_PERMISSIONS = 1;

    public static void requestPermission(final Activity activity, final String permission, final RequestPermission requestPermission, int requestCode) {

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            int hasWriteContactsPermission = ActivityCompat.checkSelfPermission(activity, permission);
            if (hasWriteContactsPermission != PackageManager.PERMISSION_GRANTED) {

                if (ActivityCompat.shouldShowRequestPermissionRationale(activity, permission)) {
                    String showText = "银结通应用需要";
                    if (permission.equalsIgnoreCase(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                        showText = showText + "读写外部存储的权限";
                    } else if (permission.equalsIgnoreCase(Manifest.permission.CAMERA)) {
                        showText = showText + "访问摄像头的权限";
                    } else if (permission.equalsIgnoreCase(Manifest.permission.READ_PHONE_STATE)) {
                        showText = showText + "读取电话状态的权限";
                    }
                    showMessageDialog(activity, showText, permission, requestCode);
                    return;
                } else {
                    ActivityCompat.requestPermissions(activity,
                            new String[]{permission}, requestCode
                    );
                    return;
                }
            }
        }
        requestPermission.noNeedRequest();
    }

    public static boolean hasPermission(Activity activity, String permission) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            int hasWriteContactsPermission = ActivityCompat.checkSelfPermission(activity, permission);
            return hasWriteContactsPermission == PackageManager.PERMISSION_GRANTED;
        }
        return true;
    }

    private static void showMessageDialog(final Activity activity, String show, final String permission, final int code) {
        ToastDialog confirmDialog = new ToastDialog(activity, show, new View.OnClickListener() {
            @SuppressLint("NewApi")
            @Override
            public void onClick(View v) {
                ActivityCompat.requestPermissions(activity,
                        new String[]{permission}, code
                );
            }
        });
        confirmDialog.show();
    }

    public interface RequestPermission {
        void noNeedRequest();
    }
}
