package com.example.loginscreen.di.module.sign

import android.app.Application
import androidx.room.Room
import com.example.loginscreen.repository.database.AppDatabase
import com.example.loginscreen.repository.database.UserDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DbModule {
    @Singleton
    @Provides
    fun provideAppDb(app: Application): AppDatabase {
        return Room
            .databaseBuilder(app, AppDatabase::class.java, "database")
            .fallbackToDestructiveMigration() // get correct db version if schema changed
            .build()
    }
    @Singleton
    @Provides
    fun provideAuthTokenDao(db: AppDatabase): UserDao {
        return db.userSign()
    }
}