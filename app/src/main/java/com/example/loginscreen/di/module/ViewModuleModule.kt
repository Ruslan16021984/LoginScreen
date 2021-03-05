package com.example.loginscreen.di.module

import android.app.Application
import com.example.loginscreen.App
import com.example.loginscreen.di.scope.ViewModelScope
import com.example.loginscreen.domain.UserViewModel
import com.example.loginscreen.repository.AppRepository
import dagger.Module
import dagger.Provides

@Module
class ViewModuleModule(app: App) {
    internal var app: Application = app
    @ViewModelScope
    @Provides
    internal fun providesUserViewModel(repository: AppRepository): UserViewModel{
        return UserViewModel(app, repository)
    }
}