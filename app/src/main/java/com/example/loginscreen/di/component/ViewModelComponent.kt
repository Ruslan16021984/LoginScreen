package com.example.loginscreen.di.component

import com.example.loginscreen.MainActivity
import com.example.loginscreen.di.module.ViewModuleModule
import com.example.loginscreen.di.scope.ViewModelScope
import dagger.Component

@ViewModelScope
@Component(modules = [ViewModuleModule::class], dependencies = [RepositoryComponent::class])
interface ViewModelComponent {
    fun inject(activity: MainActivity)
}