package com.example.advancedappmovies.domain

import com.example.advancedappmovies.data.QuoteRepository
import com.example.advancedappmovies.data.model.QuoteModel
import com.example.advancedappmovies.domain.model.Quote
import javax.inject.Inject

class GetRandomQuotesUseCase @Inject constructor(private val repository: QuoteRepository) {
    suspend operator fun invoke(): Quote? {
        val quotes = repository.getAllQuotesFromDatabase()
        if(!quotes.isNullOrEmpty()){
            return quotes[(quotes.indices).random()]
        }
        return null
    }
}