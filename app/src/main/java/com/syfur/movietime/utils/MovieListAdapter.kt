package com.syfur.movietime.utils

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.progressindicator.CircularProgressIndicator
import com.squareup.picasso.Picasso
import com.syfur.movietime.R
import com.syfur.movietime.models.MovieModel

class MovieListAdapter(
    private val movieList: List<MovieModel>, private val itemCount: Int = movieList.size
) : RecyclerView.Adapter<MovieListAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val poster: ImageView = view.findViewById(R.id.ivPoster)
        val title: TextView = view.findViewById(R.id.tvTitle)
        val rating: TextView = view.findViewById(R.id.tvRating)
        val ratingIndicator: CircularProgressIndicator = view.findViewById(R.id.ratingIndicator)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemCount
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val posterPath = movieList[position].poster_path
        if (posterPath != null) {
            val url = "https://image.tmdb.org/t/p/w500${posterPath}"
            Picasso.get().load(url).into(holder.poster)
        }
        val rating = movieList[position].vote_average.times(10)
        holder.rating.text = rating.toInt().toString()
        holder.ratingIndicator.progress = rating.toInt()
        holder.ratingIndicator.setIndicatorColor(ratingIndicatorColor(rating)[0])
        holder.ratingIndicator.trackColor = ratingIndicatorColor(rating)[1]
        holder.title.text = movieList[position].title
    }

    private fun ratingIndicatorColor(rating: Double): List<Int> {
        return if (rating >= 70) listOf(Color.argb(255, 0, 255, 0), Color.argb(50, 0, 255, 0))
        else if (rating >= 50) listOf(Color.argb(255, 255, 255, 0), Color.argb(50, 255, 255, 0))
        else listOf(Color.argb(255, 255, 0, 0), Color.argb(50, 255, 0, 0))

    }
}