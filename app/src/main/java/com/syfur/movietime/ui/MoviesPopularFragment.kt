package com.syfur.movietime.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.syfur.movietime.databinding.FragmentMoviesPopularBinding
import com.syfur.movietime.utils.MovieTvAdapter

class MoviesPopularFragment : Fragment() {
    private lateinit var binding: FragmentMoviesPopularBinding
    private lateinit var viewModel: MovieListViewModel
    private lateinit var moviesAdapter: MovieTvAdapter
    private lateinit var popularMoviesRecyclerView: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMoviesPopularBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[MovieListViewModel::class.java]
        popularMoviesRecyclerView = binding.rvPopularMovieList
        getPopularMovies()

        return binding.root
    }


    private fun getPopularMovies() {
        viewModel.fetchPopularMovies()
        viewModel.popularMovies.observe(viewLifecycleOwner) {
            moviesAdapter = MovieTvAdapter(it)
            popularMoviesRecyclerView.layoutManager =
                GridLayoutManager(requireContext(), 3, RecyclerView.VERTICAL, false)
            popularMoviesRecyclerView.adapter = moviesAdapter
        }
    }
}