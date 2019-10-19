package com.example.androidexp.utils

import android.util.Log
import com.example.androidexp.BuildConfig

object LogUtils {
    fun GGQ(msg: String?) {
        if (BuildConfig.DEBUG) {
            Log.d("GGQ", msg)
        }
    }
}