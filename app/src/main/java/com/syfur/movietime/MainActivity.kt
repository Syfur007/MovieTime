package com.syfur.movietime

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import com.syfur.movietime.databinding.ActivityMainBinding
import com.syfur.movietime.ui.HomeFragment
import com.syfur.movietime.ui.SearchResultsFragment
import com.syfur.movietime.viewmodels.MainViewModel

class MainActivity : BaseActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        viewModel = MainViewModel()
        setContentView(binding.root)

        changeFragment(R.id.mainFrame, HomeFragment(), "add")

        val toolbar: Toolbar = binding.toolBar
        setSupportActionBar(toolbar)

        val navigationView = binding.bottomNavigation
        navigationManagement(navigationView)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        setupSearchView(menu)
        return true

    }


    private fun setupSearchView(menu: Menu) {
        val searchItem = menu.findItem(R.id.menu_search)
        val searchView = searchItem.actionView as SearchView
        var baseFragment = supportFragmentManager.findFragmentById(R.id.mainFrame)!!
        searchView.queryHint = "Looking for a movie?"
        searchView.setIconifiedByDefault(true)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query != null) {
                    val searchFragment = SearchResultsFragment(query)
                    changeFragment(R.id.mainFrame, searchFragment, "add")
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                val currentFragment = supportFragmentManager.findFragmentById(R.id.mainFrame)!!
                if (currentFragment !is SearchResultsFragment) baseFragment = currentFragment
                changeFragment(R.id.mainFrame, baseFragment)
                return true
            }

        })
    }
}