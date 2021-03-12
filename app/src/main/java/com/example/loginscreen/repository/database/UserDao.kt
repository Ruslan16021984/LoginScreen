package com.example.loginscreen.repository.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.loginscreen.repository.database.entity.User
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addUserSignUpOption(userSign: User): Completable

    @Update
    fun update(userSign: User): Completable

    @Query("SELECT * FROM user")
    fun getUser(): Single<User>
}