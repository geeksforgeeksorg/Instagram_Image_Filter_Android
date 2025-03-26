package org.geeksforgeeks.demo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(
    private val items: MutableList<Filters>,
    private val listener: OnFilterClickListener
) :
    RecyclerView.Adapter<Adapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val hashTagItemLayoutView = LayoutInflater.from(parent.context)
            .inflate(
                R.layout.item_rv, parent, false
            )
        return ViewHolder(hashTagItemLayoutView)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        val thumbnail = items[position]
        holder.effectTitle.text = thumbnail.title
        holder.effectRootView.setOnClickListener {
            listener.onFilterClicked(thumbnail)
        }
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val effectTitle: TextView = view.findViewById(R.id.effectName)
        val effectRootView: LinearLayout = view.findViewById(R.id.effectsRootView)
    }
}