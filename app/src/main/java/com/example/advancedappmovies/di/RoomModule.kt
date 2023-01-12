package com.example.advancedappmovies.di

import android.content.Context
import androidx.room.Room
import com.example.advancedappmovies.data.database.QuoteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    private const val QUOTE_DABASE_NAME = "quote_database"

   @Singleton
   @Provides
   fun provideRoom(@ApplicationContext context: Context) =
       Room.databaseBuilder(context, QuoteDatabase::class.java, QUOTE_DABASE_NAME).build()

    @Singleton
    @Provides
    fun provideQuoteDao(db: QuoteDatabase) = db.getQuoteDao()

}