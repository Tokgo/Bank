package com.ziya.bank.utils;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Oliver on 17/11/19.
 */
public class TimerUtil {
    public static void schedule(final Runnable runnable) {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                runnable.run();
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, 3000);
    }
    public static Timer schedule(final Runnable runnable,int time){
        TimerTask task=new TimerTask() {
            @Override
            public void run() {
                runnable.run();
            }
        };
        Timer timer=new Timer();
        timer.schedule(task,time);
        return timer;
    }
    public  static void schedule(final Runnable runnable, int time, int interval){
        TimerTask task=new TimerTask() {
            @Override
            public void run() {
                runnable.run();
            }
        };
        Timer timer=new Timer();
        timer.schedule(task,time,interval);
    }
}
