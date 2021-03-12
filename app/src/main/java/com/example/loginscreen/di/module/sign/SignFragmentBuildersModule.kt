package com.example.loginscreen.di.module.sign

import com.example.loginscreen.ProfileFragment
import com.example.loginscreen.SignInFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class SignFragmentBuildersModule {
    @ContributesAndroidInjector()
    abstract fun contributeSignInFragment(): SignInFragment

    @ContributesAndroidInjector()
    abstract fun contributeProfileFragment(): ProfileFragment
}