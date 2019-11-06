package com.averoes.daff.listbuahapp.adapter

import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.averoes.daff.listbuahapp.DetailActivity
import com.averoes.daff.listbuahapp.R
import kotlinx.android.synthetic.main.activity_recycler.view.*
import kotlinx.android.synthetic.main.item_model.view.*
import kotlinx.android.synthetic.main.model_recycler.view.*

/**
 * Created by daff on 06/03/19 at 21:16.
 */
class MyRecyclerAdapter (var context: Context, private var recycler: RecyclerView): RecyclerView.Adapter<MyRecyclerAdapter.Holder>() {

    private val nama_buah = arrayOf("Alpukat", "Melon", "Apel", "Mangga", "Jeruk")
    private val img_buah = intArrayOf(
        R.drawable.avocado,
        R.drawable.melon,
        R.drawable.apel,
        R.drawable.mangga,
        R.drawable.jeruk
    )

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): MyRecyclerAdapter.Holder {
        val KEY_NAME = "nama"
        val KEY_IMG = "img"

        var view: View = LayoutInflater.from(parent.context).inflate(R.layout.model_recycler, parent, false)
        view.setOnClickListener {

            var intent =
                Intent(context,DetailActivity::class.java)
            var position :Int =
                recycler.getChildAdapterPosition(view)
            intent.putExtra(KEY_NAME,nama_buah[position])
            intent.putExtra(KEY_IMG,img_buah[position])
            context.startActivity(intent)

          }

        return Holder(view)
    }
    override fun onBindViewHolder(holder: Holder, position: Int) {

        holder.name_buah.text = nama_buah[position]
        holder.img_buah.setImageResource(img_buah[position])
    }


    override fun getItemCount(): Int {
        return nama_buah.size
    }

    inner class Holder(view: View): RecyclerView.ViewHolder(view) {

         val name_buah = view.nama_buah_recycler
         val img_buah = view.img_buah_recycler

    }
}