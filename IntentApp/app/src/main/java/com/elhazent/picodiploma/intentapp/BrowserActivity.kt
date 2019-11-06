package com.elhazent.picodiploma.intentapp

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_browser.*
import kotlinx.android.synthetic.main.activity_call.*
import org.jetbrains.anko.browse

class BrowserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_browser)

        btn_search.setOnClickListener {
            val link = "https://${edt_link.text}"

            //tanpa anko library
//            val uri = Uri.parse(link)
//            val intent = Intent(Intent.ACTION_VIEW, uri)
//            startActivity(intent)

            browse(link)
        }
    }
}
