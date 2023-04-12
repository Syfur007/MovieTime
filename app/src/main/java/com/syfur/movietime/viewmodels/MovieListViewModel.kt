package com.syfur.movietime.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.syfur.movietime.models.MovieModel
import com.syfur.movietime.utils.Credentials
import com.syfur.movietime.utils.RetrofitInterface
import kotlinx.coroutines.launch

class MovieListViewModel: ViewModel() {
    private var _data = MutableLiveData<MovieModel>()
    val data: LiveData<MovieModel> get() = _data

    fun getMovie(movieId: Int) {

        viewModelScope.launch {
            val response = RetrofitInterface.retrofitApi.getMovie(movieId, Credentials.apiKey)
            if (response.isSuccessful) {
                _data.value = response.body()
            }
        }
    }
}