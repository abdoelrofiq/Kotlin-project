package com.averoes.daff.firebaseapp

import android.content.DialogInterface
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.util.Log
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_change.*

class ChangePass : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change)

        val user = FirebaseAuth.getInstance().currentUser



        btn_chgPasseword.setOnClickListener {
           val newPassword = chg_password.text.toString()

            user?.updatePassword(newPassword)
                ?.addOnCompleteListener {task ->

                    if (task.isSuccessful) {
                        Toast.makeText(this, "Password has been Changed", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this, MainActivity::class.java))

                    } else {
                        Toast.makeText(this, "Failed to change password", Toast.LENGTH_SHORT).show()
                        Log.e("Change: " , "Failed")
                    }
                }
        }
    }
}
