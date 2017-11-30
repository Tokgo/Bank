package com.ziya.bank.manager;

/**
 * Created by Oliver on 17/11/17.
 */

public class FLAG {
    //请求扫描requestCode
    public static final int SCAN_FOR_RESULT=1<<2;
    //扫描结束resultCode
    public static final int SCAN_REQUEST_CODE=1<<3;

    //请求扫描的界面区别(login、home)
    public static final String SCAN_FLAG="flag";

    public static final int LOGIN=1<<4;
    public static final int HOME=1<<5;

    //记录扫描结果
    public static final String SCAN_RESULT = "SCAN_RESULT";
    //网点扫描requestCode
    public static final int DOT_SCAN = 1<<6;
    //票包扫描requestCode
    public static final int TICKET_SCAN=1<<7;
    //小交换扫描requestCode
    public static final int SMALL_EXCHANGE_SCAN=1<<8;

    public static final int FLAG_PACKAGE=1<<9;
    public static final int FLAG_SORT_CENTER=1<<10;

}
