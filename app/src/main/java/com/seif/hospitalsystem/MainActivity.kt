package com.seif.hospitalsystem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import androidx.navigation.findNavController

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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