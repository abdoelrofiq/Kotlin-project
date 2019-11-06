package com.elhazent.picodiploma.intentapp

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_sms.*
import org.jetbrains.anko.sendSMS

class SmsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sms)

        btn_kirim.setOnClickListener {
            val nomor = edt_nomor.text.toString()
            val message = edtmessage.text.toString()

            //tanpa anko library
//            val uri = Uri.parse("smsto:$nomor")
//            val intent = Intent(Intent.ACTION_SENDTO, uri)
//            intent.putExtra("sms_body", message)
//            startActivity(intent)

            sendSMS(nomor, message)
        }
    }
}
