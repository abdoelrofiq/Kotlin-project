package com.averoes.daff.firebaseapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager
import com.google.firebase.auth.FirebaseAuth

class SplashScreen : AppCompatActivity() {

    //Di bagian splashscreen untuk check user sudah login atau belum login,kalau sudah login
    //pindah langsung ke halaman utama dan belum login masuk ke loginActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //hiding title bar
        window.requestFeature(Window.FEATURE_NO_TITLE)
        //making activity fullscreen
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_splash_screen)

        var auth = FirebaseAuth.getInstance()

        //delay time
        Handler().postDelayed(Runnable{
            //start activity
            if (auth.currentUser == null){

                startActivity(Intent(this@SplashScreen, LoginActivity::class.java))
            }else{
                startActivity(Intent(this@SplashScreen, MainActivity::class.java))

            }
            //finish activity
            finish()
        }, 3000)

    }
}
