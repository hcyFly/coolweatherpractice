package com.coolweatherpractice.base;

import android.app.Application;
import android.content.Context;

/**
 * Created by hcywff on 2017/1/15.
 */

public class MyApplication extends Application {

    private static final String TAG = "MyApplication";
    private static MyApplication mMyApplication = null;
    private static Context globalContext;


    public MyApplication() {
        mMyApplication = this;
    }

    public static MyApplication instance() {
        MyApplication inst = mMyApplication;
        if (inst == null) {
            synchronized (MyApplication.class) {
                inst = mMyApplication;
                if (inst == null) {
                    inst = new MyApplication();
                    mMyApplication = inst;
                }
            }
        }
        return inst;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        globalContext = getApplicationContext();
    }
}
