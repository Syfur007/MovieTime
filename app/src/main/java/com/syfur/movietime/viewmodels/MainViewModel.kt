package com.syfur.movietime.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.syfur.movietime.models.MovieModel
import com.syfur.movietime.utils.Credentials
import com.syfur.movietime.utils.Repository
import com.syfur.movietime.utils.RetrofitInterface
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    val movie = MutableLiveData<MovieModel>()
    val searchMovie = MutableLiveData<List<MovieModel>>()

    fun getMovie(movieId: Int) {

        viewModelScope.launch {
            val response = RetrofitInterface.retrofitApi.getMovie(movieId, Credentials.apiKey)
            if (response.isSuccessful) {
                movie.value = response.body()
            }
        }
    }

    fun searchMovie(movieName: String) {
        viewModelScope.launch {
            searchMovie.value = Repository().searchEntity( movieName).results
        }
    }
}