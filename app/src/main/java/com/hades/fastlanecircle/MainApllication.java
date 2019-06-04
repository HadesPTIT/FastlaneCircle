package com.hades.fastlanecircle;

import android.app.Application;

import com.crashlytics.android.Crashlytics;
import com.hades.fastlanecircle.data.source.local.SharePreferences;
import com.hades.fastlanecircle.data.source.remote.TrackRemoteDataSource;

import io.fabric.sdk.android.Fabric;

/**
 * Created by Sony on 1/9/2018.
 */

public class MainApllication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this,new Crashlytics());
        TrackRemoteDataSource.init(this);
        SharePreferences.init(this);
    }
}
