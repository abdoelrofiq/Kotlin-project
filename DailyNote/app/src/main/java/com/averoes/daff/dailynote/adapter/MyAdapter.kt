package com.averoes.daff.dailynote.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.averoes.daff.dailynote.DailyActivity
import com.averoes.daff.dailynote.DailyActivity.Companion.DATE
import com.averoes.daff.dailynote.DailyActivity.Companion.NOTE
import com.averoes.daff.dailynote.DailyActivity.Companion.TITLE
import com.averoes.daff.dailynote.MainActivity
import com.averoes.daff.dailynote.R
import com.averoes.daff.dailynote.model.Daily
import kotlinx.android.synthetic.main.item_daily.view.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.startActivity

/**
 * Created by daff on 11/03/19 at 7:21.
 */
class MyAdapter(private var context: Context,
                var listItem: ArrayList<Daily?>) : RecyclerView.Adapter<MyAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): Holder {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_daily, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
       // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return listItem.size

    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
      //  TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        holder.title.text = listItem[position]?.title
        holder.note.text = listItem[position]?.note
        holder.date.text = listItem[position]?.date

        holder.cardView.setOnClickListener {

            context.startActivity(context.intentFor<DailyActivity>(
                DATE to holder.date.text,
                TITLE to holder.title.text,
                NOTE to holder.note.text
            ))
        }
    }

    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {


            var title = itemView.item_title
            var note = itemView.item_note
             var date = itemView.item_date
        var cardView = itemView.cardview

    }

}