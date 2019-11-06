package com.averoes.daff.prayertime.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.averoes.daff.prayertime.R
import com.averoes.daff.prayertime.presenter.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val Main
    val mainPresenter : MainPresenter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputKota = input_city.text.toString().trim()
       btn_search.setOnClickListener {
           mainPresenter?.getKota(input_city.text.toString().trim())
       }
    }
}
