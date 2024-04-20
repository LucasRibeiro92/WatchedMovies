package com.example.watchedmovies.ui.activities

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.watchedmovies.data.model.Movie
import com.example.watchedmovies.data.remote.omdb.OmdbClient
import com.example.watchedmovies.data.remote.omdb.OmdbClient.Companion.API_KEY
import com.example.watchedmovies.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var movieSearchEditText: EditText
    private lateinit var movieSearchButton: Button

    private lateinit var omdbClient: OmdbClient
    private val TAG = "CHECK_RESPONSE"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupBindigs()
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
            val omdbClient = OmdbClient.create()

            omdbClient.getMovie(apiKey = API_KEY, textToSearch)
                .enqueue(object : Callback<Movie>{
                    override fun onResponse(
                        p0: Call<Movie>,
                        p1: Response<Movie>
                    )
                    {
                        if (p1.isSuccessful)
                        {
                            val movieResponse = p1.body()
                            movieResponse?.let {
                                Log.d(TAG, "${p1.body()}")
                            }
                        }
                    }
                    override fun onFailure(p0: Call<Movie>, p1: Throwable) {
                        Log.d(TAG, "${p1.message}")
                    }
                })
        }
    }
}

//OMDB API KEY