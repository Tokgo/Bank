package com.ziya.bank.fragment.presenter;

import android.content.Intent;

import com.ziya.bank.activity.base.BaseHomeActivity;
import com.ziya.bank.manager.FLAG;
import com.ziya.bank.utils.BankLog;

/**
 * Created by Oliver on 17/11/17.
 */

public class IDTicketFragmentPresenter extends TicketFragmentPresenter {

    private String dot_code;
    private String ticket_code;
    @Override
    public void onActivityResult(int requestCode, Intent data) {
        BankLog.w("IDTicketFragmentPre_onActivityResult","request=>"+requestCode);
        switch (requestCode){
            case FLAG.DOT_SCAN:
                dot_code=data.getStringExtra(FLAG.SCAN_RESULT);
                break;
            case FLAG.TICKET_SCAN:
                ticket_code=data.getStringExtra(FLAG.SCAN_RESULT);
                break;
            default:
                break;
        }
        BankLog.w("IDTicketFragmentPre_onActivityResult","dot & ticket =>"+dot_code+" & "+ticket_code);
    }

    @Override
    protected void execute() {
        // TODO: 17/11/17 请求api，确认票包收发是否成功
        ((BaseHomeActivity)iView.getActivity()).removeFragment();
    }

    @Override
    protected boolean verify() {
        // TODO: 17/11/17 验证是否已经扫描所需要信息,如果验证失败，设置当前页面元素可点击
        return true;
    }
}
