package com.example.androidexp.demo.expand

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidexp.R
import com.example.androidexp.demo.dialog.LoadingDialog
import com.example.mapleplayer.app.base.BaseActivity
import kotlinx.android.synthetic.main.activity_expand.*
import com.example.androidexp.demo.expand.OnItemClickListener as OnItemClickListener

class ExpandActivity : BaseActivity() {
    override fun getLayoutId(): Int = R.layout.activity_expand

    var dataList:MutableList<ExpandEntity>? = null

    private val layoutManager: LinearLayoutManager by lazy {
       LinearLayoutManager(this)
    }

    private val adapter: ExpandAdapter by lazy {
        ExpandAdapter(this)
    }

    private val listener: OnItemClickListener by lazy {
        (object :OnItemClickListener{
            override fun onParentItemClick(pos: Int) {

            }

            override fun onChildItemClick(pos: Int) {

            }
        })
    }

    override fun initData(savedInstanceState: Bundle?) {
        super.initData(savedInstanceState)
        dataList = mutableListOf()
        for(index in 1 .. 5){
            val item =  ExpandEntity()
            item.parentTitle = index.toString()
            item.isParent = true
            dataList?.add(item)
            for(index in 1 .. 5){
                val item =  ExpandEntity()
                item.childTitle = index.toString()
                item.isParent = false
                dataList?.add(item)
            }
        }





        adapter.setData(dataList)
        adapter.setListener(listener)
        rv_expand.layoutManager = layoutManager
        rv_expand.adapter = adapter
    }

}
