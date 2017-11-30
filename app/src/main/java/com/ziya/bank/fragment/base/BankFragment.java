package com.ziya.bank.fragment.base;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ziya.bank.R;
import com.ziya.bank.activity.base.BaseHomeActivity;
import com.ziya.bank.fragment.TaskFragment;
import com.ziya.bank.utils.TimerUtil;

/**
 * Created by Oliver on 17/11/17.
 */

public class BankFragment extends Fragment {

    protected View root;
    protected Activity activity;

    protected LinearLayout layout_back;
    protected Button btn_back;
    protected TextView tv_title;
    protected ImageView iv_next;
    protected boolean isPressed;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity= getActivity();
    }

    public void initTitle(){
        layout_back=root.findViewById(R.id.back_layout);
        tv_title=root.findViewById(R.id.title_content);
        iv_next=root.findViewById(R.id.title_right_img);
        btn_back=root.findViewById(R.id.back_text);
        layout_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((BaseHomeActivity)activity).removeFragment();
            }
        });
        iv_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((BaseHomeActivity)activity).addFragment(new TaskFragment());
            }
        });
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signOut();
            }
        });
    }

    private void signOut() {
        if(isPressed){
            activity.finish();
        }else{
            isPressed=true;
            Toast.makeText(activity, R.string.LOGOUT_APP,Toast.LENGTH_SHORT).show();
            TimerUtil.schedule(new Runnable() {
                @Override
                public void run() {
                    isPressed = false;
                }
            }, 3000);
        }
    }

    public void setTitle(int res){
        tv_title.setText(res);
    }

    public void setBackImageVisible(int status){
        layout_back.setVisibility(status);
    }

    public void setBackTextVisible(int status){
        btn_back.setVisibility(status);
    }

    public void setRightImageVisible(int status){
        iv_next.setVisibility(status);
    }

    public ImageView getRightImage() {
        return iv_next;
    }

    public BankFragment getFragment(){
        return this;
    }
}
