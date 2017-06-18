package com.example.axrorxoja.myapplication.data.rest

import com.example.axrorxoja.myapplication.data.model.Message
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by axrorxoja on 6/17/17.
 */

interface ApiService {
    @GET("ip")
    fun loadIp(): Observable<Message>
}
