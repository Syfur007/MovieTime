package com.syfur.movietime.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.syfur.movietime.models.TvModel
import com.syfur.movietime.utils.Repository
import kotlinx.coroutines.launch

class TvListViewModel : ViewModel() {
    val trendingTvShows = MutableLiveData<List<TvModel>>()
    val popularTvShows = MutableLiveData<List<TvModel>>()
    val topRatedTvShows = MutableLiveData<List<TvModel>>()

    fun fetchTrendingTv() {
        viewModelScope.launch {
            trendingTvShows.value = Repository().fetchTVShows("trending").results
        }
    }

    fun fetchPopularTv() {
        viewModelScope.launch {
            popularTvShows.value = Repository().fetchTVShows("popular").results
        }
    }

    fun fetchTopRatedTv() {
        viewModelScope.launch {
            topRatedTvShows.value = Repository().fetchTVShows("top_rated").results
        }
    }
}