package com.example.loginscreen

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.navigation.Navigation

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        val navController = Navigation.findNavController(this, R.id.nav_host_fragment_container)
        navController.addOnDestinationChangedListener {
                _, _, _ ->
            toolbar.title = navController.currentDestination?.label
        }
    }

}