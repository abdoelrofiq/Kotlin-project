package com.elhazent.picodiploma.intentapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_move.setOnClickListener {
            startActivity(Intent(this, MoveActivity::class.java))
        }
        btn_move_data.setOnClickListener {

            //tanpa anko library
//            val intent:Intent = Intent(this, DataActivity::class.java)
//            intent.putExtra("data", nama)
//            startActivity(intent)

            val nama = edt_nama.text.toString().trim()

                startActivity(intentFor<DataActivity>(
                    "data" to nama))


        }
        btn_call.setOnClickListener {
            //tanpa anko libarary
            //startActivity(Intent(this, CallActivity::class.java))
            startActivity(intentFor<CallActivity>())
        }
        btn_browser.setOnClickListener {

            //tanpa anko libarary
           // startActivity(Intent(this, BrowserActivity::class.java))
            startActivity(intentFor<BrowserActivity>())
        }
        btn_sms.setOnClickListener {

            //tanpa anko libarary
           // startActivity(Intent(this, SmsActivity::class.java))
            startActivity(intentFor<SmsActivity>())
        }
    }
}
