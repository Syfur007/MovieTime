package com.syfur.movietime.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.syfur.movietime.ui.HomeFragment
import com.syfur.movietime.ui.MenuFragment
import com.syfur.movietime.ui.MovieListFragment
import com.syfur.movietime.ui.TvSeriesFragment
import com.syfur.movietime.ui.WatchlistFragment

class NavigationAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle): FragmentStateAdapter(fragmentManager, lifecycle) {

    private val fragments = listOf(
        HomeFragment(),
        MovieListFragment(),
        TvSeriesFragment(),
        WatchlistFragment(),
        MenuFragment()
    )

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}