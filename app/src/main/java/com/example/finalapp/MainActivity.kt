package com.example.finalapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // activate up button
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.my_nav) as NavHostFragment
        navController = navHostFragment.navController
        setupActionBarWithNavController(navController)
    }//end onCreate

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() ||super.onSupportNavigateUp()
    }
}//end MainActivity