package com.example.advancedappmovies.data.network

import com.example.advancedappmovies.data.model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

interface QuoteApiClient {
    @GET("/.json")
    suspend fun getAllQuotes() : Response<List<QuoteModel>>
}