package com.example.loginscreen

import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.Toolbar
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.loginscreen.di.component.ViewModelComponent
import com.example.loginscreen.domain.UserViewModel
import kotlinx.android.synthetic.main.activity_main.*
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

    override fun injectDependency(component: ViewModelComponent) {
        component.inject(this)
    }
}