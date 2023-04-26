package com.syfur.movietime

import android.app.Dialog
import android.os.Build
import android.view.WindowInsets
import android.view.WindowManager
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationBarView
import com.syfur.movietime.ui.HomeFragment
import com.syfur.movietime.ui.MenuFragment
import com.syfur.movietime.ui.MovieListFragment
import com.syfur.movietime.ui.TvListFragment
import com.syfur.movietime.ui.WatchlistFragment

open class BaseActivity : AppCompatActivity() {
    private lateinit var progressDialog: Dialog


    fun fullScreen() {
        @Suppress("DEPRECATION")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
    }


    fun showProgressDialog () {
        progressDialog = Dialog(this)
        progressDialog.setContentView(R.layout.dialog_progress)
        progressDialog.show()
    }


    fun hideProgressDialog() {
        progressDialog.dismiss()
    }


    fun navigationManagement(navigationView: NavigationBarView) {
        val frameLayout = findViewById<FrameLayout>(R.id.flMainFrame)


        navigationView.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.navMenuHome -> changeFragment(R.id.flMainFrame, HomeFragment())
                R.id.navMenuMovie -> changeFragment(R.id.flMainFrame, MovieListFragment())
                R.id.navMenuTV -> changeFragment(R.id.flMainFrame, TvListFragment())
                R.id.navMenuBookmark -> changeFragment(R.id.flMainFrame, WatchlistFragment())
                R.id.navMenuMore -> changeFragment(R.id.flMainFrame, MenuFragment())
            }
            true
        }

    }


    private fun changeFragment(container: Int, fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(container, fragment).commit()
    }
}