package com.example.animprac.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.animprac.R

class MainAdapter(
    private val titleList: List<String>,
    private val adapterCallback: SetOnListAdapterListener?
) :
    RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    interface SetOnListAdapterListener {
        fun onListItemClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_main, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return titleList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.mainTitle.text = titleList[position]

        holder.itemView.apply {
            setOnClickListener {
                adapterCallback?.onListItemClick(position)
            }
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val mainTitle: TextView = itemView.findViewById(R.id.main_item_text_title)
    }
}