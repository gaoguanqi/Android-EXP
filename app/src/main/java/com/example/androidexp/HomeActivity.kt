package com.example.androidexp

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.blankj.utilcode.util.ActivityUtils
import com.example.androidexp.demo.dialog.DialogActivity
import com.example.mapleplayer.app.base.BaseActivity
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : BaseActivity() {
    override fun getLayoutId(): Int = R.layout.activity_home

    private val list = mutableListOf<String>()

    private val adapter : HomeAdapter by lazy {
        HomeAdapter()
    }

    private val manager : LinearLayoutManager by lazy {
        LinearLayoutManager(this)
    }

    override fun initData(savedInstanceState: Bundle?) {
        super.initData(savedInstanceState)

        refreshLayout.setColorSchemeResources(R.color.colorPrimary,R.color.colorAccent,R.color.colorPrimaryDark)
        refreshLayout.setOnRefreshListener{
            onRefresh()
        }

        showView()

        repeat(10){
            list.add(it.toString())
        }
        recyclerView.layoutManager = manager
        adapter.setData(list)
        adapter.setListener(object : OnItemClickListener {
            override fun onClick(position:Int) {
                when(position){
                    0-> ActivityUtils.startActivity(DialogActivity::class.java)
                }
            }
        })
        recyclerView.adapter = adapter
        hideView()
    }


    fun onRefresh() {

        hideView()
    }

    fun showView(){
        refreshLayout.isRefreshing  = true
    }

    fun hideView(){
        refreshLayout.isRefreshing  = false
    }
}


