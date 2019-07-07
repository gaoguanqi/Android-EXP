package com.example.androidexp.demo.dialog

import android.os.Bundle
import com.example.androidexp.R
import com.example.mapleplayer.app.base.BaseActivity
import kotlinx.android.synthetic.main.activity_dialog.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.toast
import java.text.FieldPosition

class DialogActivity : BaseActivity() {

    private val loadingDialog: LoadingDialog by lazy {
        LoadingDialog(this)
    }

    private val commonDialog:CommonDialog by lazy {
        CommonDialog(this,"title","content",object :CommonDialog.OnClickListener{
            override fun onConfirmClick() {
                commonDialog.dismiss()
            }

            override fun onCancelClick() {
                commonDialog.dismiss()
            }

        })
    }


    private val bottomOptionDialog:BottomOptionDialog by lazy {
        BottomOptionDialog(this,object :BottomOptionDialog.OnClickListener{
            override fun onCameraClick() {
            }

            override fun onPhotoClick() {
            }

            override fun onCancelClick() {
            }

        })
    }


    private var shareList = mutableListOf<String>()
    private val bottomShareDialog:BottomShareDialog by lazy {
       BottomShareDialog(this,shareList,object :BottomShareDialog.OnClickListener{
           override fun onItemClick(position: Int) {
               bottomShareDialog.dismiss()
               toast(shareList.get(position))
           }

           override fun onCancelClick() {
               bottomShareDialog.dismiss()
           }
       })
    }


    override fun getLayoutId(): Int = R.layout.activity_dialog


    override fun initData(savedInstanceState: Bundle?) {
        super.initData(savedInstanceState)
        shareList.add("微信")
        shareList.add("腾讯")
        shareList.add("新浪")
        shareList.add("朋友圈")
        shareList.add("微博")
        shareList.add("系统")
        shareList.add("短信")
        shareList.add("邮件")
        shareList.add("等等")

        btn_loading.onClick {
            if(!loadingDialog.isShowing){
                loadingDialog.show()
            }
        }

        btn_common.onClick {
            if(!commonDialog.isShowing){
                commonDialog.show()
            }
        }

        btn_bottom_option.onClick {
            if(!bottomOptionDialog.isShowing){
                bottomOptionDialog.show()
            }
        }

        btn_bottom_share.onClick {
            if(!bottomShareDialog.isShowing){
                bottomShareDialog.show()
            }
        }

    }
}
