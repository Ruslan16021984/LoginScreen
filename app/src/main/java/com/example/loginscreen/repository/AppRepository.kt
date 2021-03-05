package com.example.loginscreen.repository

import androidx.lifecycle.LiveData
import com.example.loginscreen.repository.api.ServerCommunicator
import com.example.loginscreen.repository.database.AppDatabase
import com.example.loginscreen.repository.database.entity.UserSign
import io.reactivex.rxjava3.core.Single
import retrofit2.Response

class AppRepository(private val serverCommunicator: ServerCommunicator, private val mainDatabase: AppDatabase) {
    fun postUserToServer(code: String, number: String, password: String): Single<Response<UserSign>> {
        return serverCommunicator.postUserSignIn(code, number, password)
    }
    fun getUserFromDb(): LiveData<UserSign> {
       return mainDatabase.userSign().getUser()
    }
}