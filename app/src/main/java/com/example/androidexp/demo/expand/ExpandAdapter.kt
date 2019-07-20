package com.example.androidexp.demo.expand

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidexp.R

class ExpandAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder> {
    val parentType: Int = 1
     val childType: Int = 2

    var context:Context
    var dataList:List<ExpandEntity>? = null

    var onItemClickListener: OnItemClickListener? = null


    constructor(context: Context) : super() {
        this.context = context
    }

    fun setData(data:List<ExpandEntity>?){
        this.dataList = data
        notifyDataSetChanged()
    }

    fun setListener(onItemClickListener:OnItemClickListener){
        this.onItemClickListener = onItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if(viewType == parentType){
            return ParentViewHolder(LayoutInflater.from(context).inflate(R.layout.item_expand_parent,parent,false),onItemClickListener)
        }else{
            return ChildViewHolder(LayoutInflater.from(context).inflate(R.layout.item_expand_child,parent,false),onItemClickListener)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is ParentViewHolder){
            holder.setData(position,dataList!!.get(position).parentTitle)
        }else{
            (holder as ChildViewHolder).setData(position,dataList!!.get(position).childTitle)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if(dataList!!.get(position).isParent) parentType else childType
    }

    override fun getItemCount(): Int {
        return if(dataList == null) 0 else dataList!!.size
    }


}