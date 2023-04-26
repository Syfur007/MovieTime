package com.syfur.movietime.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.syfur.movietime.databinding.FragmentTvTopRatedBinding
import com.syfur.movietime.utils.TvAdapter


class TvTopRatedFragment : Fragment() {
    private lateinit var binding: FragmentTvTopRatedBinding
    private lateinit var viewModel: TvListViewModel
    private lateinit var tvAdapter: TvAdapter
    private lateinit var topRatedTvRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTvTopRatedBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[TvListViewModel::class.java]
        topRatedTvRecyclerView = binding.rvTopRatedTvList
        topRatedTvShows()
        return binding.root
    }

    private fun topRatedTvShows() {
        viewModel.fetchTopRatedTv()
        viewModel.topRatedTvShows.observe(viewLifecycleOwner) {
            tvAdapter = TvAdapter(it)
            topRatedTvRecyclerView.layoutManager =
                GridLayoutManager(requireContext(), 3, RecyclerView.VERTICAL, false)
            topRatedTvRecyclerView.adapter = tvAdapter
        }
    }
}