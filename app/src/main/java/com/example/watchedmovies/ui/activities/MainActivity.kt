package com.example.watchedmovies.ui.activities

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.watchedmovies.ui.viewmodels.MovieViewModel
import com.example.watchedmovies.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var movieSearchEditText: EditText
    private lateinit var movieSearchButton: Button

    private lateinit var movieViewModel: MovieViewModel
    private val TAG = "CHECK_RESPONSE"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupBindigs()
        movieViewModel = MovieViewModel()
        listenSearchButton()
    }
    private fun setupBindigs() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        movieSearchEditText = binding.movieSearchEditText
        movieSearchButton = binding.movieSearchButton
    }
    private fun listenSearchButton() {
        movieSearchButton.setOnClickListener{
            val textToSearch = movieSearchEditText.text
            movieViewModel.fetchMovie(textToSearch)
        }
    }
}

//OMDB API KEY