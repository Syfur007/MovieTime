package com.syfur.movietime.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.syfur.movietime.R

class TvSeriesFragment : Fragment() {

    private lateinit var viewModel: TvSeriesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this)[TvSeriesViewModel::class.java]
        return inflater.inflate(R.layout.fragment_tv_series, container, false)
    }

}