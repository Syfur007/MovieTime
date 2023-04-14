package com.syfur.movietime

import android.app.Dialog
import android.os.Build
import android.view.WindowInsets
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.navigation.NavigationBarView
import com.syfur.movietime.utils.NavigationAdapter

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
        val viewPager = findViewById<ViewPager2>(R.id.vpMainFrame)
        val pagerAdapter = NavigationAdapter(supportFragmentManager, lifecycle)
        viewPager.adapter = pagerAdapter


        navigationView.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.navMenuHome -> viewPager.currentItem = 0
                R.id.navMenuMovie -> viewPager.currentItem = 1
                R.id.navMenuTV -> viewPager.currentItem = 2
                R.id.navMenuBookmark -> viewPager.currentItem = 3
                R.id.navMenuMore -> viewPager.currentItem = 4
            }
            true
        }


        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                when(position) {
                    0 -> navigationView.selectedItemId = R.id.navMenuHome
                    1 -> navigationView.selectedItemId = R.id.navMenuMovie
                    2 -> navigationView.selectedItemId = R.id.navMenuTV
                    3 -> navigationView.selectedItemId = R.id.navMenuBookmark
                    4 -> navigationView.selectedItemId = R.id.navMenuMore
                }
            }
        })

    }


    private fun changeFragment(container: Int, fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(container, fragment).commit()
    }
}