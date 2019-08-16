package com.example.androidexp.demo.tree

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidexp.R
import kotlinx.android.synthetic.main.item_tree.view.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class TreeAdapter : RecyclerView.Adapter<TreeAdapter.ViewHolder> {

    private val mContext: Context
    private var mData: List<CityEntity>? = null
    private var mListener: OnItemClickListener? = null


    constructor(context: Context) : super() {
        this.mContext = context
    }

    fun setListener(listener: OnItemClickListener) {
        this.mListener = listener
    }

    fun setData(data: List<CityEntity>?) {
        this.mData = data
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(mContext).inflate(R.layout.item_tree, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(mData?.get(position))
        holder.itemView.item_root.onClick { mListener?.onItemClick(position, mData?.get(position)) }
    }

    override fun getItemCount(): Int {
        return if (mData == null) 0 else mData!!.size
    }

    inner class ViewHolder : RecyclerView.ViewHolder {
        constructor(itemView: View) : super(itemView)

        fun setData(entity: CityEntity?) {
            if (entity == null) return
            itemView.item_tv_name.text = entity.name
            itemView.item_iv_arrow.background =
                if (entity.isSelected) mContext.resources.getDrawable(R.drawable.ic_arrow_down) else mContext.resources.getDrawable(
                    R.drawable.ic_arrow_next
                )
        }
    }


    interface OnItemClickListener {
        fun onItemClick(pos: Int, entnty: CityEntity?)
    }
}