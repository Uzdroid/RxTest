package com.example.axrorxoja.myapplication.di.module

import com.example.axrorxoja.myapplication.data.repo.IMainRepo
import com.example.axrorxoja.myapplication.data.repo.MainRepoImpl
import com.example.axrorxoja.myapplication.data.rest.ApiService
import com.example.axrorxoja.myapplication.di.scope.MainActivityScope
import dagger.Module
import dagger.Provides

/**
 * Created by axrorxoja on 6/12/17.
 */

@Module
class MainActivityModule {

    @Provides
    @MainActivityScope
    fun provideRepo(api: ApiService): IMainRepo {
        return MainRepoImpl(api)
    }
}
