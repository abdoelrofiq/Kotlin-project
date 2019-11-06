package com.averoes.daff.listbuahapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import com.averoes.daff.listbuahapp.adapter.MyAdapter
import com.averoes.daff.listbuahapp.model.Buah
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var listView: ListView? = null
    private var myAdapter: MyAdapter? = null
    private var items: ArrayList<Buah>? = null
    private val nama_buah = arrayOf("Alpukat", "Melon", "Apel", "Mangga", "Jeruk")
    private val img_buah = intArrayOf(
        R.drawable.avocado,
        R.drawable.melon,
        R.drawable.apel,
        R.drawable.mangga,
        R.drawable.jeruk
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.listview)
        items = listBuah()
        Log.d("MainActivity", items!!.size.toString()+ "")
        myAdapter = MyAdapter(this, items!!)
        listView!!.adapter = myAdapter

        btn_go.setOnClickListener {
            startActivity(Intent(this, RecyclerActivity::class.java))
        }

    }

    private fun listBuah(): ArrayList<Buah>? {

        val list = ArrayList<Buah>()

        for (item in 0..4){
            val data_buah = Buah()
            data_buah.setNamaBUah(nama_buah[item])
            data_buah.setGambarBuah(img_buah[item])
            list.add(data_buah)

        }

        return list
    }

}