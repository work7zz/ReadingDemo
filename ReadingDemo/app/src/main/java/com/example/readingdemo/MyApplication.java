package com.example.readingdemo;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/**
 * Created by yuzhiqi on 2019/02/28
 *
 * @author 于治麒 yuzhiqi@bytedance.com
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(final Activity activity, final Bundle savedInstanceState) {

            }

            @Override
            public void onActivityStarted(final Activity activity) {

            }

            @Override
            public void onActivityResumed(final Activity activity) {

            }

            @Override
            public void onActivityPaused(final Activity activity) {

            }

            @Override
            public void onActivityStopped(final Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(final Activity activity, final Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(final Activity activity) {

            }
        });
    }
}
