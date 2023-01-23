package com.brianajusta.androidchapterchallengekelompoksatu.gameplay

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.brianajusta.androidchapterchallengekelompoksatu.*
import com.brianajusta.androidchapterchallengekelompoksatu.databinding.ActivityChoosePlayerBinding

class ChoosePlayerActivity : AppCompatActivity(), PlayerModelContract.View {
    private lateinit var binding: ActivityChoosePlayerBinding

    private lateinit var playerOnePresenter: PlayerModelContract.Presenter
    private lateinit var playerTwoPresenter: PlayerModelContract.Presenter
    private lateinit var database: GameRoomDatabase

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChoosePlayerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val playerOnePref = getSharedPreferences("PLAYER_ONE_PREF", Context.MODE_PRIVATE)
        val playerTwoPref = getSharedPreferences("PLAYER_TWO_PREF", Context.MODE_PRIVATE)
        playerOnePresenter = PlayerDataPresenter(this, playerOnePref)
        playerTwoPresenter = PlayerDataPresenter(this, playerTwoPref)

        binding.tvPlayerVsPlayer.text = "${playerOnePresenter.getName()} vs ${playerTwoPresenter.getName()}"
        binding.tvPlayerVsCom.text = "${playerOnePresenter.getName()} vs COM"



        binding.clPlayerVsCom.setOnClickListener {
            startActivity(Intent(this, GameplayVsComActivity::class.java))
            playerOnePresenter.resetScore()
            playerTwoPresenter.resetScore()
        }

        binding.clPlayerVsPlayer.setOnClickListener {
            startActivity(Intent(this, GameplayVsPlayerActivity::class.java))
            playerOnePresenter.resetScore()
            playerTwoPresenter.resetScore()
        }

        binding.ivCloseBtnChoosePlayer.setOnClickListener {
            startActivity(Intent(this, MainMenuActivity::class.java))
        }
    }


}