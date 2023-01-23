package com.brianajusta.androidchapterchallengekelompoksatu

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.brianajusta.androidchapterchallengekelompoksatu.changename.ChangeNameMenuActivity
import com.brianajusta.androidchapterchallengekelompoksatu.databinding.ActivityMainMenuBinding
import com.brianajusta.androidchapterchallengekelompoksatu.gamehistory.GameHistoryActivity
import com.brianajusta.androidchapterchallengekelompoksatu.gameplay.ChoosePlayerActivity
import com.brianajusta.androidchapterchallengekelompoksatu.tutorial.TutorialActivity

class MainMenuActivity : AppCompatActivity(), PlayerModelContract.View {

    private lateinit var binding: ActivityMainMenuBinding
    private lateinit var playerOnePresenter: PlayerModelContract.Presenter
    private lateinit var playerTwoPresenter: PlayerModelContract.Presenter
    private lateinit var database: GameRoomDatabase
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val playerOnePref = getSharedPreferences("PLAYER_ONE_PREF", Context.MODE_PRIVATE)
        val playerTwoPref = getSharedPreferences("PLAYER_TWO_PREF", Context.MODE_PRIVATE)
        playerOnePresenter = PlayerDataPresenter(this, playerOnePref)
        playerTwoPresenter = PlayerDataPresenter(this, playerTwoPref)

        binding.tvWelcomePlayer.text = "Selamat Datang, ${playerOnePresenter.getName()}"

        binding.btnPlay.setOnClickListener {
            startActivity(Intent(this, ChoosePlayerActivity::class.java))
        }

        binding.btnGameHistory.setOnClickListener {
            startActivity(Intent(this, GameHistoryActivity::class.java))
        }

        binding.btnChangeName.setOnClickListener {
            startActivity(Intent(this, ChangeNameMenuActivity::class.java))
        }

        binding.btnTutorial.setOnClickListener {
            startActivity(Intent(this, TutorialActivity::class.java))
        }
    }
}