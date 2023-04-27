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
import com.syfur.movietime.models.TvModel
import com.syfur.movietime.utils.MediaAdapter

class TvPopularFragment : Fragment() {
    private lateinit var binding: FragmentTvPopularBinding
    private lateinit var viewModel: TvListViewModel
    private lateinit var mediaAdapter: MediaAdapter<TvModel>
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
            mediaAdapter = MediaAdapter(it)
            popularTvRecyclerView.layoutManager =
                GridLayoutManager(requireContext(), 3, RecyclerView.VERTICAL, false)
            popularTvRecyclerView.adapter = mediaAdapter
        }
    }
}