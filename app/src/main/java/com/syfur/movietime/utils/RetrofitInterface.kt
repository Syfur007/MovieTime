package com.syfur.movietime.utils

import com.syfur.movietime.models.MovieModel
import com.syfur.movietime.responses.MovieResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitInterface {

    // Returns List of Popular Movies
    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String
    ): Response<MovieResponse>

    // Returns List of Currently Trending Movies
    @GET("trending/{movie}/{time_window}")
    suspend fun getTrendingMovies(
        @Path("time_window") time_window: String,
        @Query("api_key") apiKey: String
    ): Response<MovieResponse>

    // Returns List of Movies Relevant to Search Text
    @GET("search/movie")
    suspend fun searchMovie(
        @Query("api_key") apiKey: String,
        @Query("query") searchQuery: String,
        @Query("page") page: Int = 1
    ): Response<MovieResponse>

    // Returns the Movie with Given ID
    @GET("movie/{id}")
    suspend fun getMovie(
        @Path("id") movie_id: Int,
        @Query("api_key") apiKey: String
    ): Response<MovieModel>



    companion object {
        val retrofitApi: RetrofitInterface = Retrofit.Builder()
            .baseUrl(Credentials.baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitInterface::class.java)

    }
}