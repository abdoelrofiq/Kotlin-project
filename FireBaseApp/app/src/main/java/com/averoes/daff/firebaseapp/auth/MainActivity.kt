package com.averoes.daff.firebaseapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.averoes.daff.firebaseapp.auth.ChangeEmail
import com.averoes.daff.firebaseapp.auth.RegisterActivity
import com.averoes.daff.firebaseapp.database.DailyActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val auth = FirebaseAuth.getInstance()

        btn_logout.setOnClickListener {

            auth.signOut()

            startActivity(Intent(this@MainActivity, LoginActivity::class.java))
            }
        auth.addAuthStateListener {
            if (auth.currentUser == null){
                this.finish()
            }
        }

        btn_delete.setOnClickListener {
            val user = FirebaseAuth.getInstance().currentUser
            if (user != null){
                user.delete()
                    .addOnCompleteListener {
                        Toast.makeText(this@MainActivity, "Your profile has been deleted, Let's Create New Account", Toast.LENGTH_LONG).show()
                        startActivity(Intent(this, RegisterActivity::class.java))

                    }
            }else{
                Toast.makeText(this@MainActivity, "Failed to Delete Account", Toast.LENGTH_SHORT).show()
            }
        }

        btn_changePassword.setOnClickListener {
            startActivity(Intent(this, ChangePass::class.java))
        }
        btn_changeEmail.setOnClickListener {
            startActivity(Intent(this, ChangeEmail::class.java))
        }

        btn_create_daily.setOnClickListener {
            startActivity(Intent(this, DailyActivity::class.java))
        }

    }
}
