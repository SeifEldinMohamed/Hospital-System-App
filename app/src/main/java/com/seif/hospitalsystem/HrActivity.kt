package com.seif.hospitalsystem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment

class HrActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hr)
        setupNavigation()
    }
    private fun setupNavigation() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_hr) as NavHostFragment
        val navController = navHostFragment.navController
        // val appBarConfiguration = AppBarConfiguration.Builder(navController.graph).build()
    }
    override fun onBackPressed() {
        val navigationController = findNavController(R.id.nav_host_hr)
        if (navigationController.currentDestination?.id == R.id.hrHomeFragment) {
            Log.d("hr", "on back pressed")
            finish()
        } else {
            super.onBackPressed()
        }
    }
}