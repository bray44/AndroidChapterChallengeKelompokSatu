package com.brianajusta.androidchapterchallengekelompoksatu.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.brianajusta.androidchapterchallengekelompoksatu.databinding.ActivitySplashScreenBinding
import com.brianajusta.androidchapterchallengekelompoksatu.landingpage.LandingPageActivity

class SplashScreen : AppCompatActivity() {

    private val binding : ActivitySplashScreenBinding by lazy {
        ActivitySplashScreenBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        Handler().postDelayed({
            val intent = Intent(this@SplashScreen, LandingPageActivity::class.java)
            startActivity(intent)
            finish()
        },5000)
    }
}