package com.example.loginscreen.di.module

import androidx.lifecycle.ViewModelProvider
import com.example.loginscreen.domain.ViewModelProviderFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModuleFactoryModule {
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelProviderFactory): ViewModelProvider.Factory
}