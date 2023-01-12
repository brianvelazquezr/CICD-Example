package com.example.advancedappmovies.ui.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.advancedappmovies.domain.GetQuotesUseCase
import com.example.advancedappmovies.domain.GetRandomQuotesUseCase
import com.example.advancedappmovies.domain.model.Quote
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
internal class QuoteViewModelTest {

    @RelaxedMockK
    private lateinit var getQuotesUseCase: GetQuotesUseCase

    @RelaxedMockK
    private lateinit var getRandomQuotesUseCase: GetRandomQuotesUseCase

    private lateinit var quoteViewModel: QuoteViewModel

    @get:Rule
    var rule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        quoteViewModel = QuoteViewModel(getQuotesUseCase, getRandomQuotesUseCase)
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @After
    fun onAfter(){
        Dispatchers.resetMain()
    }

   @Test
   fun `when viewmodel is created at the first time, get all quotes and set first value`() = runTest {
       //Given
       val quoteList = listOf(Quote("1", "Brian"), Quote("2", "Brian"))
       coEvery { getQuotesUseCase() } returns quoteList

       //When
       quoteViewModel.onCreate()

       //Then
       assert(quoteViewModel.quoteModel.value == quoteList.first())

   }

    @Test
    fun `when getRandom be called the function will return a value`() = runTest {
        //Given
        val quote = Quote("El rey del testing", "Brian ")
        coEvery { getRandomQuotesUseCase() } returns quote

        //When
        quoteViewModel.randomQuote()

        //Then
        assert(quoteViewModel.quoteModel.value == quote)
    }

    @Test
    fun `when getRandom be called the function will return a null`() = runTest {
        //Given
        val quote = Quote("El rey del testing", "Brian ")
        quoteViewModel.quoteModel.postValue(quote)
        coEvery { getRandomQuotesUseCase() } returns null

        //When
        quoteViewModel.randomQuote()

        //Then
        assert(quoteViewModel.quoteModel.value == quote)
    }

}