package com.example.axrorxoja.myapplication.di.module

import com.example.axrorxoja.myapplication.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by axrorxoja on 4/25/17.
 */
@Module
class AppModule(private val app: App) {

    @Provides
    @Singleton
    fun providesApp(): App {
        return app
    }

}
