package com.vote.sonny.sonnyvote;

import android.app.Application;

import com.beardedhen.androidbootstrap.TypefaceProvider;

/**
 * Created by sonny on 16-3-26.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        TypefaceProvider.registerDefaultIconSets();
    }
}
