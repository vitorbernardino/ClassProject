package com.example.mainproject

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.example.mainproject.commons.extensions.configureToolbar
import com.example.mainproject.presentation.viewmodels.MainViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        val menuBottom = findViewById<BottomNavigationView>(R.id.bottomMenu)
        val navController = Navigation.findNavController(this,R.id.my_nav_host_fragment)

        setSupportActionBar(toolbar)

        NavigationUI.setupWithNavController(menuBottom, navController)
        configureToolbar("Home", false)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}
