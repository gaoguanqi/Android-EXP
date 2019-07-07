package com.example.mapleplayer.app.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    abstract fun getLayoutId(): Int



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        initData(savedInstanceState)
    }

    open fun initData(savedInstanceState: Bundle?) {

    }



}