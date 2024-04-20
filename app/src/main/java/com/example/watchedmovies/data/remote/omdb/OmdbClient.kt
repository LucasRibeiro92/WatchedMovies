package com.example.watchedmovies.data.remote.omdb

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class OmdbClient {
    companion object {
        private const val BASE_URL = "http://www.omdbapi.com/"
        const val API_KEY = "844beff4"

        fun create(): OmdbService {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(OmdbService::class.java)
        }
    }
}