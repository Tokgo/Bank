package com.ziya.bank.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.SurfaceView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.zxing.Result;
import com.ziya.bank.R;
import com.ziya.bank.activity.base.CaptureHandler;
import com.ziya.bank.activity.builder.CaptureHandlerBuilder;
import com.ziya.bank.manager.FLAG;
import com.ziya.bank.qr.AutoScannerView;
import com.ziya.bank.qr.BaseCaptureActivity;
import com.ziya.bank.utils.BankLog;

public class CaptureActivity extends BaseCaptureActivity {

    private static final String TAG = CaptureActivity.class.getSimpleName();

    private int way;
    private CaptureHandler handler;
    private SurfaceView surfaceView;
    private AutoScannerView autoScannerView;
    private LinearLayout layout_back;
    private TextView tv_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capture);
        way=getIntent().getIntExtra(FLAG.SCAN_FLAG,-1);
        handler= CaptureHandlerBuilder.build(way);
        layout_back=findViewById(R.id.back_layout);
        tv_title=findViewById(R.id.title_content);
        tv_title.setText(R.string.QR);
        layout_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        surfaceView = findViewById(R.id.preview_view);
        autoScannerView = findViewById(R.id.autoscanner_view);
    }

    @Override
    protected void onResume() {
        super.onResume();
        autoScannerView.setCameraManager(cameraManager);
    }

    @Override
    public SurfaceView getSurfaceView() {
        return (surfaceView == null) ? (SurfaceView) findViewById(R.id.preview_view) : surfaceView;
    }

    @Override
    public void dealDecode(Result rawResult, Bitmap barcode, float scaleFactor) {
        BankLog.w(TAG, "dealDecode ~~~~~ " + rawResult.getText() + " " + barcode + " " + scaleFactor);
        playBeepSoundAndVibrate(true, false);
        handler.handler(this,rawResult.getText());
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
