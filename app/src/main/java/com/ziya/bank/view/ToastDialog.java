package com.ziya.bank.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ziya.bank.R;
/**
 * @author Oliver.Lau
 * @version 2.0
 * @data 2015年10月27日
 */
public class ToastDialog extends Dialog {

    private String content;
    private View.OnClickListener clickListener;
    private TextView toast_content;
    private Button toast_btn;

    public ToastDialog(Context context,String content,View.OnClickListener clickListener) {
        super(context, R.style.dialog);
        this.content=content;
        this.clickListener=clickListener;
    }
    public ToastDialog(Context context,int content,View.OnClickListener clickListener){
        super(context,R.style.dialog);
        this.content=context.getResources().getString(content);
        this.clickListener=clickListener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_toast);
        setCanceledOnTouchOutside(false);
        setCancelable(false);

        initView();
        initData();
    }

    private void initData() {
        toast_content.setText(content);
        toast_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clickListener != null)
                    clickListener.onClick(v);
                dismiss();
            }
        });
    }

    private void initView() {
        toast_content= findViewById(R.id.dialog_toast_content);
        toast_btn= findViewById(R.id.dialog_toast_btn);
    }
}
