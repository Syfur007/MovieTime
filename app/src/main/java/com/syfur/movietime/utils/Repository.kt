package com.syfur.movietime.utils

import com.syfur.movietime.responses.MovieResponse
import com.syfur.movietime.responses.TvResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException

class Repository {


    suspend fun trendingMovies(time_window: String = "week"): MovieResponse {
        val response = withContext(Dispatchers.IO) {
            RetrofitInterface.retrofitApi.getTrendingMovies(time_window, Credentials.apiKey)
        }
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            throw IOException("Unable to Fetch Trending Movies")
        }
    }


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


    suspend fun topRatedMovies(): MovieResponse {
        val response = withContext(Dispatchers.IO) {
            RetrofitInterface.retrofitApi.getTopRatedMovies(Credentials.apiKey)
        }
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            throw IOException("Unable to Fetch Trending Movies")
        }
    }


    suspend fun trendingTVShows(time_window: String = "week"): TvResponse {
        val response = withContext(Dispatchers.IO) {
            RetrofitInterface.retrofitApi.getTrendingTVShow(time_window, Credentials.apiKey)
        }
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            throw IOException("Unable to Fetch Trending Movies")
        }
    }


    suspend fun popularTVShows(): TvResponse {
        val response = withContext(Dispatchers.IO) {
            RetrofitInterface.retrofitApi.getPopularTVShow(Credentials.apiKey)
        }
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            throw IOException("Unable to Fetch Popular Movies")
        }
    }


    suspend fun topRatedTVShows(): TvResponse {
        val response = withContext(Dispatchers.IO) {
            RetrofitInterface.retrofitApi.getTopRatedTVShow(Credentials.apiKey)
        }
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            throw IOException("Unable to Fetch Trending Movies")
        }
    }
}