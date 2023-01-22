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

class GameResultDialogFragment : DialogFragment() {
    private lateinit var binding: FragmentGameResultDialogBinding
    private lateinit var listener: ResultDialogListener

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

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvGameResultWinnerDialog.text = SutJepangModel.calculateResult()
        binding.tvScoreResult.text = "${playerOne.getScore()}:${playerTwo.getScore()}"
        binding.tvPlayerOneNameOnScore.text = playerOne.getName()
        binding.tvPlayerTwoNameOnScore.text = playerTwo.getName()


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
}