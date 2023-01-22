package com.brianajusta.androidchapterchallengekelompoksatu.landingpage

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.brianajusta.androidchapterchallengekelompoksatu.LoginScreen
import com.brianajusta.androidchapterchallengekelompoksatu.R
import com.brianajusta.androidchapterchallengekelompoksatu.databinding.ActivityLandingPageBinding
import com.brianajusta.androidchapterchallengekelompoksatu.databinding.LoginScreenBinding

class LandingPage : AppCompatActivity() {
    private lateinit var binding: ActivityLandingPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLandingPageBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val text1 = "GAME SUIT VS PLAYER2"
        val text2 = "GAME SUIT VS COMPUTER"
        val text3 = "teks 3"
        val fragmentOne = LandingPageFragment.newInstance(R.drawable.ic_landing_page1, text1)
        val fragmentTwo = LandingPageFragment.newInstance(R.drawable.ic_landing_page2, text2)
        //val fragmentThree = LandingPageFragment.newInstance(R.drawable.landingpage3, teks3)

        val listFragment = listOf(fragmentOne,fragmentTwo)
        val adapter = LandingPageAdapter(
            fragmentManager = supportFragmentManager,
            lifecycle = lifecycle,
            data = listFragment
        )

        binding.vpLandingpage.adapter = adapter
    }

}