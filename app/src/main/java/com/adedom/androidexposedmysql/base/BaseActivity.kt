package com.adedom.androidexposedmysql.base

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData

abstract class BaseActivity : AppCompatActivity() {

    protected inline fun <reified T> LiveData<T>.observe(crossinline onNext: (T) -> Unit) {
        observe(this@BaseActivity, { onNext(it) })
    }

}
