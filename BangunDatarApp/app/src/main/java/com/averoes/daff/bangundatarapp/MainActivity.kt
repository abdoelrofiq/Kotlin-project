package com.averoes.daff.bangundatarapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

     val KEY_1:String = "nilai1"
     val KEY_2:String = "nilai2"
     val KEY_3:String = "hasil"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnpindah.setOnClickListener {
            if (txt_hasil.text.isEmpty()){

            }else{
                var intent = Intent(this, MoveActivity::class.java)
                intent.putExtra(KEY_1, nilai1.text.toString())
                intent.putExtra(KEY_2, nilai2.text.toString())
                intent.putExtra(KEY_3, txt_hasil.text.toString())
                startActivity(intent)
                finish()
            }
        }
        btnhitung.setOnClickListener {
            val angka1 = nilai1.text.toString()
            val angka2 = nilai2.text.toString()

            if (angka1.isEmpty()){
                nilai1.requestFocus()
                nilai1.setError("Nilai Satu Harus Diisi")
            }else if (angka2.isEmpty()){
                nilai2.requestFocus()
                nilai2.setError("Nilai Dua Harus Diisi")

            }else{
                val alas:Double = angka1.toDouble()
                val tinggi = angka2.toDouble()
                val hasil = (alas * tinggi)
                txt_hasil.setText(hasil.toString())
            }
        }
    }
}
