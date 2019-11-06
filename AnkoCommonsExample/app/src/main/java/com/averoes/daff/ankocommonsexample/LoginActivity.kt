package com.averoes.daff.ankocommonsexample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_login.setOnClickListener {
            val username = user_name.text.toString().trim()
            val password = user_pass.text.toString().trim()
            handleLogin(username = username, password =  password)

        }
        text_create.setOnClickListener {
            startActivity(intentFor<RegisterActivity>())
            finish()
        }
    }

    private fun handleLogin(username: String, password:String){

        if (username == "anko" && password == "kotlin"){
            //intent anko commons
            startActivity(intentFor<HomeActivity>().putExtra("username", username))
            finish()
        }else{
            alert(title = "Login Failed", message = "Email or Password is incorrect"){
                positiveButton(buttonText = "Try Again"){
                }
            }.show()
        }

    }
}
