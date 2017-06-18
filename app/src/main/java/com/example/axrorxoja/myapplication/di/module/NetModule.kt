package com.example.axrorxoja.myapplication.di.module

import com.example.axrorxoja.myapplication.App
import com.example.axrorxoja.myapplication.data.rest.ApiService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.readystatesoftware.chuck.ChuckInterceptor
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by axrorxoja on 4/25/17.
 */
@Module
class NetModule {
    @Provides
    fun provideOkHttpCache(app: App): Cache {
        val cacheSize = 10 * 1024 * 1024
        return Cache(app.cacheDir, cacheSize.toLong())
    }

    @Singleton
    @Provides
    fun provideGson(): Gson {
        return GsonBuilder()
                .create()
    }

    @Provides
    fun providesOkHttpClient(cache: Cache, app: App): OkHttpClient {
        return OkHttpClient.Builder()
                .addInterceptor(ChuckInterceptor(app.applicationContext))
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .cache(cache)
                .build()
    }

    @Provides
    fun provideRetrofit(gson: Gson, client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .baseUrl("https://httpbin.org/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .client(client)
                .build()
    }

    @Provides
    @Singleton
    fun providesAppEndPoint(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }
}
