package com.brianajusta.androidchapterchallengekelompoksatu.changename

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.brianajusta.androidchapterchallengekelompoksatu.GameRoomDatabase
import com.brianajusta.androidchapterchallengekelompoksatu.MainMenuActivity
import com.brianajusta.androidchapterchallengekelompoksatu.PlayerDataPresenter
import com.brianajusta.androidchapterchallengekelompoksatu.PlayerModelContract
import com.brianajusta.androidchapterchallengekelompoksatu.databinding.ActivityChangeNameMenuBinding

class ChangeNameMenuActivity : AppCompatActivity(), PlayerModelContract.View {

    private lateinit var binding: ActivityChangeNameMenuBinding
    private lateinit var playerOnePresenter: PlayerModelContract.Presenter
    private lateinit var playerTwoPresenter: PlayerModelContract.Presenter
    private lateinit var database: GameRoomDatabase

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityChangeNameMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val playerOnePref = getSharedPreferences("PLAYER_ONE_PREF", Context.MODE_PRIVATE)
        val playerTwoPref = getSharedPreferences("PLAYER_TWO_PREF", Context.MODE_PRIVATE)
        playerOnePresenter = PlayerDataPresenter(this, playerOnePref)
        playerTwoPresenter = PlayerDataPresenter(this, playerTwoPref)

        binding.ivClose.setOnClickListener {
            finish()
        }

        binding.btnFinish.setOnClickListener {

            val nameInputPlayerOne = binding.etPlayerOne.text.toString().trim()
            val nameInputPlayerTwo = binding.etPlayerTwo.text.toString().trim()


            playerOnePresenter.setName(nameInputPlayerOne)
            playerTwoPresenter.setName(nameInputPlayerTwo)


            val intent = Intent(this, MainMenuActivity::class.java)
            startActivity(intent)


        }


    }

}
