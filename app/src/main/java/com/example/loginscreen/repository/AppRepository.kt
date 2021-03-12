package com.example.loginscreen.repository

import com.example.loginscreen.repository.api.ServerCommunicator
import com.example.loginscreen.repository.database.AppDatabase
import com.example.loginscreen.repository.database.entity.User
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.annotations.NonNull
import io.reactivex.schedulers.Schedulers

class AppRepository(private val serverCommunicator: ServerCommunicator, private val mainDatabase: AppDatabase) {

    fun getUserFromDb(): Single<User> {
        return mainDatabase.userSign().getUser().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun postUserToServer(code: String, number: String, password: String): Single<User>? {
        return serverCommunicator.postUserSignIn2(code, number, password).flatMap {
            val fullNumber = " $code${ it.user?.phoneNumber }"
            val user = it.user?.let { it1 -> User(it1.userId, it.user?.secondName, it.user?.name, fullNumber) }
            user?.let { it1 -> mainDatabase.userSign().addUserSignUpOption(it1) }
            mainDatabase.userSign().getUser().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
        }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}