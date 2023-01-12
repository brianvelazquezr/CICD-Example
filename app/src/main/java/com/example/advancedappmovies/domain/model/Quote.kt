package com.example.advancedappmovies.domain.model

import com.example.advancedappmovies.data.database.entities.QuoteEntity
import com.example.advancedappmovies.data.model.QuoteModel

data class Quote(
    val quote: String,
    val author: String
)

fun QuoteModel.toDomain() = Quote(quote,author)
fun QuoteEntity.toDomain() = Quote(quote,author)