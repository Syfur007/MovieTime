package com.syfur.movietime.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.syfur.movietime.databinding.FragmentMovieListBinding
import com.syfur.movietime.utils.MovieListAdapter

class MovieListFragment : Fragment() {
    private lateinit var binding: FragmentMovieListBinding
    private lateinit var viewModel: MovieListViewModel
    private lateinit var moviesAdapter: MovieListAdapter
    private lateinit var moviesRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMovieListBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[MovieListViewModel::class.java]
        moviesRecyclerView = binding.rvMovieList
        getMovies()
        return binding.root
    }

    private fun getMovies() {
        viewModel.fetchMovies()
        viewModel.movies.observe(viewLifecycleOwner) {
            moviesAdapter = MovieListAdapter(it)
            moviesRecyclerView.layoutManager = GridLayoutManager(requireContext(), 3, RecyclerView.VERTICAL, false)
            moviesRecyclerView.adapter = moviesAdapter
        }
    }

}