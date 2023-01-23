package com.brianajusta.androidchapterchallengekelompoksatu

data class GameHistoryDataClass(
    val playerOneName: String,
    val playerOneItem: Int,
    val playerTwoName: String,
    val playerTwoItem: Int,
    val gameResult: String
)

object MockSearch {
    fun getList(): List<GameHistoryDataClass> {
        return mutableListOf(
            GameHistoryDataClass(
                playerOneName = "Player 1",
                playerOneItem = R.drawable.batu,
                playerTwoName = "Player 2",
                playerTwoItem = R.drawable.kertas,
                gameResult = "Player 1 Menang"
            ),
            GameHistoryDataClass(
                playerOneName = "Player 1",
                playerOneItem = R.drawable.batu,
                playerTwoName = "COM",
                playerTwoItem = R.drawable.kertas,
                gameResult = "Player 1 Menang"
            ),
            GameHistoryDataClass(
                playerOneName = "Player 1",
                playerOneItem = R.drawable.batu,
                playerTwoName = "COM",
                playerTwoItem = R.drawable.kertas,
                gameResult = "Player 1 Menang"
            ),
            GameHistoryDataClass(
                playerOneName = "Player 1",
                playerOneItem = R.drawable.batu,
                playerTwoName = "Player 2",
                playerTwoItem = R.drawable.kertas,
                gameResult = "Player 1 Menang"
            ),
            GameHistoryDataClass(
                playerOneName = "Player 1",
                playerOneItem = R.drawable.batu,
                playerTwoName = "Player 2",
                playerTwoItem = R.drawable.kertas,
                gameResult = "Player 1 Menang"
            ),
            GameHistoryDataClass(
                playerOneName = "Player 1",
                playerOneItem = R.drawable.batu,
                playerTwoName = "Player 2",
                playerTwoItem = R.drawable.kertas,
                gameResult = "Player 1 Menang"
            ),
            GameHistoryDataClass(
                playerOneName = "Player 1",
                playerOneItem = R.drawable.batu,
                playerTwoName = "Player 2",
                playerTwoItem = R.drawable.kertas,
                gameResult = "Player 1 Menang"
            ),
            GameHistoryDataClass(
                playerOneName = "Player 1",
                playerOneItem = R.drawable.batu,
                playerTwoName = "Player 2",
                playerTwoItem = R.drawable.kertas,
                gameResult = "Player 1 Menang"
            ),
            GameHistoryDataClass(
                playerOneName = "Player 1",
                playerOneItem = R.drawable.batu,
                playerTwoName = "Player 2",
                playerTwoItem = R.drawable.kertas,
                gameResult = "Player 1 Menang"
            ),
            GameHistoryDataClass(
                playerOneName = "Player 1",
                playerOneItem = R.drawable.batu,
                playerTwoName = "Player 2",
                playerTwoItem = R.drawable.kertas,
                gameResult = "Player 1 Menang"
            ),
            GameHistoryDataClass(
                playerOneName = "Player 1",
                playerOneItem = R.drawable.batu,
                playerTwoName = "Player 2",
                playerTwoItem = R.drawable.kertas,
                gameResult = "Player 1 Menang"
            )
        )
    }
}