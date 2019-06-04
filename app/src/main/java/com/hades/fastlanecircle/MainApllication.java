package com.hades.fastlanecircle;

import android.app.Application;

import com.hades.fastlanecircle.data.source.local.SharePreferences;
import com.hades.fastlanecircle.data.source.remote.TrackRemoteDataSource;

/**
 * Created by Sony on 1/9/2018.
 */

public class MainApllication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        TrackRemoteDataSource.init(this);
        SharePreferences.init(this);
    }
}
