package com.brianajusta.androidchapterchallengekelompoksatu

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.brianajusta.androidchapterchallengekelompoksatu.gamehistory.GameHistoryDAO
import com.brianajusta.androidchapterchallengekelompoksatu.gamehistory.GameHistoryEntity
import kotlinx.coroutines.CoroutineScope


@Database(entities = [GameHistoryEntity::class], exportSchema = false, version = 1)
abstract class GameRoomDatabase : RoomDatabase() {
    abstract fun gameHistoryDAO(): GameHistoryDAO

    companion object {
        @Volatile
        private var INSTANCE: GameRoomDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): GameRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    GameRoomDatabase::class.java,
                    "career_db"
                ).addCallback(CareerCallback(scope))
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }

    class CareerCallback(val scope: CoroutineScope) : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
        }
    }
}