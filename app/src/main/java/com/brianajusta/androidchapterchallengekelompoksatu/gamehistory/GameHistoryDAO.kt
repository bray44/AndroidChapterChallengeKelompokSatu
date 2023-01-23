package com.brianajusta.androidchapterchallengekelompoksatu.gamehistory

import androidx.room.*


@Dao
interface GameHistoryDAO {
    // function read
    @Query("SELECT * FROM Search")
    fun getList(): List<GameHistoryEntity>

    // function insert & update
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(value: GameHistoryEntity)

    // function delete
    @Delete
    suspend fun delete(value: GameHistoryEntity)
}