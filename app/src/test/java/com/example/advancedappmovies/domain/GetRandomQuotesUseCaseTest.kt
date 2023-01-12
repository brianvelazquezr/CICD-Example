package com.example.advancedappmovies.domain

import com.example.advancedappmovies.data.QuoteRepository
import com.example.advancedappmovies.domain.model.Quote
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test


class GetRandomQuotesUseCaseTest {
    @RelaxedMockK
    private lateinit var quoteRepository: QuoteRepository

    lateinit var getRandomQuotesUseCase: GetRandomQuotesUseCase

    @Before
    fun onBefore(){
        MockKAnnotations.init(this)
        getRandomQuotesUseCase = GetRandomQuotesUseCase(quoteRepository)
    }

    @Test
    fun `when the database doesnt return anything we have to return null`() = runBlocking {
        //Given
        coEvery { quoteRepository.getAllQuotesFromDatabase() } returns emptyList()

        //When
        val result = getRandomQuotesUseCase()

        //Then
        assert(result == null)
    }

   @Test
   fun `when database is not empty then return quote`() = runBlocking {
       //Given
       val quoteList = listOf(Quote("Que perron testeo", "Brian"))
       coEvery { quoteRepository.getAllQuotesFromDatabase() } returns quoteList

       //When
       val result = getRandomQuotesUseCase()

       //Then
       assert(result == quoteList.first())
   }

}