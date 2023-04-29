package com.syfur.movietime.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.syfur.movietime.BaseFragment
import com.syfur.movietime.MovieActivity
import com.syfur.movietime.databinding.FragmentSearchResultsBinding
import com.syfur.movietime.models.MovieModel
import com.syfur.movietime.utils.MediaAdapter
import com.syfur.movietime.viewmodels.MainViewModel


class SearchResultsFragment(private val query: String) : BaseFragment(), MediaAdapter.OnItemClickListener<MovieModel> {
    private lateinit var binding: FragmentSearchResultsBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MediaAdapter<MovieModel>


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSearchResultsBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        recyclerView = binding.rvSearch
        search()
        return binding.root
    }



    override fun onItemClick(media: MovieModel) {
        val intent = Intent(requireContext(), MovieActivity::class.java)
        intent.putExtra("movie", media)
        startActivity(intent)

    }


    private fun search() {
        viewModel.searchMovie(query)
        viewModel.searchMovie.observe(viewLifecycleOwner) {
            adapter = MediaAdapter(it, listener = this)
            recyclerView.layoutManager = GridLayoutManager(requireContext(), 3, RecyclerView.VERTICAL, false)
            recyclerView.adapter = adapter
        }
    }
}
