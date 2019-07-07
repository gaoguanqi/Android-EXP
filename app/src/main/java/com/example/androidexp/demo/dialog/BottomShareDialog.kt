package com.example.androidexp.demo.dialog

import android.app.Dialog
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.WindowManager
import androidx.recyclerview.widget.GridLayoutManager
import com.example.androidexp.R
import kotlinx.android.synthetic.main.dialog_bottom_share.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import java.text.FieldPosition

class BottomShareDialog :Dialog{

    private val list:List<String>
    private val listener: OnClickListener


    private val manager : GridLayoutManager by lazy {
        GridLayoutManager(this.context,4)
    }

    private val adapter : ShareAdapter by lazy {
        ShareAdapter()
    }


    constructor(context: Context, list:List<String>,listener: OnClickListener) : super(context, R.style.DialogBottom){
        this.list = list
        this.listener = listener
        window?.setGravity(Gravity.BOTTOM)
        //默认的Dialog只有5/6左右的宽度
        window?.decorView?.setPadding(0, 0, 0, 0);
        val lp = window?.attributes
        lp?.width = WindowManager.LayoutParams.MATCH_PARENT
        //lp?.width = (ScreenUtils.getScreenWidth()*0.96).toInt()
        //lp?.height = (ScreenUtils.getScreenHeight()*0.4).toInt()
        lp?.height = WindowManager.LayoutParams.WRAP_CONTENT
        window?.attributes = lp
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_bottom_share)
        rv_share.layoutManager = manager
        rv_share.adapter = adapter
        adapter.setListener(object : ShareAdapter.OnItemClickListener{
            override fun onClick(position: Int) {
                listener.onItemClick(position)
            }
        })
        adapter.setData(list)

        btn_cancel.onClick {
            listener.onCancelClick()
        }

    }

    interface OnClickListener{
        fun onItemClick(position: Int)
        fun onCancelClick()
    }

    private fun fullScreenImmersive(view: View?) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            val uiOptions = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
            view?.systemUiVisibility = uiOptions
        }
    }

    override fun show() {
        this.window?.setFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE, WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);
        super.show();
        fullScreenImmersive(window?.decorView);
        this.window?.clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);
    }
}