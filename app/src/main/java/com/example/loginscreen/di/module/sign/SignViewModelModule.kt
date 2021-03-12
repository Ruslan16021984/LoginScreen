package com.example.loginscreen.di.module.sign

import androidx.lifecycle.ViewModel
import com.example.loginscreen.domain.MyViewModelKey
import com.example.loginscreen.domain.UserViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class SignViewModelModule {
    @Binds
    @IntoMap
    @MyViewModelKey(UserViewModel::class)
    abstract fun bindUserViewModel(authViewModel: UserViewModel): ViewModel
}