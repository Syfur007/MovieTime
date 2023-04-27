package com.syfur.movietime.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.syfur.movietime.databinding.FragmentTvTrendingBinding
import com.syfur.movietime.models.TvModel
import com.syfur.movietime.utils.MediaAdapter

class TvTrendingFragment : Fragment() {
    private lateinit var binding: FragmentTvTrendingBinding
    private lateinit var viewModel: TvListViewModel
    private lateinit var mediaAdapter: MediaAdapter<TvModel>
    private lateinit var trendingTvRecyclerView: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTvTrendingBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[TvListViewModel::class.java]
        trendingTvRecyclerView = binding.rvTrendingTvList
        trendingTvShows()
        return binding.root
    }

    private fun trendingTvShows() {
        viewModel.fetchTrendingTv()
        viewModel.trendingTvShows.observe(viewLifecycleOwner) {
            mediaAdapter = MediaAdapter(it)
            trendingTvRecyclerView.layoutManager =
                GridLayoutManager(requireContext(), 3, RecyclerView.VERTICAL, false)
            trendingTvRecyclerView.adapter = mediaAdapter
        }
    }
}