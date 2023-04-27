package com.syfur.movietime.utils

import com.syfur.movietime.responses.MovieResponse
import com.syfur.movietime.responses.TvResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException

class Repository {


    suspend fun fetchMovies(movieType: String, timeWindow: String = "week"): MovieResponse {
        val response = withContext(Dispatchers.IO) {
            when (movieType) {
                "trending" -> RetrofitInterface.retrofitApi.getTrendingMovies(timeWindow, Credentials.apiKey)
                "popular" -> RetrofitInterface.retrofitApi.getPopularMovies(Credentials.apiKey)
                "top_rated" -> RetrofitInterface.retrofitApi.getTopRatedMovies(Credentials.apiKey)
                else -> throw IllegalArgumentException("Invalid movie type: $movieType")
            }
        }
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            throw IOException("Unable to fetch $movieType movies")
        }
    }


    suspend fun fetchTVShows(tvShowType: String, timeWindow: String = "week"): TvResponse {
        val response = withContext(Dispatchers.IO) {
            when (tvShowType) {
                "trending" -> RetrofitInterface.retrofitApi.getTrendingTVShow(timeWindow, Credentials.apiKey)
                "popular" -> RetrofitInterface.retrofitApi.getPopularTVShow(Credentials.apiKey)
                "top_rated" -> RetrofitInterface.retrofitApi.getTopRatedTVShow(Credentials.apiKey)
                else -> throw IllegalArgumentException("Invalid TV show type: $tvShowType")
            }
        }
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            throw IOException("Unable to fetch $tvShowType TV shows")
        }
    }


    suspend fun searchEntity(entityName: String): MovieResponse {
        val response = withContext(Dispatchers.IO) {
            RetrofitInterface.retrofitApi.searchMovie(Credentials.apiKey, entityName)
        }
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            throw IOException("Unable to fetch search $entityName")
        }

    }
}