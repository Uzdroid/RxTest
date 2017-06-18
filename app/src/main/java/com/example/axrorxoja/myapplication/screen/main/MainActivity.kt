package com.example.axrorxoja.myapplication.screen.main

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.example.axrorxoja.myapplication.R
import com.example.axrorxoja.myapplication.screen.main.fragment.LeftFragment
import com.example.axrorxoja.myapplication.screen.main.fragment.RightFragment
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasSupportFragmentInjector {
    @Inject lateinit var injector: DispatchingAndroidInjector<Fragment>
    private val leftFragment = LeftFragment()
    private val rightFragment = RightFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        fabLeft.setOnClickListener { fireLeft() }
        fabRight.setOnClickListener { fireRight() }

        supportFragmentManager.
                beginTransaction()
                .add(R.id.rightContainer, rightFragment)
                .commit()
        supportFragmentManager.
                beginTransaction()
                .add(R.id.leftContainer, leftFragment)
                .commit()
    }

    private fun fireRight() {
        rightFragment.onFire()
    }

    private fun fireLeft() {
        leftFragment.onFire()
    }

    override
    fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return injector
    }
}
