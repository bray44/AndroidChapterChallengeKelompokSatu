package com.brianajusta.androidchapterchallengekelompoksatu.landingpage

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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


        val text1 = "Bermain Suit VS Sesama Player"
        val text2 = "Bermain Suit VS Computer"
        val text3 = "teks 3"
        val fragmentOne = LandingPageFragment.newInstance(R.drawable.ic_landing_page1, text1,View.INVISIBLE)
        val fragmentTwo = LandingPageFragment.newInstance(R.drawable.ic_landing_page2, text2,View.VISIBLE)
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