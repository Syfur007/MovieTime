package com.syfur.movietime.utils

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface RetrofitInterface {



    companion object {
        val retrofitApi: RetrofitInterface = Retrofit.Builder()
            .baseUrl(Credentials.baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitInterface::class.java)

    }
}