package com.syfur.movietime.utils

import com.syfur.movietime.models.MovieModel
import com.syfur.movietime.responses.MoviePopularResponse
import com.syfur.movietime.responses.MovieSearchResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitInterface {

    @GET("movie/popular")
    fun getPopular(@Query("api_key") apiKey: String): Call<MoviePopularResponse>

    @GET("search/movie")
    fun searchMovie(
        @Query("api_key") apiKey: String,
        @Query("query") searchQuery: String,
        @Query("page") page: Int = 1
    ): Call<MoviePopularResponse>

    @GET("movie/{id}")
    fun getMovie(
        @Path("id") movie_id: Int,
        @Query("api_key") apiKey: String
    ): Call<MovieModel>



    companion object {
        val retrofitApi: RetrofitInterface = Retrofit.Builder()
            .baseUrl(Credentials.baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitInterface::class.java)

    }
}