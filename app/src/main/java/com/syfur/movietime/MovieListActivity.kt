package com.syfur.movietime

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.syfur.movietime.databinding.ActivityMovieListBinding
import com.syfur.movietime.viewmodels.MovieListViewModel

class MovieListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMovieListBinding
    private lateinit var viewModel: MovieListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieListBinding.inflate(layoutInflater)
        viewModel = MovieListViewModel()
        setContentView(binding.root)




        binding.btnGetMovies.setOnClickListener {
            val movieId = binding.etSearchMovies.text.toString().toInt()
            viewModel.getMovie(movieId)
            viewModel.data.observe(this) {
                Log.d("Movie", "Name: ${it.title}")
                Log.d("Movie", "Release Date: ${it.release_date}")
                Log.d("Movie", "IMDB: ${it.imdb_id}")
            }
        }




    }
}