package com.example.androidexp.demo.expand

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_expand_child.view.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class ChildViewHolder(itemView: View,listener:OnItemClickListener?) : RecyclerView.ViewHolder(itemView) {

    var listener:OnItemClickListener? = null

    fun setData(pos:Int,childList: String?) {
        itemView.item_tv_title.text = childList
        itemView.item_root.onClick {
            listener?.onChildItemClick(pos)
        }
    }

}