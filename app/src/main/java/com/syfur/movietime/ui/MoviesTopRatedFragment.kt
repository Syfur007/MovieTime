package com.syfur.movietime.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.syfur.movietime.databinding.FragmentMoviesTopratedBinding
import com.syfur.movietime.utils.MovieAdapter


class MoviesTopRatedFragment : Fragment() {
    private lateinit var binding: FragmentMoviesTopratedBinding
    private lateinit var viewModel: MovieListViewModel
    private lateinit var moviesAdapter: MovieAdapter
    private lateinit var topRatedMoviesRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMoviesTopratedBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[MovieListViewModel::class.java]
        topRatedMoviesRecyclerView = binding.rvTopRatedMovieList
        getTopRatedMovies()

        return binding.root
    }

    private fun getTopRatedMovies() {
        viewModel.fetchTopRatedMovies()
        viewModel.topRatedMovies.observe(viewLifecycleOwner) {
            moviesAdapter = MovieAdapter(it)
            topRatedMoviesRecyclerView.layoutManager =
                GridLayoutManager(requireContext(), 3, RecyclerView.VERTICAL, false)
            topRatedMoviesRecyclerView.adapter = moviesAdapter
        }
    }
}