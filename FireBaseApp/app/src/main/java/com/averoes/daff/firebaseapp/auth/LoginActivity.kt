package com.averoes.daff.firebaseapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import com.averoes.daff.firebaseapp.auth.RegisterActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.requestFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_login)

        btn_login.setOnClickListener {
            val input_username = username.text.toString()
            val input_password = password.text.toString()

            if (input_password.isEmpty()||input_username.isEmpty()){
                Toast.makeText(this, "Please Insert Email and Password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            FirebaseAuth.getInstance().signInWithEmailAndPassword(input_username, input_password)
                .addOnCompleteListener{
                    if (!it.isSuccessful){
                        return@addOnCompleteListener
                    }else{
                        Toast.makeText(this, "Successfully Login", Toast.LENGTH_SHORT).show()
                        val homeIntent = Intent(this, MainActivity::class.java)
                        startActivity(homeIntent)
                    }
                }
                .addOnFailureListener {
                    Log.w("Main", "Failed Login: ${it.message}")
                    Toast.makeText(this, "Email/Password Incorrect", Toast.LENGTH_SHORT).show()
                }

        }

        register.setOnClickListener {
            startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))
        }
    }
}
