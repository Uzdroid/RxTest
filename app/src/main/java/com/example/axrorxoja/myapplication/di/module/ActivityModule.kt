package com.example.axrorxoja.myapplication.di.module

import android.app.Activity

import com.example.axrorxoja.myapplication.di.subcomponent.LoginActivitySubComponent
import com.example.axrorxoja.myapplication.di.subcomponent.MainActivitySubComponent
import com.example.axrorxoja.myapplication.screen.login.LoginActivity
import com.example.axrorxoja.myapplication.screen.main.MainActivity

import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

/**
 * Created by axrorxoja on 4/26/17.
 */
@Module(subcomponents = arrayOf(MainActivitySubComponent::class, LoginActivitySubComponent::class))
abstract class ActivityModule {
    @Binds
    @IntoMap
    @ActivityKey(LoginActivity::class)
     abstract fun bindLoginActivity(builder: LoginActivitySubComponent.Builder): AndroidInjector.Factory<out Activity>

    @Binds
    @IntoMap
    @ActivityKey(MainActivity::class)
     abstract fun bindMainActivity(builder: MainActivitySubComponent.Builder): AndroidInjector.Factory<out Activity>
}
