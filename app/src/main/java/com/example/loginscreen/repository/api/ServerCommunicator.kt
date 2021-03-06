package com.example.loginscreen.repository.api

import android.util.Log
import com.example.loginscreen.repository.database.entity.Status
import io.reactivex.Single
import io.reactivex.SingleTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class ServerCommunicator(private val mService: ApiService) {
    companion object{
        private val DEFAULT_TIMEOUT = 10
        private val DEFAULT_RETRY_ATTEMPTS = 4L
    }
//    fun postUserSignIn(code: String, number: String, password: String): Single<Status> {
//        return mService.postUser(code,number , password).compose(singleTransformer())
//    }
    private fun <T> singleTransformer(): SingleTransformer<T, T> = SingleTransformer {
        it.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .timeout(DEFAULT_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .retry(DEFAULT_RETRY_ATTEMPTS)
    }
    fun postUserSignIn2(code: String, number: String, password: String): Single<Status> {
        return mService.postUser(code, number, password).compose(singleTransformer())
            .doOnError { t: Throwable -> Log.d("ServerCommunicator", t.message.toString()) }
    }
}