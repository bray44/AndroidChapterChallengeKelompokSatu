package com.brianajusta.androidchapterchallengekelompoksatu

import android.content.SharedPreferences
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PlayerDataPresenter(
    private var view: PlayerModelContract.View,
    private var sharedPreferences: SharedPreferences
): PlayerModelContract.Presenter{
    override fun setName(newName: String) {
        sharedPreferences.edit().putString("NAME", newName).apply()
    }

    override fun getName(): String? {
        return sharedPreferences.getString("NAME", "Player")
    }

    override fun setItem(newItem: String) {
        sharedPreferences.edit().putString("ITEM", newItem).apply()
    }

    override fun getItem(): String? {
        return sharedPreferences.getString("ITEM", "None")
    }

    override fun addScore() {


        val currentScore = sharedPreferences.getInt("SCORE", 0)
        val updatedScore = currentScore + 1
        sharedPreferences.edit().putInt("SCORE", updatedScore).apply()
    }

    override fun resetScore() {
        sharedPreferences.edit().putInt("SCORE", 0).apply()
    }

    override fun getScore(): Int {
        return sharedPreferences.getInt("SCORE", 0)
    }





}