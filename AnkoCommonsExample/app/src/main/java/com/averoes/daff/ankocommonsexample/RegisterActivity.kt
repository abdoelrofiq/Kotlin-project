package com.averoes.daff.ankocommonsexample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.toast

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val auth = FirebaseAuth.getInstance()

        btn_register.setOnClickListener {
            val username = reg_user_name.text.toString().trim()
            val password = reg_user_pass.text.toString().trim()
            val confirmPass = user_conf_pass.text.toString().trim()

            handleRegister(username = username, pass = password, confir = confirmPass)

            startActivity(intentFor<LoginActivity>())
        }

        auth.createUserWithEmailAndPassword()
    }
    private fun handleRegister(username: String, pass: String, confir: String) {

        when{
            username.isEmpty() -> toast("Username is required")
            pass.isEmpty() -> toast("Password is required")
            confir.isEmpty() -> toast("Confirm is required")
            else -> alert(title = "Succes", message = "Your account has been created"){
                positiveButton(buttonText = "OK"){
                }
            }.show()
        }
    }
}
