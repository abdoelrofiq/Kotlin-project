package com.averoes.daff.firebaseapp.auth

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.averoes.daff.firebaseapp.MainActivity
import com.averoes.daff.firebaseapp.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_change_email.*

class ChangeEmail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_email)

        val user = FirebaseAuth.getInstance().currentUser



        btn_chgEmail.setOnClickListener {
            val newEmail = chgEmail.text.toString()

            user?.updateEmail(newEmail)
                ?.addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "Email address is updated.", Toast.LENGTH_LONG).show()
                        startActivity(Intent(this, MainActivity::class.java))

                    } else {
                        Toast.makeText(this, "Failed to update email!", Toast.LENGTH_LONG).show()
                    }
                }
        }
    }
}
