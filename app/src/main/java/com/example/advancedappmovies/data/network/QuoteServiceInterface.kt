package com.example.advancedappmovies.data.network

import com.example.advancedappmovies.data.model.QuoteModel

interface QuoteServiceInterface {
    suspend fun getQuotes(): List<QuoteModel>
}