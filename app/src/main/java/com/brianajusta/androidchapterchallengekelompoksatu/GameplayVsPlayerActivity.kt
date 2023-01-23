package com.brianajusta.androidchapterchallengekelompoksatu

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.forEach
import com.brianajusta.androidchapterchallengekelompoksatu.databinding.ActivityGameplayVsComBinding
import kotlin.random.Random

class GameplayVsPlayerActivity : AppCompatActivity(), GameResultDialogFragment.ResultDialogListener  {

    private lateinit var binding: ActivityGameplayVsComBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGameplayVsComBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvPlayerOneName.text = playerOne.getName()
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
            startActivity(Intent(this, ChoosePlayerActivity::class.java))
        }

        binding.ivRestartGameButton.setOnClickListener {
            resetAllTextAndItems()
        }
    }

    private fun showTextInstructionOfPlayerTwo() {
        binding.tvPlayerTwoMessage.text = "${playerTwo.getName()},\n silahkan pilih item mu"
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
                binding.ivPlayerOneGunting.isSelected -> playerOne.setItem("GUNTING")
                binding.ivPlayerOneBatu.isSelected -> playerOne.setItem("BATU")
                binding.ivPlayerOneKertas.isSelected -> playerOne.setItem("KERTAS")
            }

            playerTwo -> when {
                binding.ivPlayerTwoGunting.isSelected -> playerTwo.setItem("GUNTING")
                binding.ivPlayerTwoBatu.isSelected -> playerTwo.setItem("BATU")
                binding.ivPlayerTwoKertas.isSelected -> playerTwo.setItem("KERTAS")
            }
        }
    }

    private fun playerTwoChoosingItem() {
        chooseRandomItem().isSelected = true
        setChosenItemTo(playerTwo)
    }

    @SuppressLint("SetTextI18n")
    private fun showTextOfPlayerChosenItem() {
        binding.tvPlayerOneMessage.text =
            "${playerOne.getName()}\n memilih ${playerOne.getItem()}."
        binding.tvPlayerTwoMessage.text =
            "${playerTwo.getName()}\n memilih ${playerTwo.getItem()}."
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
        binding.tvPlayerOneMessage.text = "${playerOne.getName()},\n silahkan pilih item mu"
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