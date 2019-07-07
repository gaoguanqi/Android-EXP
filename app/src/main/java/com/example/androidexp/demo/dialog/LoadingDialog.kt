package com.example.androidexp.demo.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.Gravity
import android.view.WindowManager
import com.example.androidexp.R
import kotlinx.android.synthetic.main.dialog_loading.*


class LoadingDialog:Dialog {

    private val text:String

    constructor(context: Context,text:String = "请等待...") : super(context){
        this.text = text
        window?.setGravity(Gravity.CENTER)
        //默认的Dialog只有5/6左右的宽度
        window?.decorView?.setPadding(0, 0, 0, 0);
        val lp = window?.attributes
        lp?.width = WindowManager.LayoutParams.MATCH_PARENT
        lp?.height = WindowManager.LayoutParams.WRAP_CONTENT
        window?.attributes = lp
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_loading);
        tv_text.text = text
    }
}