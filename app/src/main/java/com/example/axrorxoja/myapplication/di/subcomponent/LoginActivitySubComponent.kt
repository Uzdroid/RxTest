package com.example.axrorxoja.myapplication.di.subcomponent

import com.example.axrorxoja.myapplication.di.scope.LoginActivityScope
import com.example.axrorxoja.myapplication.screen.login.LoginActivity

import dagger.Subcomponent
import dagger.android.AndroidInjector

/**
 * Created by axrorxoja on 4/26/17.
 */

@LoginActivityScope
@Subcomponent
interface LoginActivitySubComponent : AndroidInjector<LoginActivity> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<LoginActivity>()
}
