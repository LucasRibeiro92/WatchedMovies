package com.example.watchedmovies.data.remote.omdbImg

import android.text.Editable
import com.example.watchedmovies.data.model.Movie
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface OmbdImgService {

    @GET("/")
    fun getMovieImage(
        @Query("apikey") apiKey: String,
        @Query("i") id: Editable
    ): Call<Movie>

}