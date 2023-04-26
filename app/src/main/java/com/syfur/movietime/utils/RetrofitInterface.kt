package com.syfur.movietime.utils

import com.syfur.movietime.models.MovieModel
import com.syfur.movietime.models.TvModel
import com.syfur.movietime.responses.MovieResponse
import com.syfur.movietime.responses.TvResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitInterface {

    // Movie API Endpoints
    //
    // List of Trending Movies
    @GET("trending/movie/{time_window}")
    suspend fun getTrendingMovies(
        @Path("time_window") time_window: String,
        @Query("api_key") apiKey: String
    ): Response<MovieResponse>

    // List of Popular Movies
    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String
    ): Response<MovieResponse>

    // List of Top-Rated Movies
    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(
        @Query("api_key") apiKey: String
    ): Response<MovieResponse>

    // List of Searched Movies
    @GET("search/movie")
    suspend fun searchMovie(
        @Query("api_key") apiKey: String,
        @Query("query") searchQuery: String,
        @Query("page") page: Int = 1
    ): Response<MovieResponse>

    // Movie with ID
    @GET("movie/{id}")
    suspend fun getMovie(
        @Path("id") movie_id: Int,
        @Query("api_key") apiKey: String
    ): Response<MovieModel>



    // TV Show API Endpoints
    //
    // List of Trending TV Shows
    @GET("trending/tv/{time_window}")
    suspend fun getTrendingTVShow(
        @Path("time_window") time_window: String,
        @Query("api_key") apiKey: String
    ): Response<TvResponse>

    // List of Popular TV Shows
    @GET("tv/popular")
    suspend fun getPopularTVShow(
        @Query("api_key") apiKey: String
    ): Response<TvResponse>

    // List of Top-Rated TV Shows
    @GET("tv/top_rated")
    suspend fun getTopRatedTVShow(
        @Query("api_key") apiKey: String
    ): Response<TvResponse>

    // List of Searched TV Shows
    @GET("search/tv")
    suspend fun searchTVShow(
        @Query("api_key") apiKey: String,
        @Query("query") searchQuery: String,
        @Query("page") page: Int = 1
    ): Response<TvResponse>

    // TV Show with ID
    @GET("tv/{id}")
    suspend fun getTVShow(
        @Path("id") movie_id: Int,
        @Query("api_key") apiKey: String
    ): Response<TvModel>



    companion object {
        val retrofitApi: RetrofitInterface = Retrofit.Builder()
            .baseUrl(Credentials.baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitInterface::class.java)

    }
}