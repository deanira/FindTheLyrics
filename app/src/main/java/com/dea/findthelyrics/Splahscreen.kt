package com.dea.findthelyrics

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.airbnb.lottie.LottieAnimationView

class Splahscreen : AppCompatActivity() {
    //private val duration = 3000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splahscreen)
        supportActionBar?.hide()

        val lottieAnimation: LottieAnimationView = findViewById(R.id.lottie_animation)

        lottieAnimation.alpha = 0f
        lottieAnimation.animate().setDuration(3000).alpha(1f).withEndAction{
            val Intent = Intent(this,MainActivity::class.java)
            startActivity(Intent)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        }
//        Handler().postDelayed({
//            startActivity(Intent(this, MainActivity::class.java))
//            finish()
//        },duration)
    }
}