package com.example.axrorxoja.myapplication.di.module

import com.example.axrorxoja.myapplication.di.scope.PerFragmentScope
import com.example.axrorxoja.myapplication.screen.main.fragment.LeftFragment
import com.example.axrorxoja.myapplication.screen.main.fragment.RightFragment

import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by axrorxoja on 6/12/17.
 */

@Module
abstract class MainActivityBindModule {
    @PerFragmentScope
    @ContributesAndroidInjector
    abstract fun leftFragment(): LeftFragment

    @PerFragmentScope
    @ContributesAndroidInjector
    abstract fun rightFragment(): RightFragment
}
