package com.syfur.movietime.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.syfur.movietime.BaseFragment
import com.syfur.movietime.databinding.FragmentTvListBinding
import com.syfur.movietime.utils.TvTabAdapter

class TvListFragment : BaseFragment() {
    private lateinit var binding: FragmentTvListBinding
    private lateinit var viewModel: TvListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTvListBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[TvListViewModel::class.java]
        tvTabs()
        return binding.root
    }

    private fun tvTabs() {
        val tabLayout = binding.tlTvList
        val viewPager = binding.vpTvList
        val tabNames = listOf("Trending", "Popular", "Top Rated")
        viewPager.adapter = TvTabAdapter(childFragmentManager, lifecycle)
        tabLayoutFunctionality(tabNames, tabLayout, viewPager)
    }





}