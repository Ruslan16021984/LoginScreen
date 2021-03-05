package com.example.loginscreen.repository.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.loginscreen.repository.database.entity.User

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addUserSignUpOption(userSign: User)

    @Update
    fun update(userSign: User)

    @Query("SELECT * FROM user")
    fun getUser(): User
}