package com.averoes.daff.footballapp.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.averoes.daff.footballapp.R
import com.averoes.daff.footballapp.mvp.model.EventsItem
import org.jetbrains.anko.find
import org.jetbrains.anko.sdk27.coroutines.onClick

/**
 * Created by daff on 19/03/19 at 11:32.
 */
class MyAdapter(private val liga: MutableList<EventsItem>,
                        private val listener : (EventsItem)-> Unit) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    //untuk membuat tampilan / layout
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyAdapter.MyViewHolder {
        val v: View = LayoutInflater.from(p0.context)
            .inflate(R.layout.listliga, p0, false)
        return MyViewHolder(v)
    }

    //untuk deklarasi dan inisialisasi dari view/widget yang ada dilayout
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        val dateliga: TextView = itemView.find(R.id.event_date)
        val scorehome: TextView? = itemView.find(R.id.home_team_score)
        val scoreaway: TextView? = itemView.find(R.id.away_team_score)
        val teamhome: TextView = itemView.find(R.id.home_team)
        val teamaway: TextView = itemView.find(R.id.away_team)

        fun bindItem(
            eventsItem: EventsItem,
            listener: (EventsItem) -> Unit
        ) {
            dateliga.text = eventsItem.strDate
            scorehome?.text = eventsItem.intHomeScore.toString()
            scoreaway?.text = eventsItem.intAwayScore.toString()
            teamhome.text = eventsItem.strHomeTeam
            teamaway.text = eventsItem.strAwayTeam
            itemView.onClick { listener(eventsItem)
            }
        }
    }


    //untuk menghitung jumlah data yang akan ditampilkan
    override fun getItemCount(): Int = liga.size

    //untuk mengisi view sesuai dengan data
    override fun onBindViewHolder(p0: MyAdapter.MyViewHolder, p1: Int) {
        p0.bindItem(liga[p1],listener)

    }
}