package com.brianajusta.androidchapterchallengekelompoksatu

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.brianajusta.androidchapterchallengekelompoksatu.databinding.FragmentGameResultDialogBinding

class GameResultDialogFragment : DialogFragment(), PlayerModelContract.View {
    private lateinit var binding: FragmentGameResultDialogBinding
    private lateinit var listener: ResultDialogListener
    private lateinit var playerOnePresenter: PlayerModelContract.Presenter
    private lateinit var playerTwoPresenter: PlayerModelContract.Presenter
    private lateinit var database: GameRoomDatabase
    private val playerOnePref by lazy {
        requireContext().getSharedPreferences("PLAYER_ONE_PREF", Context.MODE_PRIVATE)
    }
    private val playerTwoPref by lazy {
        requireContext().getSharedPreferences("PLAYER_TWO_PREF", Context.MODE_PRIVATE)
    }

    interface ResultDialogListener {
        fun resetAllTextAndItems()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            listener = activity as ResultDialogListener
        } catch (e: ClassCastException) {
            throw ClassCastException(context.toString() + "must implemented ResultDialogListener")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentGameResultDialogBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        playerOnePresenter = PlayerDataPresenter(this, playerOnePref)
        playerTwoPresenter = PlayerDataPresenter(this, playerTwoPref)

    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




        binding.tvGameResultWinnerDialog.text = calculateResult()
        binding.tvScoreResult.text = "${playerOnePresenter.getScore()}:${playerTwoPresenter.getScore()}"
        binding.tvPlayerOneNameOnScore.text = playerOnePresenter.getName()
        binding.tvPlayerTwoNameOnScore.text = playerTwoPresenter.getName()



        binding.ivCloseDialogButton.setOnClickListener {
            dismiss()
        }

        binding.btnPlayAgainDialog.setOnClickListener {
            listener.resetAllTextAndItems()
            dismiss()
        }

        binding.btnNewGameDialog.setOnClickListener {
            listener.resetAllTextAndItems()
            playerOne.resetScore()
            playerTwo.resetScore()
            val intent = Intent(activity, ChoosePlayerActivity::class.java)
            startActivity(intent)
            dismiss()
        }

        binding.btnBackToMenuDialog.setOnClickListener {
            val intent = Intent(activity, MainMenuActivity::class.java)
            startActivity(intent)
            dismiss()
        }
    }

    fun calculateResult(): String {
        if (playerOnePresenter.getItem() == playerTwoPresenter.getItem()) {
            return "DRAW!"
        } else if (playerOnePresenter.getItem() == "KERTAS" && playerTwoPresenter.getItem() == "BATU") {
            playerOnePresenter.addScore()
            return "${playerOnePresenter.getName()}\n MENANG!"
        } else if (playerOnePresenter.getItem() == "GUNTING" && playerTwoPresenter.getItem() == "KERTAS") {
            playerOnePresenter.addScore()
            return "${playerOnePresenter.getName()}\n MENANG!"
        } else if (playerOnePresenter.getItem() == "BATU" && playerTwoPresenter.getItem() == "GUNTING") {
            playerOnePresenter.addScore()
            return "${playerOnePresenter.getName()}\n MENANG!"
        } else {
            playerTwoPresenter.addScore()
            return "${playerTwoPresenter.getName()}\n MENANG!"
        }
    }

}