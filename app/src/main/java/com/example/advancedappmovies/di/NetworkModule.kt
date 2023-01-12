package com.example.advancedappmovies.di

import com.example.advancedappmovies.data.network.QuoteApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit():Retrofit = Retrofit.Builder()
        .baseUrl("https://drawsomething-59328-default-rtdb.europe-west1.firebasedatabase.app/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Singleton
    @Provides
    fun provideQuoteApiClient(retrofit: Retrofit):
            QuoteApiClient = retrofit.create(QuoteApiClient::class.java)

}