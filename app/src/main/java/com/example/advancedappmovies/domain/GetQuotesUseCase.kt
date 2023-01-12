package com.example.advancedappmovies.domain

import com.example.advancedappmovies.data.QuoteRepository
import com.example.advancedappmovies.data.database.entities.toDatabase
import com.example.advancedappmovies.data.model.QuoteModel
import com.example.advancedappmovies.domain.model.Quote
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(
    private val repository: QuoteRepository
) {

    suspend operator fun invoke(): List<Quote> {
        val quotes = repository.getAllQuotesFromApi()

        return if(quotes.isNotEmpty()){
            repository.clearQuotes()
            repository.insertQuotes(quotes.map { it.toDatabase() })
            quotes
        }else{
            repository.getAllQuotesFromDatabase()
        }

    }

}