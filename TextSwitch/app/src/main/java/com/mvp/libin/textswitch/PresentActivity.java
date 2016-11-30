package com.mvp.libin.textswitch;

import android.app.Activity;

import java.lang.ref.WeakReference;

/**
 * Created by libin on 16/11/29.
 */

public class PresentActivity {
    private WeakReference<Activity> sCurrentActivityWeakRef;


    private PresentActivity() {

    }

    public static PresentActivity getInstance(){
        return PAHolder.presentActivity;
    }

    /**
     * 静态内部类
     */
    private static class PAHolder{
        private static final PresentActivity presentActivity = new PresentActivity();
    }
    public Activity getCurrentActivity() {
        Activity currentActivity = null;
        if (sCurrentActivityWeakRef != null) {
            currentActivity = sCurrentActivityWeakRef.get();
        }
        return currentActivity;
    }

    public void setCurrentActivity(Activity activity) {
        sCurrentActivityWeakRef = new WeakReference<Activity>(activity);
    }
}
