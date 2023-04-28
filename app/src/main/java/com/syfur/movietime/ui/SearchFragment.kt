package com.syfur.movietime.ui

import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.syfur.movietime.MovieActivity
import com.syfur.movietime.databinding.FragmentSearchBinding
import com.syfur.movietime.models.MovieModel
import com.syfur.movietime.utils.MediaAdapter
import com.syfur.movietime.viewmodels.MainViewModel


class SearchFragment(private val query: String) : BottomSheetDialogFragment(), MediaAdapter.OnItemClickListener<MovieModel> {
    private lateinit var binding: FragmentSearchBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MediaAdapter<MovieModel>


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        recyclerView = binding.rvSearch
        search()
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dialog?.setOnShowListener {
            val bottomSheetDialog = it as BottomSheetDialog
            setupFullHeight(bottomSheetDialog)
        }
    }


    private fun setupFullHeight(bottomSheetDialog: BottomSheetDialog) {
        val behavior = BottomSheetBehavior.from(bottomSheetDialog.findViewById(com.google.android.material.R.id.design_bottom_sheet)!!)
        val layoutParams = behavior.peekHeight
        val windowHeight = Resources.getSystem().displayMetrics.heightPixels
        val newHeight = windowHeight - layoutParams
        behavior.peekHeight = newHeight
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
