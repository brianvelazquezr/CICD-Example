package com.example.advancedappmovies.data.network

import com.example.advancedappmovies.core.RetrofitHelper
import com.example.advancedappmovies.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class QuoteService @Inject constructor(private val api : QuoteApiClient) {

    suspend fun getQuotes(): List<QuoteModel> {
        return withContext(Dispatchers.IO){
            val response = api.getAllQuotes()
            response.body() ?: emptyList()
        }
    }

}