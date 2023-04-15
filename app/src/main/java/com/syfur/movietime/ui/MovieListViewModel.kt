package com.syfur.movietime.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.syfur.movietime.models.MovieModel
import com.syfur.movietime.utils.Repository
import kotlinx.coroutines.launch

class MovieListViewModel : ViewModel() {
    val movies = MutableLiveData<List<MovieModel>>()


    fun fetchMovies() {
        viewModelScope.launch {
            movies.value = Repository().popularMovies().results
        }
    }
}