package com.brianajusta.androidchapterchallengekelompoksatu

class PlayerModel(private var name: String) {

    private var item: String = ""
    private var score: Int = 0


    fun getName(): String = name

    fun setName(newName: String) {
        name = newName
    }

    fun getItem(): String = item

    fun setItem(newItem: String) {
        this.item = newItem
    }

    fun getScore(): Int = score

    fun resetScore() {
        score = 0
    }

    fun addScore() {
        score++
    }


}

val playerOne = PlayerModel("Player 1")
val playerTwo = PlayerModel("COM")