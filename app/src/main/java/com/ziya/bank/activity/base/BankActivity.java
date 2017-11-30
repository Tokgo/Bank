package com.ziya.bank.activity.base;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ziya.bank.R;

/**
 * Created by Oliver on 17/11/17.
 */

public class BankActivity extends FragmentActivity {
    private TextView tv_title;
    private LinearLayout layout_back;
    public void initTitle(){
        layout_back=findViewById(R.id.back_layout);
        tv_title=findViewById(R.id.title_content);
    }

    public void setTitle(int res){
        tv_title.setText(getString(res));
    }

    public void setBackVisible(int status){
        layout_back.setVisibility(status);
    }
}
