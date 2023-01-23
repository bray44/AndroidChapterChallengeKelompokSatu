package com.brianajusta.androidchapterchallengekelompoksatu.tutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.brianajusta.androidchapterchallengekelompoksatu.tutorial.TutorialFragment
import com.brianajusta.androidchapterchallengekelompoksatu.databinding.ActivityTutorialBinding

class TutorialActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTutorialBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTutorialBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tutorialFragmentOne: TutorialFragment by lazy {
            TutorialFragment.newInstance(
                title = "Tutorial",
                content = "- Selamat datang pada Tutorial Bermain Kertas Gunting batu. " +
                        "Dari menu Main menu anda dapat memilih pilihan (Play, Change Name dan Tutorial). " +
                        "Pada menu Play anda akan disuguhkan dengan dua mode permainan antara player vs player atau player versus komputer",
            )
        }

        val tutorialFragmentTwo: TutorialFragment by lazy {
            TutorialFragment.newInstance(
                title = "Tutorial",
                content = "- Untuk permainannya sendiri anda akan di beri pilihan untuk memilih antara (Kertas, gunting dan batu). " +
                        "Setelah memilih pilihan makan pemain ke dua akan dapat memilih pilihannya atau jika anda melawan komputer maka komputer akan memilih pilihannya secara acak. ",
            )
        }

        val tutorialFragmentThree: TutorialFragment by lazy {
            TutorialFragment.newInstance(
                title = "Tutorial",
                content = "- Setelah selesai bertanding maka akan muncul pesan yang memunculkan skor hasil pertandingan. \n" +
                        "- Sedangkan pada menu Change name anda akan dapat memasukkan nama pemain 1 dan nama pemain 2.",
            )
        }

        val listFragment = listOf(
            tutorialFragmentOne,
            tutorialFragmentTwo,
            tutorialFragmentThree,
        )

        val adapter = TutorialAdapter(
            fragmentManager = supportFragmentManager,
            lifecycle = lifecycle,
            data = listFragment
        )

        binding.viewpager.adapter = adapter

        binding.ivClose.setOnClickListener{
           finish() }
    }
}