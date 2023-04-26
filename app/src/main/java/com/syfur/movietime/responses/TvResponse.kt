package com.syfur.movietime.responses

import com.syfur.movietime.models.TvModel

data class TvResponse(
    val page: Int,
    val results: List<TvModel>,
    val total_results: Int,
    val total_pages: Int
)
