package com.averoes.daff.firebaseapp.auth

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.averoes.daff.firebaseapp.LoginActivity
import com.averoes.daff.firebaseapp.R
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btn_register.setOnClickListener {


            val reg_username:String = username_reg.text.toString()
            val reg_password:String = password_reg.text.toString()
            val reg_confirm :String = confirm_pass.text.toString()

            if (reg_username.isEmpty()||reg_password.isEmpty()||reg_confirm.isEmpty()){

                Toast.makeText(this, "Field can't be blank", Toast.LENGTH_SHORT).show()

            }else if (!reg_confirm.equals(reg_password)){
                Toast.makeText(this, "Not Match", Toast.LENGTH_SHORT).show()
            }else{
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(reg_username, reg_password)
                    .addOnCompleteListener(this@RegisterActivity, OnCompleteListener <AuthResult>{
                        task ->  if (task.isSuccessful){
                        Toast.makeText(this, "Your Account has been Created", Toast.LENGTH_LONG).show()
                        startActivity(Intent(this@RegisterActivity, LoginActivity::class.java))
                    }else{
                        Toast.makeText(this, "Failed to Register", Toast.LENGTH_SHORT).show()
                    }
                    })
                finish()
            }


        }
    }
}
