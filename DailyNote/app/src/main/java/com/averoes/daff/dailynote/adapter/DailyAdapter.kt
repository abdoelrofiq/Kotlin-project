package com.averoes.daff.dailynote.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.averoes.daff.dailynote.R
import com.averoes.daff.dailynote.model.Daily
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.item_daily.view.*

/**
 * Created by daff on 12/03/19 at 7:28.
 */
class DailyAdapter : RecyclerView.Adapter<DailyAdapter.Holder>() {

    private val databaseRef = FirebaseDatabase.getInstance().getReference("daily")
    private val myNote = arrayListOf<Daily>()

    init {
        databaseRef.orderByChild("date").addChildEventListener(object :ChildEventListener{
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onChildMoved(snapshot: DataSnapshot, previousKey: String?) {
               // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

                val preveiousIndex = myNote.indexOfFirst { it.firebaseKey == snapshot.key }
                val myDaily = buildNote(snapshot = snapshot)

                myNote.removeAt(preveiousIndex)

                val newIndex = myNote.indexOfFirst { it.firebaseKey == previousKey } + 1
                myNote.add(newIndex, myDaily)

                notifyItemMoved(preveiousIndex, newIndex)
            }

            override fun onChildChanged(snapshot: DataSnapshot, previousKey: String?) {
               // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                val index = myNote.indexOfFirst { it.firebaseKey == previousKey} + 1
                val myDaily = buildNote(snapshot = snapshot)

                myNote[index] = myDaily
                notifyItemChanged(index)
            }

            override fun onChildAdded(snapshot: DataSnapshot, previousKey: String?) {
                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                val previousIndex = myNote.indexOfFirst { it.firebaseKey == previousKey } + 1
                val myDaily = buildNote(snapshot = snapshot)
                val index = previousIndex + 1

                myNote.add(index = index, element = myDaily)
                notifyItemInserted(index)

            }

            override fun onChildRemoved(snapshot: DataSnapshot) {
               // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                val myDaily = findNote(snapshot = snapshot)
                val index = myNote.indexOf(myDaily)

                myNote.remove(myDaily)
                notifyItemRemoved(index)
            }

        })
    }

    private fun findNote(snapshot: DataSnapshot) = myNote.find { it.firebaseKey == snapshot.key }

    private fun buildNote(snapshot: DataSnapshot): Daily {
        val date = snapshot.child("date").getValue(String::class.java)
        val title = snapshot.child("title").getValue(String::class.java)
        val note = snapshot.child("note").getValue(String::class.java)
        val key = snapshot.key

        return Daily(title = title, note = note, date = date, firebaseKey = key)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): Holder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_daily, parent, false)

        return Holder(view)
    }

    override fun getItemCount(): Int {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return myNote.size
    }

    override fun onBindViewHolder(holder: Holder?, position: Int) {
       // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        holder?.myDaily = myNote[position]
    }

    class Holder(val view: View): RecyclerView.ViewHolder(view){

        private val titleText = view.item_title
        private val noteText = view.item_note
        private val dateText = view.item_date

        var myDaily:Daily? = null
        set(value) {
            titleText.text  = value?.title
            noteText.text = value?.note
            dateText.text = value?.date
            field = value
        }
    }
}