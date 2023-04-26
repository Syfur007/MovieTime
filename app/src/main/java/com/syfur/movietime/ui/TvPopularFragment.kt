package com.syfur.movietime.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.syfur.movietime.databinding.FragmentTvPopularBinding
import com.syfur.movietime.utils.TvAdapter

class TvPopularFragment : Fragment() {
    private lateinit var binding: FragmentTvPopularBinding
    private lateinit var viewModel: TvListViewModel
    private lateinit var tvAdapter: TvAdapter
    private lateinit var popularTvRecyclerView: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTvPopularBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[TvListViewModel::class.java]
        popularTvRecyclerView = binding.rvPopularTvList
        getPopularTvShows()
        return binding.root
    }

    private fun getPopularTvShows() {
        viewModel.fetchPopularTv()
        viewModel.popularTvShows.observe(viewLifecycleOwner) {
            tvAdapter = TvAdapter(it)
            popularTvRecyclerView.layoutManager =
                GridLayoutManager(requireContext(), 3, RecyclerView.VERTICAL, false)
            popularTvRecyclerView.adapter = tvAdapter
        }
    }
}