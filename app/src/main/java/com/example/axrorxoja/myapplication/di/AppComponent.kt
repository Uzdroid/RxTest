package com.example.axrorxoja.myapplication.di

import com.example.axrorxoja.myapplication.App
import com.example.axrorxoja.myapplication.di.module.ActivityModule
import com.example.axrorxoja.myapplication.di.module.AppModule
import com.example.axrorxoja.myapplication.di.module.NetModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by axrorxoja on 6/17/17.
 */

@Singleton
@Component(modules = arrayOf(
        AppModule::class,
        NetModule::class,
        AndroidInjectionModule::class,
        AndroidSupportInjectionModule::class,
        ActivityModule::class))
interface AppComponent {
    fun injectApp(application: App)
}