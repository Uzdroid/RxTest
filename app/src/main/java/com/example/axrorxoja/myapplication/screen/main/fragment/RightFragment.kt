package com.example.axrorxoja.myapplication.screen.main.fragment

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.axrorxoja.myapplication.R
import com.example.axrorxoja.myapplication.data.repo.IMainRepo
import com.example.axrorxoja.myapplication.screen.main.listener.FireListener
import dagger.android.support.AndroidSupportInjection
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.fragment_right.*
import javax.inject.Inject

class RightFragment : Fragment(),FireListener {

    @Inject lateinit var repo: IMainRepo
    private val TAG: String = javaClass.simpleName
    private val cd: CompositeDisposable = CompositeDisposable()

    override
    fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_right, container, false)
    }

    override
    fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)

    }

    override
    fun onFire() {
        cd.add(repo.loadData().subscribe { (origin) -> tv.text = origin })
        Log.d(TAG,"hashcode:${repo.hashCode()}")
    }

    override
    fun onDetach() {
        super.onDetach()
        cd.clear()
    }
}
