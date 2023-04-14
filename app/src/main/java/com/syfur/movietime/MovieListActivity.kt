package com.syfur.movietime

import android.os.Bundle
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


    }
}