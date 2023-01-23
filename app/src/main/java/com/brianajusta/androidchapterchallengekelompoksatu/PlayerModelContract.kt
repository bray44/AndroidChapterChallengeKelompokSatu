package com.brianajusta.androidchapterchallengekelompoksatu

interface PlayerModelContract {

    interface View: PlayerModelContract {

    }

    interface Presenter: PlayerModelContract {

        fun setName(newName: String)
        fun getName(): String?
        fun setItem(newItem: String)
        fun getItem(): String?
        fun addScore()
        fun resetScore()
        fun getScore(): Int


    }

}