package com.syfur.movietime

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.syfur.movietime.databinding.ActivityMainBinding
import com.syfur.movietime.viewmodels.MainViewModel

class MainActivity : BaseActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        viewModel = MainViewModel()
        setContentView(binding.root)


        val navigationView = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        navigationManagement(navigationView)

    }
}