package com.averoes.daff.listbuahapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.averoes.daff.listbuahapp.R
import com.averoes.daff.listbuahapp.model.Buah

/**
 * Created by daff on 06/03/19 at 14:32.
 */
class MyAdapter(private var context: Context, private var items: ArrayList<Buah>) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {

 var view = convertView
 val holder: Holder
 if (view == null) {
            holder = Holder()
            val inflater = context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = inflater.inflate(R.layout.item_model, null, true)

     holder.nama_buah = view!!.findViewById(R.id.nama_buah) as TextView
     holder.gambar_buah = view.findViewById(R.id.gbr) as ImageView

            view.tag = holder
        }else{
            holder = view.tag as Holder
        }

//        var convertView = convertView
//        val holder: Holder
//
//        if (convertView == null) {
//            holder = Holder()
//            val inflater = context
//                .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
//            convertView = inflater.inflate(R.layout.item_model, null, true)
//
//            holder.nama_buah = convertView!!.findViewById(R.id.nama_buah) as TextView
//            holder.gambar_buah = convertView.findViewById(R.id.gbr) as ImageView
//
//            convertView.tag = holder
//        } else {
//            // the getTag returns the viewHolder object set as a tag to the view
//            holder = convertView.tag as Holder
//        }

        holder.nama_buah!!.setText(items[position].getNamaBuah())
        holder.gambar_buah!!.setImageResource(items[position].getGambarBua())

        return view
    }

    override fun getViewTypeCount(): Int {
        return count
    }
    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItem(position: Int): Buah {

        return items[position]
    }

    override fun getItemId(position: Int): Long {

        return 0
    }

    override fun getCount(): Int {

        return items.size
    }

    inner class Holder{
        var nama_buah:TextView? = null
        var gambar_buah: ImageView? = null
    }
}