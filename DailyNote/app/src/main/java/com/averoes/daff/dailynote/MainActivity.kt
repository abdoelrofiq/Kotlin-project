package com.averoes.daff.dailynote

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.averoes.daff.dailynote.adapter.MyAdapter
import com.averoes.daff.dailynote.model.Daily
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {


    private val databaseRef = FirebaseDatabase.getInstance().getReference("daily")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val recyclerAdpater = MyAdapter(this@MainActivity, arrayListOf())
//        val linear = LinearLayoutManager(applicationContext)

        supportActionBar!!.title = "My Note"

        databaseRef.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
                // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

                val list = ArrayList<Daily?>()
                for (postSnapshot in snapshot.children) {

//                    postSnapshot.getValue(Daily::class.java)
//                    recycler.adapter = recyclerAdpater
//                    recycler.layoutManager = linear
//                    recycler.setHasFixedSize(true)

                    val post = postSnapshot.getValue(Daily::class.java)

                    //untuk menampilkan data berdasarkan key nya
                    post!!.firebaseKey = postSnapshot.key
                    post.let { list.add(it) }

                }

                recycler.adapter = MyAdapter(this@MainActivity, listItem = list)
                recycler.layoutManager = LinearLayoutManager(this@MainActivity)
                recycler.setHasFixedSize(true)


            }

        })


    }
}
