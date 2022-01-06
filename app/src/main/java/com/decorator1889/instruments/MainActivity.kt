package com.decorator1889.instruments

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.findNavController
import com.decorator1889.instruments.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener  {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_Instruments)
        super.onCreate(savedInstanceState)
        installSplashScreen()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bottomNavigationView.itemIconTintList = null
        binding.bottomNavigationView.setOnItemSelectedListener(this)
        getStatusBarMarginTop()
    }

    private fun getStatusBarMarginTop() {
        val param = binding.frameLayoutContainer.layoutParams as ViewGroup.MarginLayoutParams
        param.setMargins(0, getStatusBarHeight(), 0, 0)
        binding.frameLayoutContainer.layoutParams = param
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        binding.bottomNavigationView.menu.getItem(0).setIcon(R.drawable.ic_home_inactive)
        binding.bottomNavigationView.menu.getItem(1).setIcon(R.drawable.ic_test_inactive)
        binding.bottomNavigationView.menu.getItem(2).setIcon(R.drawable.ic_favorite_inactive)
        binding.bottomNavigationView.menu.getItem(3).setIcon(R.drawable.ic_profile_inactive)
        when(item.itemId) {
            R.id.home -> {
                item.setIcon(R.drawable.ic_home_active)
                return true
            }
            R.id.test -> {
                item.setIcon(R.drawable.ic_test_active)
                return true
            }
            R.id.favorite -> {
                item.setIcon(R.drawable.ic_favorite_active)
                return true
            }
            R.id.profile -> {
                item.setIcon(R.drawable.ic_profile_active)
                return true
            }
        }
        return false
    }

    private fun getStatusBarHeight(): Int {
        val height: Int
        val resources: Resources = resources
        val idStatusBarHeight: Int =
            resources.getIdentifier("status_bar_height", "dimen", "android")
        if (idStatusBarHeight > 0) {
            height = resources.getDimensionPixelSize(idStatusBarHeight)
        } else {
            height = resources.getDimensionPixelSize(R.dimen.statusBarHeight)
        }
        return height
    }
}