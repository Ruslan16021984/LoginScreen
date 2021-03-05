package com.example.loginscreen

import android.os.Bundle
import android.util.Log
import com.example.loginscreen.di.component.ViewModelComponent
import com.example.loginscreen.domain.UserViewModel
import javax.inject.Inject

class MainActivity : BaseActivity() {
    var userViewModel: UserViewModel? = null
        @Inject set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun injectDependency(component: ViewModelComponent) {
        Log.e("injectDependency", "ViewModelComponent")
        component.inject(this)
    }
}