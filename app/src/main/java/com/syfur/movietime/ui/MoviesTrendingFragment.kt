package com.syfur.movietime.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.syfur.movietime.MovieActivity
import com.syfur.movietime.databinding.FragmentMoviesTrendingBinding
import com.syfur.movietime.models.MovieModel
import com.syfur.movietime.utils.MediaAdapter

class MoviesTrendingFragment : Fragment(), MediaAdapter.OnItemClickListener<MovieModel> {
    private lateinit var binding: FragmentMoviesTrendingBinding
    private lateinit var viewModel: MovieListViewModel
    private lateinit var moviesAdapter: MediaAdapter<MovieModel>
    private lateinit var trendingMoviesRecyclerView: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMoviesTrendingBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[MovieListViewModel::class.java]
        trendingMoviesRecyclerView = binding.rvTrendingMovieList
        getTrendingMovies()
        return binding.root
    }

    override fun onItemClick(media: MovieModel) {
        val intent = Intent(requireContext(), MovieActivity::class.java)
        intent.putExtra("movie", media)
        startActivity(intent)

    }


    private fun getTrendingMovies() {
        viewModel.fetchTrendingMovies()
        viewModel.trendingMovies.observe(viewLifecycleOwner) {
            moviesAdapter = MediaAdapter(it, listener = this)
            trendingMoviesRecyclerView.layoutManager =
                GridLayoutManager(requireContext(), 3, RecyclerView.VERTICAL, false)
            trendingMoviesRecyclerView.adapter = moviesAdapter
        }
    }
}