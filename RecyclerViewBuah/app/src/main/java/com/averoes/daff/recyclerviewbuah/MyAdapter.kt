package com.averoes.daff.recyclerviewbuah

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_model.view.*

/**
 * Created by daff on 06/03/19 at 20:44.
 */
class MyAdapter(private var context: Context,private var items:ArrayList<Model>): RecyclerView.Adapter<MyAdapter.Holder>() {

    private val nama_buah = arrayOf("Alpukat", "Melon", "Apel", "Mangga", "Jeruk")
    private val img_buah = intArrayOf(
        R.drawable.avocado,
        R.drawable.melon,
        R.drawable.apel,
        R.drawable.mangga,
        R.drawable.jeruk
    )
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): Holder {
        var view:View = LayoutInflater.from(parent.context).inflate(R.layout.item_model, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
       return items.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.itemView.buah_item.text = items?.get(position)?.name.toString()
    }

    inner class Holder(view:View): RecyclerView.ViewHolder(view) {

        private val nama_buah = view.buah_item
        private val img_buah = view.img_item

    }
}