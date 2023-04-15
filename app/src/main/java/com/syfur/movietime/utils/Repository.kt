package com.syfur.movietime.utils

import com.syfur.movietime.responses.MovieResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException

class Repository {
    suspend fun popularMovies(): MovieResponse {
        val response = withContext(Dispatchers.IO) {
            RetrofitInterface.retrofitApi.getPopularMovies(Credentials.apiKey)
        }
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            throw IOException("Unable to Fetch Popular Movies")
        }
    }


    suspend fun trendingMovies(time_window: String): MovieResponse {
        val response = withContext(Dispatchers.IO) {
            RetrofitInterface.retrofitApi.getTrendingMovies(time_window, Credentials.apiKey)
        }
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            throw IOException("Unable to Fetch Popular Movies")
        }
    }
}