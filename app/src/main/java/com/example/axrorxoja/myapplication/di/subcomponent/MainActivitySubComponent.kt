package com.example.axrorxoja.myapplication.di.subcomponent

import com.example.axrorxoja.myapplication.di.module.MainActivityBindModule
import com.example.axrorxoja.myapplication.di.module.MainActivityModule
import com.example.axrorxoja.myapplication.di.scope.MainActivityScope
import com.example.axrorxoja.myapplication.screen.main.MainActivity

import dagger.Subcomponent
import dagger.android.AndroidInjector

/**
 * Created by axrorxoja on 5/12/17.
 */

@MainActivityScope
@Subcomponent(modules = arrayOf(MainActivityBindModule::class,MainActivityModule::class))
interface MainActivitySubComponent : AndroidInjector<MainActivity> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MainActivity>()
}
