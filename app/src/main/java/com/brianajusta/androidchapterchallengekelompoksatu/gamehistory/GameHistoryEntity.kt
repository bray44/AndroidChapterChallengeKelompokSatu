package com.brianajusta.androidchapterchallengekelompoksatu.gamehistory

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Search")
data class GameHistoryEntity (
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "playerOneName")val playerOneName: String,
    @ColumnInfo(name = "playerOneItem")val playerOneItem: Int,
    @ColumnInfo(name = "playerTwoName")val playerTwoName: String,
    @ColumnInfo(name = "playerTwoItem")val playerTwoItem: Int,
    @ColumnInfo(name = "gameResult") val gameResult: String
)


