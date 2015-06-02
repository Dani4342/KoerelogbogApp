package com.example.daniel.koerelogbogapp;

/**
 * Created by Daniel on 30-05-2015.
 */
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;


public class MyApp extends Application {

    public static Context mAppContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppContext = getApplicationContext();
    }
}