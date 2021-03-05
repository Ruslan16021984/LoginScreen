package com.example.loginscreen.repository.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.loginscreen.repository.database.entity.UserSign

@Database(
    entities = [UserSign::class], version = 1, exportSchema = false
)
abstract class AppDatabase: RoomDatabase() {
    abstract fun userSign(): UserDao
}