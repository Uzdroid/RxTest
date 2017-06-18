package com.example.axrorxoja.myapplication

import android.app.Activity
import android.app.Application
import com.example.axrorxoja.myapplication.di.DaggerAppComponent
import com.example.axrorxoja.myapplication.di.module.AppModule
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

/**
 * Created by axrorxoja on 6/17/17.
 */

class App : Application(), HasActivityInjector {
    @Inject lateinit var injector: DispatchingAndroidInjector<Activity>

    override
    fun onCreate() {
        super.onCreate()
        DaggerAppComponent
                .builder()
                .appModule(AppModule(this))
                .build()
                .injectApp(this)

    }

    override
    fun activityInjector(): AndroidInjector<Activity> {
        return injector
    }
}
