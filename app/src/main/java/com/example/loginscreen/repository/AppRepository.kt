package com.example.loginscreen.repository

import com.example.loginscreen.repository.api.ServerCommunicator
import com.example.loginscreen.repository.database.AppDatabase
import com.example.loginscreen.repository.database.entity.User
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class AppRepository(private val serverCommunicator: ServerCommunicator, private val mainDatabase: AppDatabase) {

    fun getUserFromDb(): Single<User> {
    return Single.fromCallable { mainDatabase.userSign().getUser()}.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
    }

    fun postUserToServer(code: String, number: String, password: String): @NonNull Single<User>? {
        return serverCommunicator.postUserSignIn2(code, number, password).flatMap {
            val fullNumber = " $code${ it.user?.phoneNumber }"
            val user = it.user?.let { it1 -> User(it1.userId, it.user?.secondName, it.user?.name, fullNumber) }
            user?.let { it1 -> mainDatabase.userSign().addUserSignUpOption(it1) }
           Single.just(mainDatabase.userSign().getUser())
        }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}