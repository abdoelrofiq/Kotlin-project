package com.elhazent.picodiploma.intentapp

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.text.TextUtils
import kotlinx.android.synthetic.main.activity_call.*
import org.jetbrains.anko.makeCall

class CallActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_call)

        btn_panggil.setOnClickListener {
            val nohp = edt_number.text.toString()

            //tanpa anko library
//            val uri = Uri.parse("tel:$nohp")
//            val intent = Intent(Intent.ACTION_DIAL, uri)
//            startActivity(intent)

            makeCall(nohp)
        }
    }
}
