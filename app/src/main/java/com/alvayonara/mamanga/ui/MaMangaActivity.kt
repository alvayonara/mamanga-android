package com.alvayonara.mamanga.ui

import android.view.LayoutInflater
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.alvayonara.mamanga.R
import com.alvayonara.mamanga.common.base.BaseActivity
import com.alvayonara.mamanga.databinding.ActivityMamangaBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MaMangaActivity : BaseActivity<ActivityMamangaBinding>(),
    BottomNavigationView.OnNavigationItemSelectedListener {

    private var navController: NavController? = null

    override val bindingInflater: (LayoutInflater) -> ActivityMamangaBinding
        get() = ActivityMamangaBinding::inflate

    override fun setup() {
        setupView()
    }

    override fun inject() {}

    override fun setupView() {
        navController = Navigation.findNavController(this, R.id.bottom_nav_view)
        binding.bottomNavView.setOnNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_dashboard -> navController?.navigate(R.id.navigation_dashboard)
            R.id.action_discover -> navController?.navigate(R.id.navigation_discover)
            R.id.action_favorite -> navController?.navigate(R.id.navigation_favorite)
            R.id.action_recent -> navController?.navigate(R.id.navigation_recent)
            R.id.action_more -> navController?.navigate(R.id.navigation_more)
        }
        return true
    }
}