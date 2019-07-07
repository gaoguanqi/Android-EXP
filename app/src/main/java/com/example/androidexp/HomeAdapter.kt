package com.example.androidexp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_home.view.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {
    private var list: List<String>? = null
    private var onClick: OnItemClickListener? = null



    fun setData(list: List<String>) {
        this.list = list
        notifyDataSetChanged()
    }

    fun setListener(onClick:OnItemClickListener){
        this.onClick = onClick
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_home, parent, false))
    }

    override fun getItemCount(): Int {
        return if (list.isNullOrEmpty()) 0 else list!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(list?.get(position))
        holder.setOnListener(position)
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun setData(name: String?) {
            itemView.item_tv_name.text = name

        }

        fun setOnListener(position: Int) {
            itemView.item_root.onClick {
                onClick?.onClick(position)
            }
        }
    }
}