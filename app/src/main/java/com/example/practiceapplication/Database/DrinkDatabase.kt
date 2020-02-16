package com.example.practiceapplication.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.practiceapplication.Utils.DATABASE_NAME

@Database(entities = [Drink::class], version = 1)
abstract class DrinkDatabase : RoomDatabase() {
    abstract fun drinkDao(): DrinkDao

    companion object {

        // For Singleton instantiation
        @Volatile private var instance: DrinkDatabase? = null

        fun getInstance(context: Context): DrinkDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        // Create and pre-populate the database. See this article for more details:
        // https://medium.com/google-developers/7-pro-tips-for-room-fbadea4bfbd1#4785
        private fun buildDatabase(context: Context): DrinkDatabase {

            return Room.databaseBuilder(context, DrinkDatabase::class.java, DATABASE_NAME)
                .addCallback(object : RoomDatabase.Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)

                        // Look into on sunflower -- good way of pre populating the database with workmanager
//                        val request = OneTimeWorkRequestBuilder<SeedDatabaseWorker>().build()
//                        WorkManager.getInstance(context).enqueue(request)
                        // Some more info on worker
                        //https://medium.com/androiddevelopers/workmanager-meets-kotlin-b9ad02f7405e
                    }
                })
                .build()
        }
    }
}