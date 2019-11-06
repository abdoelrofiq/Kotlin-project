package com.averoes.daff.notedailyapp

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.averoes.daff.notedailyapp.model.ResultItem
import kotlinx.android.synthetic.main.list_note.view.*
import java.util.ArrayList

/**
 * Created by daff on 14/03/19 at 13:02.
 */
class MyAdapter(val context: Context, val listNote: List<ResultItem?>?):
    RecyclerView.Adapter<MyAdapter.MyHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): MyHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_note, parent, false)

        return MyHolder(view)
    }

    override fun getItemCount(): Int {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

        return listNote!!.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
       // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

        holder.view.date_note.text = listNote?.get(position)!!.date
        holder.view.title_note.text = listNote[position]!!.title
        holder.view.body_note.text = listNote[position]!!.note

        holder.view.cardList.setOnClickListener {
            val addIntent = Intent(context, AddNote::class.java)
            addIntent.putExtra("editMode", "1")
            addIntent.putExtra("date", listNote[position]!!.date)
            addIntent.putExtra("title", listNote[position]!!.id)
            context.startActivity(addIntent)
        }
    }

    class MyHolder(var view:View) : RecyclerView.ViewHolder(view)
}