package com.example.androidexp.app

import android.app.Application
import com.blankj.utilcode.util.Utils

class MyApplication:Application() {

    companion object {
        @JvmStatic
        lateinit var instance: MyApplication
            private set
    }


    override fun onCreate() {
        super.onCreate()
        instance = this
        Utils.init(this)
    }
}