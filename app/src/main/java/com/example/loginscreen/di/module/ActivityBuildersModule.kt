package com.example.loginscreen.di.module

import com.example.loginscreen.MainActivity
import com.example.loginscreen.di.module.sign.ApiModule
import com.example.loginscreen.di.module.sign.SignFragmentBuildersModule
import com.example.loginscreen.di.module.sign.SignViewModelModule
import com.example.loginscreen.di.scope.SignScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {
    @SignScope
    @ContributesAndroidInjector(
        modules = [ApiModule::class, SignFragmentBuildersModule::class, SignViewModelModule::class]
    )
    abstract fun contributeMainActivity(): MainActivity
}