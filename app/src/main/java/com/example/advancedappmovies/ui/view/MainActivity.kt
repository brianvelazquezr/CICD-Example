package com.example.advancedappmovies.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.example.advancedappmovies.databinding.ActivityMainBinding
import com.example.advancedappmovies.ui.viewmodel.QuoteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    private val quoteViewModel : QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        quoteViewModel.onCreate()

        quoteViewModel.quoteModel.observe(this, Observer { currentQuote ->
            binding.tvQuote.text = currentQuote.quote
            binding.tvAutor.text = currentQuote.author
        })

        quoteViewModel.isLoading.observe(this, Observer { isLoading ->
            binding.progressBar.isVisible = isLoading
        })

        binding.viewContainer.setOnClickListener {
            quoteViewModel.randomQuote()
        }

    }
}


/* This info is not longer util, was for other project but it can be util in a future
 * Info for Moview Api
 *
 * API Key v3 auth
 * 7c94ea642063a53587d2e8169e3ed0ad
 *
 * Example Api request
 * https://api.themoviedb.org/3/movie/550?api_key=7c94ea642063a53587d2e8169e3ed0ad
 *
 * API Read Access Token (v4 auth)
 * eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI3Yzk0ZWE2NDIwNjNhNTM1ODdkMmU4MTY5ZTNlZDBhZCIsInN1YiI6IjYzODkzZWFmNmI1ZmMyMDA4NTk3M2Y1MiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.OGJvg-h4H1bfFM8HinwT5fJPmsaMnKlnOD5jTSovXhQ
 *
 * to get just popular movies
 * https://api.themoviedb.org/3/movie/popular?api_key=7c94ea642063a53587d2e8169e3ed0ad
 * */