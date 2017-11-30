package com.ziya.bank.activity.builder;

import com.ziya.bank.activity.base.CaptureHandler;
import com.ziya.bank.activity.handler.HomeHandler;
import com.ziya.bank.activity.handler.LoginHandler;
import com.ziya.bank.manager.FLAG;

/**
 * Created by Oliver on 17/11/17.
 */

public class CaptureHandlerBuilder {
    public static CaptureHandler build(int type){
        if(type== FLAG.LOGIN){
            return new LoginHandler();
        }else if(type==FLAG.HOME){
            return new HomeHandler();
        }
        return null;
    }
}
