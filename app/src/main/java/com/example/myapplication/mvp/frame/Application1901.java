package com.example.myapplication.mvp.frame;

import android.app.Application;
import android.content.Context;

import com.example.myapplication.mvp.safe.DeviceUuidFactory;

import java.util.UUID;



public class Application1901 extends Application {
    private static Application1901 sApplication;
    public String mToken;
    public UUID mUuid;

    @Override
    public void onCreate() {
        super.onCreate();
        sApplication = this;
        mUuid = DeviceUuidFactory.getInstance(getApplicationContext()).getDeviceUuid();
    }

    public static Application1901 getApplication() {
        return sApplication;
    }

    public static Context getAppContext() {
        return sApplication.getApplicationContext();
    }
}
