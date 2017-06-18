package com.example.axrorxoja.myapplication.screen.login

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.axrorxoja.myapplication.R
import com.example.axrorxoja.myapplication.screen.main.MainActivity
import com.jakewharton.rxbinding2.widget.RxTextView
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.BiFunction
import kotlinx.android.synthetic.main.content_login.*

class LoginActivity : AppCompatActivity() {
    var cd: CompositeDisposable = CompositeDisposable()
    private val TAG: String = javaClass.simpleName

    override
    fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        addTextWatcher()
        button.setOnClickListener { startActivity(Intent(this, MainActivity::class.java)) }
    }

    private fun addTextWatcher() {
        cd.add(Observable.combineLatest(
                RxTextView.textChanges(loginEt).skip(1), RxTextView.textChanges(passwordEt).skip(1),
                BiFunction<CharSequence, CharSequence, Any>
                { log, pass -> log.isNotEmpty() && pass.isNotEmpty() })
                .doOnNext { button.isEnabled = true }
                .subscribe())
    }

    override fun onPause() {
        super.onPause()
        cd.clear()
    }
}
