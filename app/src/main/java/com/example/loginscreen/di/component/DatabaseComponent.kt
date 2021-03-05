package com.example.loginscreen.di.component

import com.example.loginscreen.di.module.DataBaseModule
import com.example.loginscreen.repository.database.AppDatabase
import dagger.Component

@Component(modules = [DataBaseModule::class])
interface DatabaseComponent {
    val database: AppDatabase
}