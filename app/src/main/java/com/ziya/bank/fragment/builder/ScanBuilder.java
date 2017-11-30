package com.ziya.bank.fragment.builder;

import com.ziya.bank.fragment.base.InitHandler;
import com.ziya.bank.fragment.handler.PackageHandler;
import com.ziya.bank.fragment.handler.SortCenterHandler;
import com.ziya.bank.manager.FLAG;

/**
 * Created by Oliver on 17/11/18.
 */

public class ScanBuilder {
    public static InitHandler build(int flag) {
        if (flag == FLAG.FLAG_PACKAGE) {
           return new PackageHandler();
        }else if(flag==FLAG.FLAG_SORT_CENTER){
            return new SortCenterHandler();
        }
        return null;
    }
}
