package com.brianajusta.androidchapterchallengekelompoksatu.gameplay

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.forEach
import com.brianajusta.androidchapterchallengekelompoksatu.*
import com.brianajusta.androidchapterchallengekelompoksatu.databinding.ActivityGameplayVsComBinding
import kotlin.random.Random

class GameplayVsPlayerActivity : AppCompatActivity(), GameResultDialogFragment.ResultDialogListener,
    PlayerModelContract.View {

    private lateinit var binding: ActivityGameplayVsComBinding
    private lateinit var playerOnePresenter: PlayerModelContract.Presenter
    private lateinit var playerTwoPresenter: PlayerModelContract.Presenter
    private lateinit var database: GameRoomDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGameplayVsComBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val playerOnePref = getSharedPreferences("PLAYER_ONE_PREF", Context.MODE_PRIVATE)
        val playerTwoPref = getSharedPreferences("PLAYER_TWO_PREF", Context.MODE_PRIVATE)
        playerOnePresenter = PlayerDataPresenter(this, playerOnePref)
        playerTwoPresenter = PlayerDataPresenter(this, playerTwoPref)

        binding.tvPlayerOneName.text = playerOnePresenter.getName()
        binding.tvPlayerTwoName.text = playerTwoPresenter.getName()
        resetGameText()

        val listenerForPlayerOne = View.OnClickListener { view ->

            view.isSelected = true
            setChosenItemTo(playerOne)
            playerOneItemsIsEnabled(false)
            showTextInstructionOfPlayerTwo()
        }

        val listenerForPlayerTwo = View.OnClickListener { view ->
            view.isSelected = true
            setChosenItemTo(playerTwo)
            showGameResult()
            allPlayersItemsIsEnabled(false)
        }



        binding.ivPlayerOneBatu.setOnClickListener(listenerForPlayerOne)
        binding.ivPlayerOneKertas.setOnClickListener(listenerForPlayerOne)
        binding.ivPlayerOneGunting.setOnClickListener(listenerForPlayerOne)




        binding.ivPlayerTwoBatu.setOnClickListener(listenerForPlayerTwo)
        binding.ivPlayerTwoKertas.setOnClickListener(listenerForPlayerTwo)
        binding.ivPlayerTwoGunting.setOnClickListener(listenerForPlayerTwo)

        binding.ivHomeButton.setOnClickListener {
            startActivity(Intent(this, MainMenuActivity::class.java))
        }

        binding.ivRestartGameButton.setOnClickListener {
            resetAllTextAndItems()
        }
    }

    private fun showTextInstructionOfPlayerTwo() {
        binding.tvPlayerTwoMessage.text = "${playerTwoPresenter.getName()},\n silahkan pilih item mu"
        binding.tvPlayerOneMessage.text = ""
    }


    private fun chooseRandomItem(): View {

        val listOfItems = listOf<View>(
            binding.ivPlayerTwoGunting,
            binding.ivPlayerTwoBatu,
            binding.ivPlayerTwoKertas
        )
        val index = Random.nextInt(0, 3)

        return listOfItems[index]
    }

    private fun setChosenItemTo(player: PlayerModel) {
        when (player) {
            playerOne -> when {
                binding.ivPlayerOneGunting.isSelected -> playerOnePresenter.setItem("GUNTING")
                binding.ivPlayerOneBatu.isSelected -> playerOnePresenter.setItem("BATU")
                binding.ivPlayerOneKertas.isSelected -> playerOnePresenter.setItem("KERTAS")
            }

            playerTwo -> when {
                binding.ivPlayerTwoGunting.isSelected -> playerTwoPresenter.setItem("GUNTING")
                binding.ivPlayerTwoBatu.isSelected -> playerTwoPresenter.setItem("BATU")
                binding.ivPlayerTwoKertas.isSelected -> playerTwoPresenter.setItem("KERTAS")
            }
        }
    }


    @SuppressLint("SetTextI18n")
    private fun showTextOfPlayerChosenItem() {
        binding.tvPlayerOneMessage.text =
            "${playerOne.getName()}\n memilih ${playerOnePresenter.getItem()}."
        binding.tvPlayerTwoMessage.text =
            "${playerTwo.getName()}\n memilih ${playerTwoPresenter.getItem()}."
    }

    private fun showGameResultDialog() {
        val fragmentManager = supportFragmentManager
        val winnerDialogFragment = GameResultDialogFragment()
        winnerDialogFragment.show(fragmentManager, "fragment_winner_dialog")
    }

    private fun showGameResult() {
        showGameResultDialog()
        showTextOfPlayerChosenItem()
    }

    private fun allPlayersItemsIsEnabled(boolean: Boolean) {
        binding.clPlayerOneItemList.forEach { it.isEnabled = boolean }
        binding.clPlayerTwoItemList.forEach { it.isEnabled = boolean }
    }

    private fun playerOneItemsIsEnabled(boolean: Boolean) {
        binding.clPlayerOneItemList.forEach { it.isEnabled = boolean }
    }

    @SuppressLint("SetTextI18n")
    private fun resetGameText() {
        binding.tvPlayerOneMessage.text = "${playerOnePresenter.getName()},\n silahkan pilih item mu"
        binding.tvPlayerTwoMessage.text = ""
    }

    override fun resetAllTextAndItems() {
        resetGameText()
        resetAllItems()
    }

    private fun resetAllItems() {
        allPlayersItemsIsEnabled(true)
        allPlayersItemsIsUnselected()
    }

    private fun allPlayersItemsIsUnselected() {
        binding.clPlayerOneItemList.forEach { it.isSelected = false }
        binding.clPlayerTwoItemList.forEach { it.isSelected = false }
    }


}