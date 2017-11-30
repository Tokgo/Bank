package com.ziya.bank.fragment.presenter;

import android.content.Intent;

import com.ziya.bank.activity.base.BaseHomeActivity;
import com.ziya.bank.manager.FLAG;
import com.ziya.bank.utils.BankLog;

/**
 * Created by Oliver on 17/11/17.
 */

public class TicketPackageFragmentPresenter extends TicketFragmentPresenter {

    private String dot_code;
    private String  ticket_code;
    @Override
    public void onActivityResult(int requestCode, Intent data) {
        BankLog.w("TicketPackageFragmentPre_onActivityResult","request=>"+requestCode);
        switch (requestCode){
            case FLAG.DOT_SCAN:
                dot_code=data.getStringExtra(FLAG.SCAN_RESULT);
                break;
            case FLAG.TICKET_SCAN:
                ticket_code=data.getStringExtra(FLAG.SCAN_RESULT);
                break;
            case FLAG.SMALL_EXCHANGE_SCAN:
                // TODO: 17/11/17 小交换，根据API设计该部分代码
                break;
            default:
                break;
        }
        BankLog.w("TicketPackageFragmentPre_onActivityResult","dot & ticket =>"+dot_code+" & "+ticket_code);
    }

    @Override
    protected boolean verify() {
        // TODO: 17/11/17 验证是否已经扫描所需要信息,如果验证失败，设置当前页面元素可点击
        return true;
    }

    @Override
    protected void execute() {
        // TODO: 17/11/17 请求api，确认票包收发是否成功
        ((BaseHomeActivity)iView.getActivity()).removeFragment();
    }
}
