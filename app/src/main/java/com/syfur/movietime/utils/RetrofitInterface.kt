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

    // Returns Currently Popular Movies
    @GET("movie/popular")
    fun getPopular(
        @Query("api_key") apiKey: String
    ): Response<MovieResponse>

    // Returns Movies Containing Search Text
    @GET("search/movie")
    fun searchMovie(
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