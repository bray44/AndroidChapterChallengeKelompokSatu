package com.brianajusta.androidchapterchallengekelompoksatu

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.brianajusta.androidchapterchallengekelompoksatu.databinding.ActivityChoosePlayerBinding

class ChoosePlayerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityChoosePlayerBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChoosePlayerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvPlayerVsPlayer.text = "${playerOne.getName()} vs Pemain"
        binding.tvPlayerVsCom.text = "${playerOne.getName()} vs COM"


        binding.clPlayerVsCom.setOnClickListener {
            startActivity(Intent(this, GameplayVsComActivity::class.java))
        }

        binding.clPlayerVsPlayer.setOnClickListener {
            startActivity(Intent(this, GameplayVsPlayerActivity::class.java))
        }
    }
}