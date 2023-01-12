package com.example.advancedappmovies.data

import com.example.advancedappmovies.data.database.dao.QuoteDao
import com.example.advancedappmovies.data.database.entities.QuoteEntity
import com.example.advancedappmovies.data.model.QuoteModel
import com.example.advancedappmovies.data.network.QuoteService
import com.example.advancedappmovies.domain.model.Quote
import com.example.advancedappmovies.domain.model.toDomain
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val api : QuoteService,
    private val quoteDao: QuoteDao
){

    suspend fun getAllQuotesFromApi(): List<Quote>{
        val response: List<QuoteModel> = api.getQuotes()

        return response.map { it.toDomain() }
    }

    suspend fun getAllQuotesFromDatabase(): List<Quote>{
        val response: List<QuoteEntity> = quoteDao.getAllQuotes()
        return response.map { it.toDomain() }
    }

    suspend fun insertQuotes(quotes: List<QuoteEntity>) {
        quoteDao.insertAll(quotes)
    }

    suspend fun clearQuotes() {
        quoteDao.deleteAllQuotes()
    }

}