package com.averoes.daff.bangundatarapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_move.*

class MoveActivity : AppCompatActivity() {
    val KEY_1:String = "nilai1"
    val KEY_2:String = "nilai2"
    val KEY_3:String = "hasil"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move)

        val intent = intent
        val alas = intent.getStringExtra(KEY_1)
        val tinggi = intent.getStringExtra(KEY_2)
        val hasil = intent.getStringExtra(KEY_3)

        txt_alas.setText("Alas: "+ alas)
        txt_tinggi.setText("Tinggi: "+ tinggi)
        txt_hasil1.setText("Hasil: "+ hasil)

        btn_back.setOnClickListener {
          val homeIntent = Intent(this, MainActivity::class.java)
            startActivity(homeIntent)
            finish()
        }
    }
}
