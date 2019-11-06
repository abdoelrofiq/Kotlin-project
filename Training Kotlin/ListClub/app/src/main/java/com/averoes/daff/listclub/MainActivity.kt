package com.averoes.daff.listclub

import android.content.ClipData
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val listItem: MutableList<LIstItem> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initData()

        club_list.layoutManager = GridLayoutManager(this, 2)
        club_list.adapter = MyAdapter(this, listItem)
    }

    private fun initData(){
        val name = resources.getStringArray(R.array.club_name)
        val image = resources.obtainTypedArray(R.array.club_image)
        listItem.clear()
        for (i in name.indices) {
            listItem.add(
                LIstItem(
                    name[i],
                    image.getResourceId(i, 0)
                )
            )
        }

        //Recycle the typed array
        image.recycle()
    }
}