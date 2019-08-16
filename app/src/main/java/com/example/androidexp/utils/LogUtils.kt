package com.example.androidexp.utils

import android.text.TextUtils
import android.util.Log
import com.example.androidexp.BuildConfig

object LogUtils {
    fun GGQ(msg:String?){
        if(BuildConfig.DEBUG && !TextUtils.isEmpty(msg)){
            Log.d("GGQ",msg)
        }
    }
}