package com.example.androidexp.demo.expand

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_expand_parent.view.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class ParentViewHolder(itemView: View,listener:OnItemClickListener?) : RecyclerView.ViewHolder(itemView) {
    var listener:OnItemClickListener? = null;

    fun setData(pos:Int,parentTitle: String?) {
        itemView.item_tv_title.text = parentTitle
        itemView.item_root.onClick {
            listener?.onParentItemClick(pos)
        }
    }
}