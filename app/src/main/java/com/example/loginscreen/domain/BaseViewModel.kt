package com.example.loginscreen.domain

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.loginscreen.App

abstract class BaseViewModel(application: Application): AndroidViewModel(application) {
    fun getContext() = getApplication<App>()
}