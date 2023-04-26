package com.syfur.movietime.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.syfur.movietime.ui.MoviesTopRatedFragment
import com.syfur.movietime.ui.MoviesPopularFragment
import com.syfur.movietime.ui.MoviesTrendingFragment
import com.syfur.movietime.ui.TvPopularFragment
import com.syfur.movietime.ui.TvTopRatedFragment
import com.syfur.movietime.ui.TvTrendingFragment


class MovieTabAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle): FragmentStateAdapter(fragmentManager, lifecycle) {

    private val fragments = listOf(
        MoviesTrendingFragment(),
        MoviesPopularFragment(),
        MoviesTopRatedFragment()
    )

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}


class TvTabAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle): FragmentStateAdapter(fragmentManager, lifecycle) {

    private val fragments = listOf(
        TvTrendingFragment(),
        TvPopularFragment(),
        TvTopRatedFragment()
    )

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}