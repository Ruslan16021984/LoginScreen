package com.example.loginscreen

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.navigation.Navigation
import com.example.loginscreen.domain.UserViewModel
import javax.inject.Inject

class MainActivity : BaseActivity() {
    var userViewModel: UserViewModel? = null
        @Inject set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        val navController = Navigation.findNavController(this, R.id.nav_host_fragment_container)
        navController.addOnDestinationChangedListener {
                controller, destination, arguments ->
            toolbar.title = navController.currentDestination?.label
        }
    }

}