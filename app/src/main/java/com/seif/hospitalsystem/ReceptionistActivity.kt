package com.seif.hospitalsystem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import androidx.appcompat.widget.Toolbar
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController

class ReceptionistActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupNavigation()

    }
    private fun setupNavigation() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
        val navController = navHostFragment.navController
       // val appBarConfiguration = AppBarConfiguration.Builder(navController.graph).build()
    }
    override fun onBackPressed() {
        val navigationController = findNavController(R.id.nav_host)
        if (navigationController.currentDestination?.id == R.id.homeFragment) {
            Log.d("main", "on back pressed")
            finish()
        } else {
            super.onBackPressed()
        }
    }
}