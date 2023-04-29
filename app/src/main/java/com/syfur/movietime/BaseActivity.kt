package com.syfur.movietime

import android.app.Dialog
import android.os.Build
import android.view.WindowInsets
import android.view.WindowManager
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
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            @Suppress("DEPRECATION")
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

        navigationView.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.navMenuHome -> changeFragment(R.id.mainFrame, HomeFragment())
                R.id.navMenuMovie -> changeFragment(R.id.mainFrame, MovieListFragment())
                R.id.navMenuTV -> changeFragment(R.id.mainFrame, TvListFragment())
                R.id.navMenuBookmark -> changeFragment(R.id.mainFrame, WatchlistFragment())
                R.id.navMenuMore -> changeFragment(R.id.mainFrame, MenuFragment())
            }
            true
        }

    }


    fun changeFragment(container: Int = R.id.mainFrame, fragment: Fragment, action: String = "replace") {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        when (action) {
            "add" -> fragmentTransaction.add(container, fragment)
            "remove" -> fragmentTransaction.remove(fragment)
            else -> fragmentTransaction.replace(container, fragment)
        }
        fragmentTransaction.commit()
    }
}