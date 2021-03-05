package com.example.loginscreen.di.module

import com.example.loginscreen.repository.database.AppDatabase
import dagger.Module
import dagger.Provides

@Module
class DataBaseModule(private val appDatabase: AppDatabase) {
    @Provides
    internal fun provideRoomDataBase(): AppDatabase{
        return appDatabase
    }
}