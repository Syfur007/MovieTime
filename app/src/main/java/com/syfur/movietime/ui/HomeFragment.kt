package com.syfur.movietime.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.syfur.movietime.BaseFragment
import com.syfur.movietime.R

class HomeFragment : BaseFragment() {

    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

}