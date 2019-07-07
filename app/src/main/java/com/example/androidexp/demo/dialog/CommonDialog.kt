package com.example.androidexp.demo.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.Gravity
import android.view.WindowManager
import com.blankj.utilcode.util.ScreenUtils
import com.example.androidexp.R
import kotlinx.android.synthetic.main.dialog_common.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class CommonDialog : Dialog {
    private val title: String
    private val content: String
    private val listener: OnClickListener


    constructor(context: Context, title: String, content: String, listener: OnClickListener) : super(
        context,
        R.style.DialogCommon
    ) {
        this.title = title
        this.content = content
        this.listener = listener
        setCancelable(false)
        window?.setGravity(Gravity.CENTER)
        //默认的Dialog只有5/6左右的宽度
        window?.decorView?.setPadding(0, 0, 0, 0);
        val lp = window?.attributes
        //lp?.width = WindowManager.LayoutParams.MATCH_PARENT
        lp?.width = (ScreenUtils.getScreenWidth() * 0.8).toInt()
        //lp?.height = (ScreenUtils.getScreenHeight() * 0.4).toInt()
        lp?.height = WindowManager.LayoutParams.WRAP_CONTENT
        window?.attributes =lp
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_common)
        tv_content.text = content
        btn_confirm.onClick {
            listener.onConfirmClick()
        }

        btn_cancel.onClick {
            listener.onCancelClick()
        }

    }

    interface OnClickListener {
        fun onConfirmClick()
        fun onCancelClick()
    }
}