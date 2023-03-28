package com.syfur.movietime.responses

import com.syfur.movietime.models.MovieModel

data class MoviePopularResponse(
    val page: Int,
    val results: List<MovieModel>,
    val total_results: Int,
    val total_pages: Int
)
