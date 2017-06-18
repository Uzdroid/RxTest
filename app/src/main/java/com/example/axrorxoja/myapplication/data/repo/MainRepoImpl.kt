package com.example.axrorxoja.myapplication.data.repo

import android.util.Log
import com.example.axrorxoja.myapplication.data.model.Message
import com.example.axrorxoja.myapplication.data.rest.ApiService
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by axrorxoja on 6/17/17.
 */

class MainRepoImpl(private val api: ApiService) : IMainRepo {
    val TAG: String = javaClass.simpleName
    var isFirst = false
    var cache: Observable<Message> = Observable.empty()

    override
    fun loadData(): Observable<Message> {
        if (!isFirst) {
            cache = api.loadIp()
                    .subscribeOn(Schedulers.io())
                    .filter { (origin) -> origin.isNotEmpty() }
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnError { t -> Log.d(TAG, t.message) }
                    .cache()
            isFirst = true
        }
        return cache
    }

}
