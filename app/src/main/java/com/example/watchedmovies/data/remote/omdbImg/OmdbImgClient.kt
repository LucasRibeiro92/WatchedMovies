package com.example.watchedmovies.data.remote.omdbImg

import com.example.watchedmovies.data.remote.omdb.OmdbService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class OmdbImgClient {
    companion object {
        private const val BASE_URL = "http:/img.omdbapi.com/"

        fun create(): OmbdImgService {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(OmbdImgService::class.java)
        }
    }
}