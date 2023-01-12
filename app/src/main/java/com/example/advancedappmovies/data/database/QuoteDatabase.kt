package com.example.advancedappmovies.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.advancedappmovies.data.database.dao.QuoteDao
import com.example.advancedappmovies.data.database.entities.QuoteEntity

@Database(entities = [QuoteEntity::class], version = 1, exportSchema = false)
abstract class QuoteDatabase: RoomDatabase() {

    abstract fun getQuoteDao(): QuoteDao

}