package com.syfur.movietime.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.syfur.movietime.models.MovieModel
import com.syfur.movietime.utils.Repository
import kotlinx.coroutines.launch

class MovieListViewModel : ViewModel() {
    val topRatedMovies = MutableLiveData<List<MovieModel>>()
    val trendingMovies = MutableLiveData<List<MovieModel>>()
    val popularMovies = MutableLiveData<List<MovieModel>>()

    fun fetchTopRatedMovies() {
        viewModelScope.launch {
            topRatedMovies.value = Repository().fetchMovies("top_rated").results
        }
    }

    fun fetchTrendingMovies() {
        viewModelScope.launch {
            trendingMovies.value = Repository().fetchMovies("trending").results
        }
    }

    fun fetchPopularMovies() {
        viewModelScope.launch {
            popularMovies.value = Repository().fetchMovies("popular").results
        }
    }
}