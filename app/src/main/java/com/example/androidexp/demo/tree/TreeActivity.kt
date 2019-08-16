package com.example.androidexp.demo.tree

import android.os.Bundle
import android.text.TextUtils
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidexp.R
import com.example.androidexp.utils.AssresUtils
import com.example.mapleplayer.app.base.BaseActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_tree.*

class TreeActivity : BaseActivity() {

    private var mData: List<CityEntity>? = null

    private val adapter: TreeAdapter by lazy {
        TreeAdapter(this@TreeActivity)
    }

    private val manager: LinearLayoutManager by lazy {
        LinearLayoutManager(this@TreeActivity)
    }

    override fun getLayoutId(): Int = R.layout.activity_tree

    override fun initData(savedInstanceState: Bundle?) {
        super.initData(savedInstanceState)
        recyclerView.layoutManager = manager
        recyclerView.adapter = adapter
        adapter.setListener(object : TreeAdapter.OnItemClickListener {
            override fun onItemClick(pos: Int, entnty: CityEntity?) {
                if (entnty == null) return
                entnty.isSelected = entnty.isSelected.let { !it }

                adapter.notifyItemChanged(pos)
            }
        })
        mData = getData()
        adapter.setData(mData)
    }


    fun getData(): List<CityEntity>? {
        var data: List<CityEntity>? = null
        val job: String? = AssresUtils.getFormAssets("city.json")
        if (!TextUtils.isEmpty(job)) {
            val type = object : TypeToken<List<CityEntity>>() {}.type
            data = Gson().fromJson<List<CityEntity>>(job, type)
        }
        return data
    }
}
