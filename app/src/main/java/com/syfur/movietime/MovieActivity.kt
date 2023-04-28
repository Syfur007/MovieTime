package com.syfur.movietime

import android.graphics.Color
import android.os.Bundle
import android.view.View
import com.squareup.picasso.Picasso
import com.syfur.movietime.databinding.ActivityMovieBinding
import com.syfur.movietime.models.MovieModel
import com.syfur.movietime.utils.Credentials

@Suppress("DEPRECATION")
class MovieActivity : BaseActivity() {
    private lateinit var binding: ActivityMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val movie = intent.getParcelableExtra("movie") as? MovieModel


        val title = binding.tvTitle
        val year = binding.tvYear
        val poster = binding.posterImage
        val backdrop = binding.backdropImage

        if (movie != null) {
            title.text = movie.title

            if (movie.release_date != null) year.text = movie.release_date.subSequence(0, 4)
            else year.visibility = View.INVISIBLE

            if (movie.backdrop_path != null) {
                val url = Credentials.posterUrl + movie.backdrop_path
                Picasso.get().load(url).into(backdrop)
            }

            if (movie.poster_path != null) {
                val url = Credentials.posterUrl + movie.poster_path
                Picasso.get().load(url).into(poster)
            }

            val rating = movie.vote_average.times(10)
            binding.tvRating.text = rating.toInt().toString()
            binding.ratingIndicator.progress = rating.toInt()
            binding.ratingIndicator.setIndicatorColor(ratingIndicatorColor(rating)[0])
            binding.ratingIndicator.trackColor = ratingIndicatorColor(rating)[1]

        }
    }


    private fun ratingIndicatorColor(rating: Double): List<Int> {
        return if (rating >= 70) listOf(Color.argb(255, 0, 255, 0), Color.argb(50, 0, 255, 0))
        else if (rating >= 50) listOf(Color.argb(255, 255, 255, 0), Color.argb(50, 255, 255, 0))
        else listOf(Color.argb(255, 255, 0, 0), Color.argb(50, 255, 0, 0))
    }
}