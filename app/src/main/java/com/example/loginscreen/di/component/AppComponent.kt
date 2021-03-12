package com.example.loginscreen.di.component

import android.app.Application
import com.example.loginscreen.App
import com.example.loginscreen.di.module.ActivityBuildersModule
import com.example.loginscreen.di.module.ViewModuleFactoryModule
import com.example.loginscreen.di.module.sign.DbModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        DbModule::class,
        ActivityBuildersModule::class,
        ViewModuleFactoryModule::class
    ]
)
interface AppComponent: AndroidInjector<App>{
    @Component.Builder
    interface Builder{

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}