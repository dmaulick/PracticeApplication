package com.example.practiceapplication.Database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "drink_table")
data class Drink(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "drink_id") val drinkId: String,
    @ColumnInfo(name = "drink_name") val drinkName: String,
    @ColumnInfo(name = "drink_category") val drinkCategory: String,
    @ColumnInfo(name = "drink_alcoholic") val alcoholic: Boolean,
    @ColumnInfo(name = "drink_name") val instructions: String
)