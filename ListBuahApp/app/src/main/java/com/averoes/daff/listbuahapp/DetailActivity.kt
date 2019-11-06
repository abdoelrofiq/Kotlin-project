package com.averoes.daff.listbuahapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_deail.*
import kotlinx.android.synthetic.main.model_recycler.*

class DetailActivity : AppCompatActivity() {

    val KEY_NAME:String = "nama"
    val KEY_IMG:String = "img"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deail)

        var detailIntent = intent

        text_detail.setText(detailIntent.getStringExtra(KEY_NAME))
        img_detail.setImageResource(detailIntent.getIntExtra(KEY_IMG, 0))
    }
}
