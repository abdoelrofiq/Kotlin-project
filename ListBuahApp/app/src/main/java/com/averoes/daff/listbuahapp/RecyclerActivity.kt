package com.averoes.daff.listbuahapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.averoes.daff.listbuahapp.adapter.MyRecyclerAdapter
import com.averoes.daff.listbuahapp.model.Buah
import kotlinx.android.synthetic.main.activity_recycler.*


class RecyclerActivity : AppCompatActivity() {

    val list_buah:ArrayList<Buah>? = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)

        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = MyRecyclerAdapter(this, recycler)
    }

}
