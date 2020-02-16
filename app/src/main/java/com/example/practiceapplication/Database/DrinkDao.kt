package com.example.practiceapplication.Database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DrinkDao {
    @Query("SELECT * FROM drink_table")
    fun getAll(): List<Drink>

    @Query("SELECT * FROM drink_table WHERE drink_id IN (:drinkIds)")
    fun loadAllByIds(drinkIds: IntArray): List<Drink>

    @Query("SELECT * FROM drink_table WHERE drink_name LIKE :drinkName LIMIT 1")
    fun findByName(drinkName: String): Drink

    @Insert
    fun insertAll(vararg drinks: Drink)

    @Delete
    fun delete(drink: Drink)
}