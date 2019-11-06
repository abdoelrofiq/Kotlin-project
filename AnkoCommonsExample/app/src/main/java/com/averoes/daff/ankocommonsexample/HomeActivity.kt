package com.averoes.daff.ankocommonsexample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val hello = "Welcome "
        val intent = intent
        val username = intent.getStringExtra("username")
        hello_user.setText(hello + username)

    }
}
