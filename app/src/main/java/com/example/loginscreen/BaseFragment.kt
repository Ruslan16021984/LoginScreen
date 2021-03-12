package com.example.loginscreen

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.loginscreen.domain.UserViewModel
import com.example.loginscreen.domain.ViewModelProviderFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject

abstract class BaseFragment: DaggerFragment() {
    val TAG: String = "AppDebug"
    @Inject
    lateinit var providerFactory: ViewModelProviderFactory

    lateinit var viewModel: UserViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = activity?.run {
            ViewModelProvider(this, providerFactory).get(UserViewModel::class.java)
        } ?: throw Exception("Invalid Activity")
    }
}