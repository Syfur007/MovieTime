package com.syfur.movietime

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.syfur.movietime.models.MovieModel
import com.syfur.movietime.utils.Credentials
import com.syfur.movietime.utils.RetrofitInterface
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        findViewById<Button>(R.id.btnGetMovies).setOnClickListener {
            val searchText = findViewById<TextInputEditText>(R.id.etSearchMovies).text.toString()
            Log.d("PopularMovies", searchText)
            RetrofitInterface.retrofitApi.getMovie(550, Credentials.apiKey).enqueue(object: Callback<MovieModel> {
                override fun onResponse(
                    call: retrofit2.Call<MovieModel>,
                    response: Response<MovieModel>
                ) {
                    val movies = response.body()
                    Log.d("PopularMovies", movies?.title ?: "Not found")
                    Log.d("PopularMovies", movies?.release_date ?: "Not found")
                }

                override fun onFailure(call: retrofit2.Call<MovieModel>, t: Throwable) {
                    Log.e("PopularMovies", t.toString())
                }

            })
        }
    }
}