package com.example.watchedmovies.data.remote.omdb

import android.text.Editable
import com.example.watchedmovies.data.model.Movie
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface OmdbService {

    @GET("/")
    fun getMovie(
        @Query("apikey") apiKey: String,
        @Query("t") title: Editable
    ): Call<Movie>

}