package com.syfur.movietime.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.syfur.movietime.BaseFragment
import com.syfur.movietime.databinding.FragmentMovieListBinding
import com.syfur.movietime.utils.MovieTabAdapter

class MovieListFragment : BaseFragment() {
    private lateinit var binding: FragmentMovieListBinding
    private lateinit var viewModel: MovieListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentMovieListBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[MovieListViewModel::class.java]
        addTabLayout()
        return binding.root
    }


    private fun addTabLayout() {
        val tabLayout = binding.tlMovieList
        val viewPager = binding.vpMovieList
        val tabNames = listOf("Trending", "Popular", "Top Rated")
        viewPager.adapter = MovieTabAdapter(childFragmentManager, lifecycle)
        tabLayoutFunctionality(tabNames, tabLayout, viewPager)
    }

}