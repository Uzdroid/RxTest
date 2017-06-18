package com.example.axrorxoja.myapplication.data.repo

import com.example.axrorxoja.myapplication.data.model.Message
import io.reactivex.Observable

/**
 * Created by axrorxoja on 6/17/17.
 */

interface IMainRepo {
    fun loadData(): Observable<Message>
}
