package com.example.apicallusingdagger2andrxjavaexample.di;

import android.app.Application;

import com.example.apicallusingdagger2andrxjavaexample.network.NetworkModule;

public class MyApp extends Application {
    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .networkModule(new NetworkModule())
                .apiModule(new ApiModule())
                .build();
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }
}

