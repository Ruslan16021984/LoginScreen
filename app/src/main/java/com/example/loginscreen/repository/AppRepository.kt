package com.example.loginscreen.repository

import androidx.lifecycle.LiveData
import com.example.loginscreen.repository.api.ServerCommunicator
import com.example.loginscreen.repository.database.AppDatabase
import com.example.loginscreen.repository.database.entity.Status
import com.example.loginscreen.repository.database.entity.User
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Response

class AppRepository(private val serverCommunicator: ServerCommunicator, private val mainDatabase: AppDatabase) {

    fun postUserToServer(code: String, number: String, password: String): Single<Status> {
        return serverCommunicator.postUserSignIn(code, number, password)
    }
    fun getUserFromDb():User {
       return mainDatabase.userSign().getUser()
    }
    fun addUser(user: User){
        Single.fromCallable { mainDatabase.userSign().addUserSignUpOption(user) }
            .subscribeOn(
                Schedulers.io()
            ).observeOn(AndroidSchedulers.mainThread()).subscribe()

    }
}