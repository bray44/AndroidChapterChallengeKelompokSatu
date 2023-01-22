package com.brianajusta.androidchapterchallengekelompoksatu

class SutJepangModel {
    companion object {
        fun calculateResult(): String {
           if (playerOne.getItem() == playerTwo.getItem()) {
                return "DRAW!"
            } else if (playerOne.getItem() == "KERTAS" && playerTwo.getItem() == "BATU") {
                playerOne.addScore()
                return "${playerOne.getName()}\n MENANG!"
            } else if (playerOne.getItem() == "GUNTING" && playerTwo.getItem() == "KERTAS") {
                playerOne.addScore()
                return "${playerOne.getName()}\n MENANG!"
            } else if (playerOne.getItem() == "BATU" && playerTwo.getItem() == "GUNTING") {
                playerOne.addScore()
                return "${playerOne.getName()}\n MENANG!"
            } else {
                playerTwo.addScore()
                return "${playerTwo.getName()}\n MENANG!"
            }
        }
    }
}