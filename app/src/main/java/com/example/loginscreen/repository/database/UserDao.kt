package com.example.loginscreen.repository.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.loginscreen.repository.database.entity.UserSign

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addUserSignUpOption(userSign: UserSign)

    @Update
    fun update(userSign: UserSign)

    @Query("SELECT * FROM user")
    fun getUser(): LiveData<UserSign>
}