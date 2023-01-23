package com.brianajusta.androidchapterchallengekelompoksatu.gamehistory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.brianajusta.androidchapterchallengekelompoksatu.GameRoomDatabase
import com.brianajusta.androidchapterchallengekelompoksatu.MainMenuActivity
import com.brianajusta.androidchapterchallengekelompoksatu.MockSearch
import com.brianajusta.androidchapterchallengekelompoksatu.databinding.ActivityGameHistoryBinding


class GameHistoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGameHistoryBinding
    private lateinit var database: GameRoomDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGameHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = GameHistoryAdapter()
        val data = MockSearch.getList()
        val manager = LinearLayoutManager(this)

        binding.rvGameHistory.layoutManager = manager
        binding.rvGameHistory.adapter = adapter
        adapter.addAll(data)

        binding.ivCloseMenuGameHistory.setOnClickListener {
            startActivity(Intent(this, MainMenuActivity::class.java))
        }


    }




}